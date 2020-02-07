package com.bridgelabz.usermanage.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;


@Component
public class Jms {
	
	@Autowired
	MailSender javamail;
	
	
	public void sendMail(String email,String token) {
		
		SimpleMailMessage smm = new SimpleMailMessage();
		
		smm.setSubject("Token Mail");
		smm.setFrom("fake12@gmail.com");
		smm.setTo(email);	
		smm.setText(token);		
		javamail.send(smm);
	}
	
}
