package com.pol.nl.banking.corp.digisign.helper;

import java.io.IOException;

import com.pol.nl.banking.corp.digisign.resource.Client;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

public class ClientDeserializer extends StdDeserializer<Client> {

	private static final long serialVersionUID = 1L;

	protected ClientDeserializer() {
		super(Client.class);
	}
	
/*	@Autowired
	Client client;*/

	@Override
	public Client deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		int id = (Integer) ((IntNode) node.get("value")).numberValue();
        String name = node.get("label").asText();
        
       /* this.client.setId(id);
        this.client.setName(name);*/
		return new Client(id, name);
	}

}
