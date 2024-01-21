package com.now.request;

import java.util.Objects;

public class WelcomeRequest {
	private String regexAnyString;
	private String mobileNumber;

	public WelcomeRequest(String text, String mobileNumber) {
		this.regexAnyString = text;
		this.mobileNumber = mobileNumber;
	}

	public String getText() {
		return regexAnyString;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setText(String text) {
		this.regexAnyString = text;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mobileNumber, regexAnyString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WelcomeRequest other = (WelcomeRequest) obj;
		return Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(regexAnyString, other.regexAnyString);
	}

	@Override
	public String toString() {
		return "WelcomeRequest [regexAnyString=" + regexAnyString + ", mobileNumber=" + mobileNumber + "]";
	}

}
