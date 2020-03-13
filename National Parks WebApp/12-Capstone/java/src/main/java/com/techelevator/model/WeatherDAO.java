package com.techelevator.model;

import java.util.List;

public interface WeatherDAO {

	public List<Weather> getWeatherByParkCode(String code);

	public void createAForecast(Weather newWeather);
	
}
