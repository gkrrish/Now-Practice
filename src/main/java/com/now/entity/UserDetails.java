package com.now.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER_DETAILS")
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private Long userId;

	@Column(name = "Mobilenumber", length = 13)
	private String mobileNumber;

	@Column(name = "Username", length = 50)
	private String username;

	@Column(name = "Age")
	private Integer age;

	@Column(name = "Gender", length = 10)
	private String gender;

	@Column(name = "Location", length = 100)
	private String location;

	@Column(name = "Registrationdate", nullable = false, updatable = false)
	private Timestamp registrationDate;

	@Column(name = "Active", length = 1)
	private String active;

}
