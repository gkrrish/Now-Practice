package com.other;

import com.google.gson.Gson;

public class StudentRecord {

	private String generalRank;
	private String hallTicketNumber;
	private String marksFor300;
	private String gender;
	private String community;
	private String ews;
	private String ph;
	private String exServicemen;
	private String sports;
	private String localDistrict;

	public String getGeneralRank() {
		return generalRank;
	}

	public String getHallTicketNumber() {
		return hallTicketNumber;
	}

	public String getMarksFor300() {
		return marksFor300;
	}

	public String getGender() {
		return gender;
	}

	public String getCommunity() {
		return community;
	}

	public String getEws() {
		return ews;
	}

	public String getPh() {
		return ph;
	}

	public String getExServicemen() {
		return exServicemen;
	}

	public String getSports() {
		return sports;
	}

	public String getLocalDistrict() {
		return localDistrict;
	}

	public void setGeneralRank(String generalRank) {
		this.generalRank = generalRank;
	}

	public void setHallTicketNumber(String hallTicketNumber) {
		this.hallTicketNumber = hallTicketNumber;
	}

	public void setMarksFor300(String marksFor300) {
		this.marksFor300 = marksFor300;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public void setEws(String ews) {
		this.ews = ews;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public void setExServicemen(String exServicemen) {
		this.exServicemen = exServicemen;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	public void setLocalDistrict(String localDistrict) {
		this.localDistrict = localDistrict;
	}

	public StudentRecord() {
	}

	public StudentRecord(String generalRank, String hallTicketNumber, String marksFor300, String gender,
			String community, String ews, String ph, String exServicemen, String sports, String localDistrict) {
		super();
		this.generalRank = generalRank;
		this.hallTicketNumber = hallTicketNumber;
		this.marksFor300 = marksFor300;
		this.gender = gender;
		this.community = community;
		this.ews = ews;
		this.ph = ph;
		this.exServicemen = exServicemen;
		this.sports = sports;
		this.localDistrict = localDistrict;
	}
	
	public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
