package com.techelevator.model;

import java.util.List;

import com.techelevator.model.FlashCard;

public interface FlashCardDAO {
	
	public List<FlashCard> getAllFlashCards();

	public FlashCard getFlashCardById(int id);
	
	public void saveCard(FlashCard flashCard);

}
