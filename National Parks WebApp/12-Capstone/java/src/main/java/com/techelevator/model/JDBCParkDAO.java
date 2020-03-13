package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			Park thePark = mapRowToPark(results);
			allParks.add(thePark);
		}
		return allParks;
	}

	@Override
	public Park getParkByParkCode(String code) {
		Park newPark = null;
		String sqlSelectParkByParkCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByParkCode, code);
		if (results.next()) {
			newPark = mapRowToPark(results);
		}
		return newPark;
	}

	@Override
	public List<Park> getParksBySurveyResults() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT park.parkcode, park.parkname, park.state, park.yearfounded, count(survey_result.parkcode) as surveycount FROM survey_result "
				+ "JOIN park ON park.parkcode = survey_result.parkcode "
				+ "GROUP BY survey_result.parkcode, park.parkname, park.state, park.yearfounded, park.parkcode "
				+ "ORDER BY count(survey_result.surveyid) DESC ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			Park thePark = new Park();
			thePark.setCode(results.getString("parkcode"));
			thePark.setName(results.getString("parkname"));
			thePark.setState(results.getString("state"));
			thePark.setYearFounded(results.getInt("yearfounded"));
			thePark.setSurveyCount(results.getInt("surveycount"));
			allParks.add(thePark);
		}
		return allParks;
	}

	private Park mapRowToPark(SqlRowSet results) {
		Park thePark = new Park();
		thePark.setCode(results.getString("parkcode"));
		thePark.setName(results.getString("parkname"));
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setElevation(results.getInt("elevationinfeet"));
		thePark.setMilesOfTrail(results.getDouble("milesoftrail"));
		thePark.setNumOfCampsites(results.getInt("numberofcampsites"));
		thePark.setClimate(results.getString("climate"));
		thePark.setYearFounded(results.getInt("yearfounded"));
		thePark.setAnnualVisitors(results.getInt("annualvisitorcount"));
		thePark.setQuote(results.getString("inspirationalquote"));
		thePark.setQuoteSource(results.getString("inspirationalquotesource"));
		thePark.setDescription(results.getString("parkdescription"));
		thePark.setEntryFee(results.getInt("entryfee"));
		thePark.setNumOfSpecies(results.getInt("numberofanimalspecies"));
		return thePark;
	}

	@Override
	public void createAPark(Park newPark) {
		String sqlCreateAPark = "INSERT INTO park (parkcode, parkname, state, "
				+ "acreage, elevationinfeet, milesoftrail, numberofcampsites, "
				+ "climate, yearfounded, annualvisitorcount, inspirationalquote, "
				+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sqlCreateAPark, newPark.getCode(), newPark.getName(), newPark.getState(),
				newPark.getAcreage(), newPark.getElevation(), newPark.getMilesOfTrail(), newPark.getNumOfCampsites(),
				newPark.getClimate(), newPark.getYearFounded(), newPark.getAnnualVisitors(), newPark.getQuote(),
				newPark.getQuoteSource(), newPark.getDescription(), newPark.getEntryFee(), newPark.getNumOfSpecies());
	}

}
