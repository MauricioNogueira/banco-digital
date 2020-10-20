package com.zup.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.banco.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByAceitoAndEnviado(boolean aceito, boolean enviado);
}
