package com.noh.resourceserver.controller;

import com.noh.resourceserver.model.CustomPrincipal;
import com.noh.resourceserver.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/auth")
@PreAuthorize("hasAuthority('role_admin')")
public class AuthController {

//    @GetMapping("/add")
//    public String add(User user) {
//        System.out.println("user " + principal);
//        return principal.getUsername() + " " + principal.getEmail();
//    }

}
