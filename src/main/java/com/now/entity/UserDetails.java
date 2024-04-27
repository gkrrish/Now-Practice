package com.now.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name = "UserID")
	private Long userId;

	@Column(name = "Username")
	private String username;

	@Column(name = "Age")
	private Integer age;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Location")
	private String location;

	@Column(name = "RegistrationDate")
	private Timestamp registrationDate;

	@Column(name = "Active")
	private Character active;
}
