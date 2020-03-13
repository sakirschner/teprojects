package iChing.model;

import java.sql.Date;

public class Fortune {

	int fortuneId;
	String question;
	Date questionDate;
	String reading;
	
	public Fortune(String question, String reading) {
		this.question = question;
		this.reading = reading;
	}
	
	public int getFortuneId() {
		return fortuneId;
	}
	
	public void setFortuneId(int fortuneId) {
		this.fortuneId = fortuneId;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
	    this.question = question;
	 }
	
	public Date getQuestionDate() {
		return questionDate;
	}
	
	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}
	
	public String getReading() {
		return reading;
	}
	
	public void setReadingId(String reading) {
		this.reading = reading;
	}
	
}
