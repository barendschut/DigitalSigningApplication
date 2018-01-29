package com.pol.nl.banking.corp.digisign.processors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pol.nl.banking.corp.digisign.database.ClientRepository;
import com.pol.nl.banking.corp.digisign.database.ContactRepository;
import com.pol.nl.banking.corp.digisign.resource.Client;
import com.pol.nl.banking.corp.digisign.resource.Contact;

@Component
public class DataSupportProcessor {
	
	@Autowired
	ClientRepository clientsRepository;
	
	@Autowired
	ContactRepository contactsRepository;
	
	@Autowired
	Client client;

	public List<Client> getAvailableClients() {
		return clientsRepository.findAll();
	}

	public List<Contact> getContactsForClient(long clientId) {
		client.setId(clientId);
		return contactsRepository.finByClientId(this.client);
	}


}
