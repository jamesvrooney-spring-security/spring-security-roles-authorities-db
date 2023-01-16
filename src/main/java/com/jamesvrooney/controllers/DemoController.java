package com.jamesvrooney.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DemoController {

    @GetMapping("demo")
    @PreAuthorize("hasAuthority('read') or hasRole('ADMIN')")
    public String demo(Authentication authentication) {
        final String name = authentication.getName();

        log.info("Logged in user: {}", name);

        return "This is a demo";
    }
}
