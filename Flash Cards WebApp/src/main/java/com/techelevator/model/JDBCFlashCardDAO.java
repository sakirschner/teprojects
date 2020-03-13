package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.FlashCard;
import com.techelevator.model.FlashCardDAO;

@Component 
public class JDBCFlashCardDAO implements FlashCardDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCFlashCardDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<FlashCard> getAllFlashCards() {
		List<FlashCard> flashCards = new ArrayList<>();
			String sqlSelectAllFlashCards = "SELECT * FROM flashcards"; 
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllFlashCards);
			while (results.next()) {
				FlashCard flashCard = new FlashCard();
				flashCard.setId(results.getInt("id"));
				flashCard.setQuestion(results.getString("question"));
				flashCard.setAnswer(results.getString("answer"));
				flashCards.add(flashCard);
			}
			return flashCards;
	}
	
	@Override
	public FlashCard getFlashCardById(int id) {
			FlashCard flashCard = new FlashCard();
			String sqlSelectAllFlashCards = "SELECT * FROM flashcards WHERE id = ?"; 
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllFlashCards, id);
			while (results.next()) {
				flashCard.setId(results.getInt("id"));
				flashCard.setQuestion(results.getString("question"));
				flashCard.setAnswer(results.getString("answer"));
			}
			return flashCard;
	}

	@Override
	public void saveCard(FlashCard flashCard) {
		String sqlSaveCard = "INSERT INTO flashcards (question, answer) " +
				"VALUES (?, ?) ";
		jdbcTemplate.update(sqlSaveCard, flashCard.getQuestion(), flashCard.getAnswer());	
	}
}
