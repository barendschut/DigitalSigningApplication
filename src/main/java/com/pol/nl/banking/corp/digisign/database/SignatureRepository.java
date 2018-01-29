package com.pol.nl.banking.corp.digisign.database;


import com.pol.nl.banking.corp.digisign.resource.Signature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignatureRepository extends JpaRepository<Signature, Long> {
}
