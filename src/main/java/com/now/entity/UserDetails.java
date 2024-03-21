package com.now.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails  {
	@Id
	@Column(name = "mobile_number")
	private String mobileNumber;
	private String languages;
	private String selectedNewspapers;
	public UserDetails () {
	}

	public UserDetails (String mobileNumber, String languages, String selectedNewspapers) {
		this.mobileNumber = mobileNumber;
		this.languages = languages;
		this.selectedNewspapers = selectedNewspapers;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getLanguages() {
		return languages;
	}

	public String getSelectedNewspapers() {
		return selectedNewspapers;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public void setSelectedNewspapers(String selectedNewspapers) {
		this.selectedNewspapers = selectedNewspapers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(languages, mobileNumber, selectedNewspapers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails  other = (UserDetails ) obj;
		return Objects.equals(languages, other.languages) && Objects.equals(mobileNumber, other.mobileNumber)
				&& Objects.equals(selectedNewspapers, other.selectedNewspapers);
	}

	@Override
	public String toString() {
		return "User [mobileNumber=" + mobileNumber + ", languages=" + languages + ", selectedNewspapers="
				+ selectedNewspapers + "]";
	}

}
