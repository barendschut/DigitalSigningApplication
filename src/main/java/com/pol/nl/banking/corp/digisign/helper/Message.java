package com.pol.nl.banking.corp.digisign.helper;

public class Message {
	
	private String messageKey;
		
	private MessageType messageType;
	
	private String messageText;
	
	private String fieldName;
	
	public Message(String messageKey, MessageType messageType){
		this.messageKey=messageKey;
		this.messageType=messageType;
	}
	
	public  Message(String messageKey, MessageType messageType, String messageText){
		this.messageKey=messageKey;
		this.messageType=messageType;
		this.messageText=messageText;
	}

	public  Message(String messageKey, MessageType messageType, String messageText,String fieldName){
		this.messageKey=messageKey;
		this.messageType=messageType;
		this.messageText=messageText;
		this.fieldName=fieldName;
	}
	
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public String getMessageText() {
		return messageText;
	}

	public MessageType getMessageType() {
		return messageType;
	}
	
}
