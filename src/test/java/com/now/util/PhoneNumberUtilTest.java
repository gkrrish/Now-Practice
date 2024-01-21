package com.now.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PhoneNumberUtilTest {

	@Test
	void testvalidateMobileNumber_validNumber_IndianNumbers() {
		String input = StringUtil.INDIAN_MOBILE_NUMBER_PREFIX + "9876543210";
		String result = PhoneNumberUtil.validateMobileNumber(input);
		assertEquals("9876543210", result);
	}

	@Test
	void testvalidateMobileNumber_withHypern_InvalidFormatNumber() {
		String input = "+91-9876543210";
		String result = PhoneNumberUtil.validateMobileNumber(input);
		assertNull(result);
	}

	@Test
	void testExtractMobileNumber_withoutCountryCode_NoMatch() {
		String input = "9876543210";
		String result = PhoneNumberUtil.validateMobileNumber(input);
		assertNull(result);

	}

	@Test
	void testvalidateMobileNumber_withoutDifferentCountryCode() {

		String input = "+449876543210";
		String result = PhoneNumberUtil.validateMobileNumber(input);
		assertNull(result);

	}

	@Test
	void testvalidateMobileNumber_invalidFormatNumber() {
		String input = "+9198765";
		String result = PhoneNumberUtil.validateMobileNumber(input);
		assertNull(result);
	}

	@Test
	void testvalidateMobileNumber_NullInput() {
		String input = null;
		String result = PhoneNumberUtil.validateMobileNumber(input);
		assertNull(result);
	}

	@Test
	void testvalidateMobileNumber_emptyInput() {
		String input = "";
		String result = PhoneNumberUtil.validateMobileNumber(input);
		assertNull(result);
	}

}
