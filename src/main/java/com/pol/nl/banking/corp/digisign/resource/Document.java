package com.pol.nl.banking.corp.digisign.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = {"signRequest"})
public class Document {

    @GeneratedValue
    @Id
    private long id;

    @ManyToOne(fetch=FetchType.EAGER)
    private SignRequest signRequest;

    private String fileName;

    private String actionToTake;

    private byte[] documentData;

}
