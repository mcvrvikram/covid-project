package com.vikram.covid19tracker.models;

public class LocationStat {

	
	private String state;
	private String country;
	private String latestTotalCases;
	private String newCases;
	
	public String getNewCases() {
		return newCases;
	}
	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLatestTotalCases() {
		return latestTotalCases;
	}
	public void setLatestTotalCases(String latestTotalCases) {
		this.latestTotalCases = latestTotalCases;
	}
	
	@Override
	public String toString() {
		return "LocationStat [state=" + state + ", country=" + country + ", latestTotalCases=" + latestTotalCases
				+ ", newCases=" + newCases + "]";
	}
	
}
