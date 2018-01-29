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
public class SignRecipient {

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="id")
    private long id;

    //private Integer clientContactId;
    
    @OneToOne
    @JoinColumn(name="client_contact_id")
    private Contact contact;

    @ManyToOne(fetch=FetchType.EAGER)
    private SignRequest signRequest;

    private String actionToTake;

    private Long sequenceNumber;
    
    @Transient
    private String contactName;

}
