package com.pol.nl.banking.corp.digisign.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pol.nl.banking.corp.digisign.resource.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
