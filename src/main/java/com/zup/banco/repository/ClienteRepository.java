package com.zup.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.banco.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
