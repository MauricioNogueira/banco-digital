package com.zup.banco.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zup.banco.email.SendEmail;
import com.zup.banco.models.Cliente;
import com.zup.banco.models.Conta;
import com.zup.banco.repository.ClienteRepository;
import com.zup.banco.service.ContaService;

@Component
@EnableScheduling
public class ScheduleSendEmailClienteAceito {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private SendEmail sendEmail;
	
	@Autowired
	private ContaService contaService;
	
	private final long TIME = 4000;
	
	@Scheduled(fixedDelay = TIME)
	public void run() {
		List<Cliente> clientes = this.clienteRepository.findByAceitoAndEnviado(true, false);
		
		
		clientes.forEach(cliente -> {			
			Conta conta = this.contaService.criarConta();
			cliente.setConta(conta);
			String titulo = "Dados da sua conta";
			String texto = "Agencia: "+cliente.getConta().getAgencia()+" | codigo do banco: "+cliente.getConta().getCodigoBanco()+" | Conta: "+cliente.getConta().getConta();
			boolean isSend = this.sendEmail.sendNotification(cliente.getEmail(), titulo, texto);
			cliente.setEnviado(isSend);
			
			this.clienteRepository.save(cliente);
		});
	}
}
