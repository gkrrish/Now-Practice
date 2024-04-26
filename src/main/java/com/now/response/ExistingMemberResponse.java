package com.now.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExistingMemberResponse {
	private String mobileNumber;
	private String languages;
	private String selectedNewspapers;

}
