package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.model.JDBCParkDAO;
import com.techelevator.model.JDBCSurveyDAO;
import com.techelevator.model.JDBCWeatherDAO;
import com.techelevator.model.Park;
import com.techelevator.model.Survey;
import com.techelevator.model.Weather;

public class DAOIntegrationTest {

	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	private static SingleConnectionDataSource dataSource;
	private JDBCParkDAO parkDao;
	private JDBCSurveyDAO surveyDao;
	private JDBCWeatherDAO weatherDao;

	@BeforeClass
	public static void setupDatasource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
 
	@AfterClass
	public static void closeDataSource() {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		parkDao = new JDBCParkDAO(dataSource);
		surveyDao = new JDBCSurveyDAO(dataSource);
		weatherDao = new JDBCWeatherDAO(dataSource);

	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	private Park getPark(String code, String name, String state, int acreage, int elevation, double miles, int sites,
			String climate, int year, int visitors, String quote, String source, String description, int fee,
			int species) {
		Park thePark = new Park();
		thePark.setCode(code);
		thePark.setName(name);
		thePark.setState(state);
		thePark.setAcreage(acreage);
		thePark.setElevation(elevation);
		thePark.setMilesOfTrail(miles);
		thePark.setNumOfCampsites(sites);
		thePark.setClimate(climate);
		thePark.setYearFounded(year);
		thePark.setAnnualVisitors(visitors);
		thePark.setQuote(quote);
		thePark.setQuoteSource(source);
		thePark.setDescription(description);
		thePark.setEntryFee(fee);
		thePark.setNumOfSpecies(species);
		return thePark;
	}

	private Survey getSurvey(String code, String email, String state, String activityLevel) {
		Survey theSurvey = new Survey();
		theSurvey.setCode(code);
		theSurvey.setEmail(email);
		theSurvey.setState(state);
		theSurvey.setActivityLevel(activityLevel);
		return theSurvey;
	}

	private Weather getWeather(String code, int fiveDayForecastValue, double low, double high, String forecast) {
		Weather theWeather = new Weather();
		theWeather.setCode(code);
		theWeather.setForecastValue(fiveDayForecastValue);
		theWeather.setLow(low);
		theWeather.setHigh(high);
		theWeather.setForecast(forecast);
		return theWeather;
	}

	@Test
	public void test_getAllParks_gets_all_parks_add_park_returns_additonal_park() {
		List<Park> results = parkDao.getAllParks();
		int startNum = results.size();
		Park thePark = getPark("TEST2", "Test Park", "MI", 10000, 100, 1000, 100, "Temperate", 1900, 10000,
				"This is a test park", "Scott Kirschner", "The best test", 25, 10000);
		parkDao.createAPark(thePark);
		List<Park> results2 = parkDao.getAllParks();
		int endNum = results2.size();
		assertNotNull(results);
		assertNotNull(results2);
		assertEquals(startNum + 1, endNum);
	}

	@Test
	public void test_getParkByParkcode_add_park_and_return_added_park_using_parkcode() {
		Park thePark = getPark("TEST", "Test Park", "MI", 10000, 100, 1000, 100, "Temperate", 1900, 10000,
				"This is a test park", "Scott Kirschner", "The best test", 25, 10000);
		parkDao.createAPark(thePark);
		Park result = parkDao.getParkByParkCode("TEST");
		assertEquals("TEST", result.getCode());
	}

	@Test
	public void test_save_survey() {
		Survey theSurvey = getSurvey("TEST", "jay@aol.com", "MI", "active");
		surveyDao.saveSurvey(theSurvey);
		List<Survey> results = surveyDao.getAllSurveys();
		int startNum = results.size();
		Survey theSurvey2 = getSurvey("TEST", "bill@aol.com", "MI", "active");
		surveyDao.saveSurvey(theSurvey2);
		List<Survey> results2 = surveyDao.getAllSurveys();
		int endNum = results2.size();
		assertNotNull(results);
		assertNotNull(results2);
		assertEquals(startNum + 1, endNum);
	}

	@Test
	public void test_getWeatherByParkCode_add_park_add_forecast_return_forecasts() {
		Park thePark = getPark("TEST", "Test Park", "MI", 10000, 100, 1000, 100, "Temperate", 1900, 10000,
				"This is a test park", "Scott Kirschner", "The best test", 25, 10000);
		parkDao.createAPark(thePark);
		Weather theWeather = getWeather("TEST", 1, 50, 70, "cloudy");
		Weather theWeather2 = getWeather("TEST", 2, 50, 70, "cloudy");
		Weather theWeather3 = getWeather("TEST", 3, 50, 70, "cloudy");
		Weather theWeather4 = getWeather("TEST", 4, 50, 70, "cloudy");
		Weather theWeather5 = getWeather("TEST", 5, 50, 70, "cloudy");
		weatherDao.createAForecast(theWeather);
		weatherDao.createAForecast(theWeather2);
		weatherDao.createAForecast(theWeather3);
		weatherDao.createAForecast(theWeather4);
		weatherDao.createAForecast(theWeather5);
		List<Weather> allWeather = weatherDao.getWeatherByParkCode("TEST");
		int forecasts = allWeather.size();
		assertEquals(5, forecasts);
	}
	
	@Test
	public void test_getResponseTemp_isF_equals_true_high_above_75_returns_Bring_an_extra_gallon_of_water() {
		Weather theWeather = getWeather("TEST", 1, 60, 78, "cloudy");
		theWeather.setF(true);
		assertEquals("Bring an extra gallon of water!", theWeather.getResponseTemp());
	}
	
	@Test
	public void test_getResponseTemp_isF_equals_false_high_above_23_8_returns_Bring_an_extra_gallon_of_water() {
		Weather theWeather = getWeather("TEST", 1, 20, 25, "cloudy");
		theWeather.setF(false);
		assertEquals("Bring an extra gallon of water!", theWeather.getResponseTemp());
	}
	
	@Test
	public void test_getResponseForecast_snow_response_equals_pack_snowshoes() {
		Weather theWeather = getWeather("TEST", 1, 20, 25, "snow");
		theWeather.setF(false);
		assertEquals("Pack snowshoes!", theWeather.getResponseForecast());
	}
	
	@Test
	public void test_getResponseForecast_sunny_response_equals_pack_sunblock() {
		Weather theWeather = getWeather("TEST", 1, 65, 70, "sunny");
		theWeather.setF(false);
		assertEquals("Pack sunblock!", theWeather.getResponseForecast());
	}
	
	@Test
	public void test_getResponseForecast_thunderstorms_response_equals_seek_shelter() {
		Weather theWeather = getWeather("TEST", 1, 65, 70, "thunderstorms");
		theWeather.setF(false);
		assertEquals("Seek shelter and avoid hiking on exposed ridges!", theWeather.getResponseForecast());
	}
	
	@Test
	public void test_getResponseForecast_rain_response_equals_pack_rain_gear() {
		Weather theWeather = getWeather("TEST", 1, 65, 70, "rain");
		theWeather.setF(false);
		assertEquals("Pack rain gear and wear waterproof shoes!", theWeather.getResponseForecast());
	}
}
