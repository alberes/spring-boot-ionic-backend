package com.nelioalves.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SmtpEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(SimpleMailMessage message) {
		LOG.info("Enviando de email");
		mailSender.send(message);
		LOG.info(message.toString());
		LOG.info("Email enviado");
	}
	
	@Override
	public void sendHtmlEmail(MimeMessage message) {
		LOG.info("Enviando de email HTML...");
		javaMailSender.send(message);
		LOG.info(message.toString());
		LOG.info("Email enviado");
	}

}
