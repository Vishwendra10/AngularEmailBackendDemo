package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.Email;
import com.email.entity.EmailResponse;
import com.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PostMapping("/send")
	public ResponseEntity<EmailResponse> sendEmail(@RequestBody Email email){
		
		//Email email= new Email();
//		email.setMessage("test message");
//		email.setSender("technoshape02@gmail.com");
//		email.setReveiver("vishwendra.sing11@gmail.com");
//		email.setSubject("test subject");
		
		email.setMessage(email.getMessage());
		email.setSender("technoshape02@gmail.com");
		email.setReceiver(email.getReceiver());
		email.setSubject(email.getSubject());
		
		String response= this.emailService.sendEmail(email);
		
		if(response.equalsIgnoreCase("success")) {
			return new ResponseEntity<EmailResponse>(new EmailResponse("Sent successfully"),HttpStatus.OK);
		}
		return new ResponseEntity<EmailResponse>(new EmailResponse("NOT Sent successfully"),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
