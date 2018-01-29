package com.pol.nl.banking.corp.digisign.database;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.pol.nl.banking.corp.digisign.resource.SignRecipient;

@Component
public interface SignRecepientsRepository extends PagingAndSortingRepository<SignRecipient, Integer> {

}
