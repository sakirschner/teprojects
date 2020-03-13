package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCWeatherDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Weather> getWeatherByParkCode(String code) {
		List<Weather> weatherForecast = new ArrayList<>();
		String sqlSelectWeatherByParkCode = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByParkCode, code);
		while (results.next()) {
			Weather weather = new Weather();
			weather.setForecastValue(results.getInt("fivedayforecastvalue"));
			weather.setLow(results.getDouble("low"));
			weather.setHigh(results.getDouble("high"));
			weather.setForecast(results.getString("forecast"));
			weather.setCode(code);
			weatherForecast.add(weather);
		}
		return weatherForecast;
	}
	
	@Override
	public void createAForecast(Weather newWeather) {
		String sqlCreateAForecast = "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast) "
				+ "VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sqlCreateAForecast, newWeather.getCode(), newWeather.getForecastValue(), newWeather.getLow(),
				newWeather.getHigh(), newWeather.getForecast());
	}
	

	
}
