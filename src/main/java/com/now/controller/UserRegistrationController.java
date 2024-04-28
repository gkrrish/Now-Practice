package com.now.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.now.entity.UserDetails;
import com.now.request.WelcomeRequest;
import com.now.service.UserRegistrationService;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userRegistrationService;

	@PostMapping("/welcome") // fake number charges check-whatsapp-bussiness
	public ResponseEntity<?> welcomeUser(@RequestBody WelcomeRequest welcomeRequest) {
		
		UserDetails userDetails = userRegistrationService.isMobileNumberPresent(welcomeRequest.getMobileNumber());
		System.out.println(userDetails.getMobileNumber());
		
		return ResponseEntity.ok("welcome-okay");

	}
}
