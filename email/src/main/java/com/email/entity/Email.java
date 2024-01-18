package com.email.entity;

public class Email {
	
	private String sender;
	private String subject;
	private String receiver;
	private String message;
	public String getSender() {
		return sender;
	}
	
	
	
	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String reveiver) {
		this.receiver = reveiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "Email [sender=" + sender + ", subject=" + subject + ", reveiver=" + receiver + ", message=" + message
				+ "]";
	}
	
	

}
