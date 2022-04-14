package br.com.hioktec.votacaoonlinemicroservice.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("votacao")
public class VotacaoModel {

	@Id
	private String id;
	
	private ParticipanteModel participante;
	
	private LocalDateTime dataHora;
}
