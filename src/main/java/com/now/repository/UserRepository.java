package com.now.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.now.entity.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	@Query(value = "SELECT * FROM user_details WHERE mobilenumber = :mobileNumber", nativeQuery = true)
    UserDetails getMine(@Param("mobileNumber") String mobileNumber);

}
