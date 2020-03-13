package com.techelevator.model;

public class Park {

	private String code;
	private String name;
	private String state;
	private int acreage;
	private int elevation;
	private double milesOfTrail;
	private int numOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitors;
	private String quote;
	private String quoteSource;
	private String description;
	private int entryFee;
	private int numOfSpecies;
	private int surveyCount;
	private String image;
//	private String shortDescription; 

	public String getImage() {
		image = code.toLowerCase();
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public int getElevation() {
		return elevation;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public int getNumOfCampsites() {
		return numOfCampsites;
	}

	public void setNumOfCampsites(int numOfCampsites) {
		this.numOfCampsites = numOfCampsites;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	public int getAnnualVisitors() {
		return annualVisitors;
	}

	public void setAnnualVisitors(int annualVisitors) {
		this.annualVisitors = annualVisitors;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getQuoteSource() {
		return quoteSource;
	}

	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}

	public int getNumOfSpecies() {
		return numOfSpecies;
	}

	public void setNumOfSpecies(int numOfSpecies) {
		this.numOfSpecies = numOfSpecies;
	}

	public double getMilesOfTrail() {
		return milesOfTrail;
	}

	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}

	public int getSurveyCount() {
		return surveyCount;
	}

	public void setSurveyCount(int surveyCount) {
		this.surveyCount = surveyCount;
	}

//	public String getShortDescription() {
//		shortDescription = "";
//		String[] shortDescriptionArray = description.split(".");
//		for (String a: shortDescriptionArray) {
//			shortDescription = a;
//		}
//		return shortDescription;
//	}
//
//	public void setShortDescription(String shortDescription) {
//		this.shortDescription = shortDescription;
//	}

}
