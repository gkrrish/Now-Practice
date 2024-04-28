package com.now.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.now.entity.UserDetails;
import com.now.repository.UserRepository;
import com.now.response.ExistingMemberResponse;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserRepository userRepository;

	public UserDetails isMobileNumberPresent(String mobileNumber) {
		return userRepository.getMine(mobileNumber);
	}

	public ExistingMemberResponse getSubscriptionDetails(String mobileNumber) {

		UserDetails userOptional = userRepository.getMine(mobileNumber);
		UserDetails user = new UserDetails();
		

		/*
		 * UserDetails user = new UserDetails();
		 * 
		 * user.setLanguages("Telugu"); user.setMobileNumber(mobileNumber);
		 * user.setSelectedNewspapers("Telugu"); ExistingMemberResponse response = new
		 * ExistingMemberResponse(); response.setMobileNumber(user.getMobileNumber());
		 * response.setLanguages(user.getLanguages());
		 * response.setSelectedNewspapers(user.getSelectedNewspapers());
		 */

		return null;
	}

}
