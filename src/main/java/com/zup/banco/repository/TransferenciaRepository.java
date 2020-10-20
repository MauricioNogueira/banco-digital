package com.zup.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.banco.models.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
	Transferencia findByCodigoUnico(String codigoUnico);
	
}
