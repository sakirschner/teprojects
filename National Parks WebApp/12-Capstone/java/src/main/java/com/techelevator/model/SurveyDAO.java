package com.techelevator.model;

import java.util.List;

public interface SurveyDAO {

	public void saveSurvey(Survey survey);
	public List<Survey> getAllSurveys();
	
	
}
