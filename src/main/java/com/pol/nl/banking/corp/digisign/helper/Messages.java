package com.pol.nl.banking.corp.digisign.helper;

import java.util.ArrayList;
import java.util.List;

public class Messages {

	private List<Message> messages=null;
	
	public Messages(){
		this.messages = new ArrayList<Message>();
	}
	
	public Messages(List<Message> messageList){
		this.messages=messageList;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void addMessages(List<Message> messages) {	
		this.messages.addAll(messages);
	}
	
	public void addMessage(Message message) {	
		this.messages.add(message);
	}
}
