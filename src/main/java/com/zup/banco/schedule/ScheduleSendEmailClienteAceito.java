package com.zup.banco.schedule;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zup.banco.email.SendEmail;
import com.zup.banco.models.Cliente;
import com.zup.banco.models.Conta;
import com.zup.banco.repository.ClienteRepository;
import com.zup.banco.service.BancoService;

@Component
@EnableScheduling
public class ScheduleSendEmailClienteAceito {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private SendEmail sendEmail;
	
	@Autowired
	private BancoService bancoService;
	
	private final long TIME = 4000;
	
	@Scheduled(fixedDelay = TIME)
	public void run() {
		List<Cliente> clientes = this.clienteRepository.findByAceitoAndEnviado(true, false);
		
		
		clientes.forEach(cliente -> {			
			Conta conta = this.bancoService.criarConta();
			cliente.setConta(conta);
			boolean isSend = this.sendEmail.sendNotification(cliente);
			cliente.setEnviado(isSend);
			
			this.clienteRepository.save(cliente);
		});
	}
}
