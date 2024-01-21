package com.now.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {

	public static String validateMobileNumber(String input) {
		if (input == null) {
			return null;
		}
		String regex = "\\+91(\\d{10})";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return null;
		}
	}

}
