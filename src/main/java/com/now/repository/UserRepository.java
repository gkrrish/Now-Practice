package com.now.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.now.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, String> {

	boolean existsByMobileNumber(String mobileNumber);

	Optional<UserDetails > findByMobileNumber(String mobileNumber);

}
