package com.now.response;

import java.util.List;
import java.util.Objects;

public class WelcomeResponse {
	private String message;
	private List<String> language;

	public WelcomeResponse() {
	}

	public WelcomeResponse(String message, List<String> language) {
		this.message = message;
		this.language = language;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getLanguage() {
		return language;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setLanguage(List<String> language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		return Objects.hash(language, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WelcomeResponse other = (WelcomeResponse) obj;
		return Objects.equals(language, other.language) && Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "WelcomeResponse [message=" + message + ", language=" + language + "]";
	}

}
