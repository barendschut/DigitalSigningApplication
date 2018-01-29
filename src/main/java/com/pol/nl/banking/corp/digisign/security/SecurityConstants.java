package com.pol.nl.banking.corp.digisign.security;

import java.util.Arrays;
import java.util.List;

public class SecurityConstants {
    public static final String SECRET = "DigiSignAppSecretKeyToGenerateJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
	public static final String LOGIN_URL = "/login";
	
	//For CORS
	public static final List<String> ALLOWED_ORIGIN = Arrays.asList("*");
	public static final List<String> ALLOWED_HEADERS = Arrays.asList("Content-Type","Allow","Authorization","X-Response-Time");
	public static final List<String> ALLOWED_METHODS = Arrays.asList("GET","POST","PUT","OPTIONS");
}
