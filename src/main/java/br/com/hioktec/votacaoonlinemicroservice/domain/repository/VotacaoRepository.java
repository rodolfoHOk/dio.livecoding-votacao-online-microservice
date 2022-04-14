package br.com.hioktec.votacaoonlinemicroservice.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.hioktec.votacaoonlinemicroservice.domain.model.VotacaoModel;

public interface VotacaoRepository extends MongoRepository<VotacaoModel, String>{

}
