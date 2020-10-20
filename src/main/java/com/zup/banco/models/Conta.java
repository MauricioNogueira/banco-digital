package com.zup.banco.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private String senha;
	@OneToOne(mappedBy = "conta")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "autenticacao_id", referencedColumnName = "id")
	private Autenticacao autenticacao;
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Autenticacao getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(Autenticacao autenticacao) {
		this.autenticacao = autenticacao;
	}
}
