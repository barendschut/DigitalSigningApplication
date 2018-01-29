package com.pol.nl.banking.corp.digisign.database;

import com.pol.nl.banking.corp.digisign.resource.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
