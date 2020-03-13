package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public JDBCSurveyDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource); 
	}

	@Override
	public void saveSurvey(Survey survey) {
	String sqlSaveSurvey = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
			+ "VALUES (?,?,?,?)"; 
	jdbcTemplate.update(sqlSaveSurvey,
			survey.getCode(),
			survey.getEmail(),
			survey.getState(),
			survey.getActivityLevel());
	}  
	
	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while (results.next()) {
			Survey theSurvey = new Survey();
			theSurvey.setId(results.getInt("surveyid"));
			theSurvey.setCode(results.getString("parkcode"));
			theSurvey.setEmail(results.getString("emailaddress"));
			theSurvey.setState(results.getString("state"));
			theSurvey.setActivityLevel(results.getString("activitylevel"));			
			allSurveys.add(theSurvey);
		}
		return allSurveys;
	}

}
	
