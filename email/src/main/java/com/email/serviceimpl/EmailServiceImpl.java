package com.email.serviceimpl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.email.entity.Email;
import com.email.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	public String sendEmail(Email email) {
		
		boolean flag=false;
		
		String host="smtp.gmail.com";
		
		Properties properties= System.getProperties();
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");	
		
		Session session =Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("technoshape02@gmail.com","Poiuytrewq@1234567890");	
				}
			
		});
		
		session.setDebug(true);
		
		MimeMessage m= new MimeMessage(session);
		
		try {
			//setting the values
			m.setFrom(email.getSender());
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getReceiver()));
			m.setSubject(email.getSubject());
			m.setText(email.getMessage());
			
			//Transport.send(m);
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(flag) {
			return "Success";
		}
		return "Not success";
	}

}
