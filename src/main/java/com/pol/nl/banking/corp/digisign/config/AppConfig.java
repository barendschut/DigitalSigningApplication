package com.pol.nl.banking.corp.digisign.config;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class AppConfig {

	
	private HashMap<String, String> responseContentTypes;
	

	public HashMap<String, String> getResponseContentTypes() {
		return responseContentTypes;
	}

	public void setResponseContentTypes(HashMap<String, String> responseContentTypes) {
		this.responseContentTypes = responseContentTypes;
	}
	
	
	
	
    
    
	
}
