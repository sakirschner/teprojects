package iChing;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import iChing.model.Coin;
import iChing.model.Fortune;
import iChing.model.FortuneDAO;
import iChing.model.YinYang;
import iChing.model.jdbc.JDBCFortuneDAO;

public class FortuneCLI {

	private static FortuneDAO dao;
	private static FortuneCLI application;
	
	public FortuneCLI(DataSource dataSource){
		dao = new JDBCFortuneDAO(dataSource);
	}
	
	private void run() {
		YinYang reading = new YinYang(new Coin(), new Coin(), new Coin());
		reading.askQuestion();
		reading.tossCoins();
		reading.determineReading();
		reading.matchReading();
		Fortune fortune = new Fortune(reading.getQuestion(), reading.getReading());
		dao.saveFortune(fortune);
	}
	
	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/yinyang");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		application = new FortuneCLI(dataSource);
		application.run();
	}

}