package com.pol.nl.banking.corp.digisign.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.pol.nl.banking.corp.digisign.helper.ClientDeserializer;
import com.pol.nl.banking.corp.digisign.helper.ClientSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
@JsonSerialize(using = ClientSerializer.class)
@JsonDeserialize(using = ClientDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

	@GeneratedValue
    @Id
    private long id;

    private String name;
    

}
