package com.techelevator.model;

public class Survey {

	private int id;
	private String code;
	private String email;
	private String state;
	private String activityLevel;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id; 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
