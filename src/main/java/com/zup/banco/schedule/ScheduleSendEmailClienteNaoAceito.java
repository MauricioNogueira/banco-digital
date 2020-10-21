package com.zup.banco.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zup.banco.email.SendEmail;
import com.zup.banco.models.Cliente;
import com.zup.banco.repository.ClienteRepository;

@Component
@EnableScheduling
public class ScheduleSendEmailClienteNaoAceito {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private SendEmail sendEmail;
	
	private final long TIME = 4000;
	
	@Scheduled(fixedDelay = TIME)
	public void run() {
		List<Cliente> clientes = this.clienteRepository.findByAceitoAndEnviado(false, false);
		
		clientes.forEach(cliente -> {
			String titulo = "Cadastro pendente";
			String texto = "Venha fazer parte da nossa equipe";
			boolean isSend = this.sendEmail.sendNotification(cliente.getEmail(), titulo, texto);
			cliente.setEnviado(isSend);
			
			this.clienteRepository.save(cliente);
		});
	}
}
