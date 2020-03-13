package iChing.model.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import iChing.model.Fortune;
import iChing.model.FortuneDAO;

public class JDBCFortuneDAO implements FortuneDAO {

	private JdbcTemplate jdbcTemplate;
	java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	
	public JDBCFortuneDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveFortune(Fortune fortune) {
		String sqlSaveFortune = "INSERT INTO fortunes (question_date, question, reading) "
				+ "VALUES(?,?,?)";
		jdbcTemplate.update(sqlSaveFortune, sqlDate, fortune.getQuestion(), fortune.getReading());
	}
}
