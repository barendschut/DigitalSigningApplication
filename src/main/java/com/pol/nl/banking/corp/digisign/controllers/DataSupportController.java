package com.pol.nl.banking.corp.digisign.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pol.nl.banking.corp.digisign.processors.DataSupportProcessor;
import com.pol.nl.banking.corp.digisign.resource.Client;
import com.pol.nl.banking.corp.digisign.resource.Contact;

@RestController
public class DataSupportController {

	@Autowired
	DataSupportProcessor processor;
	
	@RequestMapping(method = RequestMethod.GET, path = "/clients")
    public List<Client> getAvailableClients() throws SQLException {
        return processor.getAvailableClients();
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/contacts/{clientId}")
    public List<Contact> getContactsForClient(@PathVariable long clientId) throws SQLException {
        return processor.getContactsForClient(clientId);
    }
	
}
