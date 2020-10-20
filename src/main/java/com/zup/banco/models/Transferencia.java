package com.zup.banco.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transferencias")
public class Transferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "valor_transferencia")
	private double valorTransferencia;
	
	@Column(name = "data_realizacao")
	private String dataRealizacao;
	
	@Column(name = "documento_identificador")
	private String documentoIdentificador;
	
	@Column(name = "banco_origem")
	private String bancoOrigem;
	
	@Column(name = "conta_origem")
	private String contaOrigem;
	
	@Column(name = "agencia_origem")
	private String agenciaOrigem;
	
	@Column(name = "codigo_unico")
	private String codigoUnico;
	
	@Column(name = "agencia_destino")
	private String agenciaDestino;
	
	@Column(name = "conta_destino")
	private String contaDestino;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="conta_id", nullable=false)
	private Conta conta;

	public double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public String getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public String getDocumentoIdentificador() {
		return documentoIdentificador;
	}

	public void setDocumentoIdentificador(String documentoIdentificador) {
		this.documentoIdentificador = documentoIdentificador;
	}

	public String getBancoOrigem() {
		return bancoOrigem;
	}

	public void setBancoOrigem(String bancoOrigem) {
		this.bancoOrigem = bancoOrigem;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getAgenciaOrigem() {
		return agenciaOrigem;
	}

	public void setAgenciaOrigem(String agenciaOrigem) {
		this.agenciaOrigem = agenciaOrigem;
	}

	public String getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public String getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(String agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}
}
