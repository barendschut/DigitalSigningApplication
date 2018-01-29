package com.pol.nl.banking.corp.digisign.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.pol.nl.banking.corp.digisign.helper.ContactSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonSerialize(using = ContactSerializer.class)
public class Contact {

    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String name;

    private String email;

    private String role;
    
}
