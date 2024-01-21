package com.now.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.now.entity.User;
import com.now.repository.UserRepository;
import com.now.response.ExistingMemberResponse;
import com.now.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	private final UserRepository userRepository;

	@Autowired
	public UserRegistrationServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean isMobileNumberPresent(String mobileNumber) {
		return userRepository.existsByMobileNumber(mobileNumber);
	}

	@Override
	public ExistingMemberResponse getSubscriptionDetails(String mobileNumber) {
		Optional<User> userOptional = userRepository.findByMobileNumber(mobileNumber);
		User user = new User();
		if (userOptional.isPresent()) {
			user = userOptional.get();
		}
		ExistingMemberResponse response = new ExistingMemberResponse();
		response.setMobileNumber(user.getMobileNumber());
		response.setLanguages(user.getLanguages());
		response.setSelectedNewspapers(user.getSelectedNewspapers());

		return response;
	}

}
