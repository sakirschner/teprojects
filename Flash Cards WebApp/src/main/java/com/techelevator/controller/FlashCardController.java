package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.FlashCard;
import com.techelevator.model.FlashCardDAO;

import java.util.Random;


@Controller
public class FlashCardController {

	@Autowired
	private FlashCardDAO flashCardDao;
	
	@RequestMapping("/")
	public String displayHome(ModelMap map) {
		List<FlashCard> flashCardList = flashCardDao.getAllFlashCards();
		Random random = new Random();
		int randInt = 0;
		for (int i = 0; i < flashCardList.size(); i++) {
			randInt++;
		}
		int randId = random.nextInt(randInt) + 1;
		System.out.println(randId);
		FlashCard flashCard = flashCardDao.getFlashCardById(randId);
		map.put("flashcard", flashCard);
		return "home";
	}
	
	@RequestMapping(path="/add", method = RequestMethod.GET)
	public String displayAddCardForm() {
		return "addcard";
	}
	
	@RequestMapping(path="/add", method = RequestMethod.POST)
	public String processAddCard(@RequestParam String question,
				@RequestParam String answer,
				RedirectAttributes ra) {
		FlashCard flashCard = new FlashCard();
		flashCard.setQuestion(question);
		flashCard.setAnswer(answer);
		flashCardDao.saveCard(flashCard);
		ra.addFlashAttribute("flashcard", flashCard);
		return "redirect:/success";
	}
	
	@RequestMapping(path = "/success", method = RequestMethod.GET)
	public String showConfirmationLoggedIn() {
		return "success";
	}
}
