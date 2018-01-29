package com.pol.nl.banking.corp.digisign.helper;

import java.io.IOException;

import com.pol.nl.banking.corp.digisign.resource.Client;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ClientSerializer extends StdSerializer<Client> {

	public ClientSerializer() {
		super(Client.class);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void serialize(Client value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		jgen.writeNumberField("value", value.getId());
        jgen.writeStringField("label", value.getName());
        jgen.writeEndObject();
	}
	
}