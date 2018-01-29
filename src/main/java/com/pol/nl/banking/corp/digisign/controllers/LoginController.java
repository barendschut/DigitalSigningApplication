package com.pol.nl.banking.corp.digisign.controllers;

import com.pol.nl.banking.corp.digisign.resource.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Login Controller - API to handle app login.
 *
 */
@RestController
public class LoginController {

    @RequestMapping(method = RequestMethod.POST, path = "/login", produces = "application/json")
    public ResponseEntity<?> performLogin(@RequestBody Login loginInfo) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login", produces = "application/text")
    public String performLogin() {
        return "Hello World";
    }
}
