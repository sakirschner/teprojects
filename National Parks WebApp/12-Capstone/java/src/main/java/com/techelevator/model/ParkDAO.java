package com.techelevator.model;

import java.util.List;

public interface ParkDAO {

	public List<Park> getAllParks();
	Park getParkByParkCode(String code);
	public List<Park> getParksBySurveyResults();
	public void createAPark(Park newPark);

}
