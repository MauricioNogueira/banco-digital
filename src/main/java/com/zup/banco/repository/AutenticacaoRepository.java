package com.zup.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.banco.models.Autenticacao;

public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long> {
	long deleteByToken(String token);
}
