package com.now.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
	@Id
	@Column(name = "mobile_number")
	private String mobileNumber;
	private String languages;
	private String selectedNewspapers;

}
