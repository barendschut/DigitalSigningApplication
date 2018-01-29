package com.pol.nl.banking.corp.digisign.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pol.nl.banking.corp.digisign.resource.Client;
import com.pol.nl.banking.corp.digisign.resource.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Query("SELECT cont FROM Contact cont where cont.client = :client")
	List<Contact> finByClientId(@Param("client") Client client);

}
