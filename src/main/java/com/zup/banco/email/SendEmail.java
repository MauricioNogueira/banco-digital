package com.zup.banco.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public SendEmail(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public boolean sendNotification(String email, String titulo, String mensagem) {
		try {			
			System.out.println("Enviando email...");
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(email);
			mail.setFrom(this.fromMail);
			mail.setSubject(titulo);
			mail.setText(mensagem);
			
			this.javaMailSender.send(mail);
			System.out.println("Email enviado");			
			return true;
		} catch (MailSendException e) {
			e.printStackTrace();
			System.out.println("Erro ao enviar email");
			return false;
		}
	}
}
