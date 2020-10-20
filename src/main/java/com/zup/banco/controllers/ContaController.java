package com.zup.banco.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.banco.formvalidation.FormGeraSenha;
import com.zup.banco.formvalidation.FormPrimeiroAcessoConta;
import com.zup.banco.response.Response;
import com.zup.banco.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@PostMapping("/acessar")
	public ResponseEntity<Response> primeiroAcesso(@Valid @RequestBody FormPrimeiroAcessoConta form) {
		
		Response response = this.contaService.primeiroAcesso(form);
		
		if (response.getCode() == 1) {
			return ResponseEntity.ok(response);
		}
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@PostMapping("/gerar-senha")
	public ResponseEntity<Response> gerarSenhaAcesso(@Valid @RequestBody FormGeraSenha form) {
		Response response = this.contaService.gerarSenhaDeAcesso(form);
		
		if (response.getCode() == 1) {
			return ResponseEntity.ok(response);
		}
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@PostMapping("/transferencias")
	public void recebeTransferencia() {
		
	}
}
