package com.zup.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.banco.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	Conta findByConta(String conta);
}
