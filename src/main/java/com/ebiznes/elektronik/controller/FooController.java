package com.ebiznes.elektronik.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class FooController {

    @GetMapping
    @SecurityRequirement(name = "jwt")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String restricted() {
        return "1337";
    }
}
