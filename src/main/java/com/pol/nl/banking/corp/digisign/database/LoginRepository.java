package com.pol.nl.banking.corp.digisign.database;


import com.pol.nl.banking.corp.digisign.resource.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}
