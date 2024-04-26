package com.now.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	
	private static final String INDIAN_MOBILE_NUMBER_PREFIX = "+91";

    @Test
    @DisplayName("Valid Indian Mobile Number")
    void testValidateMobileNumber_ValidNumber_IndianNumbers() {
        String input = INDIAN_MOBILE_NUMBER_PREFIX + "9876543210";
        String result = PhoneNumberUtil.validateMobileNumber(input);
        assertEquals("9876543210", result);
    }

    @ParameterizedTest
    @DisplayName("Invalid Mobile Number Formats")
    @ValueSource(strings = {
            "+91-9876543210",  
            "9876543210",       
            "+449876543210",   
            "+9198765"         
    })
    void testValidateMobileNumber_InvalidFormats(String input) {
        assertNull(PhoneNumberUtil.validateMobileNumber(input));
    }

    @ParameterizedTest
    @DisplayName("Null and Empty Inputs")
    @ValueSource(strings = { ""," "})
    void testValidateMobileNumber_NullOrEmptyInput(String input) {
        assertNull(PhoneNumberUtil.validateMobileNumber(input));
    }

}
