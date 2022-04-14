package br.com.hioktec.votacaoonlinemicroservice.domain.service;

import java.time.LocalDateTime;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hioktec.votacaoonlinemicroservice.domain.model.ParticipanteModel;
import br.com.hioktec.votacaoonlinemicroservice.domain.model.VotacaoModel;
import br.com.hioktec.votacaoonlinemicroservice.domain.repository.VotacaoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class VotacaoService {
	
	private final VotacaoRepository repository;

	@KafkaListener(topics = "votacao", groupId = "MicroServicoVotacao")
	private void executar(ConsumerRecord<String, String> registro) {
		
		String participanteStr = registro.value();
		
		ObjectMapper mapper = new ObjectMapper();
		ParticipanteModel participante = null;
		
		try {
			participante = mapper.readValue(participanteStr, ParticipanteModel.class);
		} catch (JsonProcessingException ex) {
			log.error("Falha ao converter voto [{}]", participanteStr, ex);
			return;
		}
		
		log.info("Voto recebido = {}", participante);
		
		VotacaoModel votacao = new VotacaoModel(null, participante, LocalDateTime.now());
		VotacaoModel entity = repository.save(votacao);
		
		log.info("Votação registrado com sucesso [id={}, dataHora={}]", entity.getId(), entity.getDataHora());
	}
}
