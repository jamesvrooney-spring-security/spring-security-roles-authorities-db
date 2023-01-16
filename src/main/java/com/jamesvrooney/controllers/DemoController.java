package com.jamesvrooney.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("demo")
    @PreAuthorize("hasAuthority('read') or hasRole('ADMIN')")
    public String demo() {
        return "This is a demo";
    }
}
