package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;
import com.techelevator.model.Survey;
import com.techelevator.model.SurveyDAO;
import com.techelevator.model.Weather;
import com.techelevator.model.WeatherDAO;

@Controller
public class ParkController {

	@Autowired
	private WeatherDAO weatherDAO;

	@Autowired
	private ParkDAO parkDAO;

	@Autowired
	private SurveyDAO surveyDAO;

	@RequestMapping("/")
	public String displayParks(ModelMap map) {
		List<Park> parks = parkDAO.getAllParks();
		map.put("parks", parks);
		return "parks";
	}

	@RequestMapping(path = "/parkDetails", method = RequestMethod.GET)
	public String displayParkDetail(HttpServletRequest request, ModelMap map, HttpSession session) {

		Park park = null;
		boolean conversion = true;

		String code = request.getParameter("code");
		park = parkDAO.getParkByParkCode(code);

		if (session.getAttribute("conversion") != null) {
			conversion = (boolean) session.getAttribute("conversion");
		}
		
		List<Weather> weather = weatherDAO.getWeatherByParkCode(park.getCode());
		if (conversion == true) {
			for (Weather w : weather) {
				w.setF(true);
			}
		} else {
			for (Weather w : weather) {
				w.setF(false);
			}
		}
		map.put("weather", weather);
		
		session.setAttribute("park", park);
		return "parkDetails";
	}

	@RequestMapping(path = "/parkDetails", method = RequestMethod.POST)
	public String changeWeather(@RequestParam boolean isF, @RequestParam String code, HttpSession session) {
		Park park = (Park) session.getAttribute("park");
		List<Weather> weather = weatherDAO.getWeatherByParkCode(park.getCode());

		boolean conversion = isF;
		session.setAttribute("conversion", conversion);
		for (Weather w : weather) {
			w.setF(isF);
		}
		return "redirect:/parkDetails?code=" + park.getCode();
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String takeSurvey() {
	return "survey";
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String submitSurvey(Survey survey) {
		surveyDAO.saveSurvey(survey);
	return "redirect:/favoriteParks";
	}
	
	@RequestMapping(path = "/favoriteParks", method = RequestMethod.GET)
	public String favoriteParks(ModelMap map) {
	List<Park> parks = parkDAO.getParksBySurveyResults();
	map.put("parks", parks);
	return "favoriteParks";
	}

}
