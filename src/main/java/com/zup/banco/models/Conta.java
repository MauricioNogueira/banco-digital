package com.zup.banco.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contas")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String agencia;
	private String conta;
	private String codigoBanco;
	private double saldo;
	@OneToOne(mappedBy = "conta")
	private Cliente cliente;
	
	public Conta() {}
	
	public Conta(String agencia, String conta, String codigoBanco) {
		this.agencia = agencia;
		this.conta = conta;
		this.codigoBanco = codigoBanco;
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public String getConta() {
		return conta;
	}
	
	public String getCodigoBanco() {
		return codigoBanco;
	}

	public Cliente getCliente() {
		return cliente;
	}
}
