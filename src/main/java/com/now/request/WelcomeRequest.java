package com.now.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WelcomeRequest {

	private String regexAnyString;

	@NotBlank(message = "Mobile number required")
	@Pattern(regexp = "^\\+91\\d{10}$", message = "Invalid Indian mobile number")
	private String mobileNumber;

}
