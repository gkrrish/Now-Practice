package com.now.service;

import org.springframework.stereotype.Service;

import com.now.response.ExistingMemberResponse;

@Service
public interface UserRegistrationService {
	
	public boolean isMobileNumberPresent(String mobileNumber);
	public ExistingMemberResponse getSubscriptionDetails(String mobileNumber);

}
