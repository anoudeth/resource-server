package com.noh.resourceserver.controller;

import com.noh.resourceserver.model.CustomPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  ResourceController {

	@GetMapping("/admins")
	@PreAuthorize("hasAuthority('role_admin')")
	public String context() {

		System.out.println("path admin");
		CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return principal.getUsername() + " " + principal.getEmail();
	}

	@GetMapping("/users")
	@PreAuthorize("hasAnyAuthority('role_admin','role_user')")
	public String secured(CustomPrincipal principal) {
		System.out.println("user " + principal);
		return principal.getUsername() + " " + principal.getEmail();
	}

	@GetMapping("/partner")
	@PreAuthorize("hasAnyAuthority('role_partner')")
	public String partner() {
		return "hello partner";
	}

	@GetMapping("/common")
	public String general() {
		return "common api success";
	}
	
}
