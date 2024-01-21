package com.now.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.now.exceptions.InvalidMobileNumberException;
import com.now.request.WelcomeRequest;
import com.now.response.ExistingMemberResponse;
import com.now.response.WelcomeResponse;
import com.now.service.UserRegistrationService;
import com.now.util.PhoneNumberUtil;
import com.now.util.StringUtil;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userRegistrationService;

	// this code seems to be not standard, later it should be re-factored, initial end-points only these are.

	@PostMapping("/welcome")
	public ResponseEntity<?> welcomeUser(@RequestBody WelcomeRequest request) {

		String validMobileNumber = null;
		validMobileNumber = PhoneNumberUtil.validateMobileNumber(request.getMobileNumber());

		if (validMobileNumber == null) {
			throw new InvalidMobileNumberException("Mobile Number is not valid");
		}

		if (userRegistrationService.isMobileNumberPresent(validMobileNumber)) {
			ExistingMemberResponse subscriptionDetails = userRegistrationService.getSubscriptionDetails(validMobileNumber);
			return ResponseEntity.ok(subscriptionDetails);
		} else {
			WelcomeResponse welcomeResponse = new WelcomeResponse();
			welcomeResponse.setMessage("Welcome ! News on whatsApp service, we glad to hear! that you are intrested! please select the below newspapers we are going to send on scheuled time daily" );
			welcomeResponse.setLanguage(StringUtil.LANGUAGE_LIST);
			return ResponseEntity.ok(welcomeResponse);
		}

	}
}
