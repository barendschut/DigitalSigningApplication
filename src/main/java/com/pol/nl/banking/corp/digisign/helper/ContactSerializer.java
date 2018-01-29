package com.pol.nl.banking.corp.digisign.helper;

import java.io.IOException;

import com.pol.nl.banking.corp.digisign.resource.Contact;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ContactSerializer extends StdSerializer<Contact> {

	public ContactSerializer() {
		super(Contact.class);
	}
	private static final long serialVersionUID = 1L;

	@Override
	public void serialize(Contact value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		jgen.writeNumberField("value", value.getId());
        jgen.writeStringField("label", value.getName());
        jgen.writeStringField("email", value.getEmail());
        jgen.writeStringField("role", value.getRole());
        jgen.writeEndObject();
	}
	
}