package com.pol.nl.banking.corp.digisign.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Signature {

    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document Document;

    @ManyToOne
    @JoinColumn(name = "sign_recipient_id")
    private SignRecipient signRecipient;

    private String actionTaken;

    private byte[] signature;

    private Instant actionTimestamp;
    //private LocalDateTime actionTimestamp;

}
