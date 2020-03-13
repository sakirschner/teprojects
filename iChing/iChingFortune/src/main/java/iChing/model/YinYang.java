package iChing.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class YinYang {

	private String line1;
	private String line2;
	private Map<Integer, Boolean[]> results;
	private int[] totals;
	private String[] lines;
	private Map<String, String[]> hex = new HashMap<>();
	private Coin coin1 = new Coin();
	private Coin coin2 = new Coin();
	private Coin coin3 = new Coin();
	private int readingId = 1;
	private String question;
	private String reading = "";

	public YinYang(Coin coin1, Coin coin2, Coin coin3) {
		this.coin1 = coin1;
		this.coin2 = coin2;
		this.coin3 = coin3;
		this.line1 = "___   ___";
		this.line2 = "_________";
		setHex();
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public Map<Integer, Boolean[]> getResults() {
		return results;
	}

	public int[] getTotals() {
		return totals;
	}

	public String[] getLines() {
		return lines;
	}
	
	public int getReadingId() {
		return readingId;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getReading() {
		return reading;
	}

	//sets the user's questions
	
	public void askQuestion() {
		Scanner input = new Scanner(System.in);
		String question = "";
	    while (question.equals("")) {
			System.out.println("Ask a question related to your life.");
			question = input.nextLine();
		}
	    this.question = question;
	}
	
	// tosses 3 coins and saves the boolean result into an array.
	// Repeats 6 times. Each array is saved into a map.
	
	public void tossCoins() {
		Scanner input = new Scanner(System.in);
		results = new HashMap<>();
		System.out.println("Now toss 3 coins 6 seperarte times. The Results of each toss\n"
				+ "will be used to draw a line that creates a hexagram\n"
				+ "to determine which reading from the I Ching\n"
				+ "will help answer your question.\n");
		for (int i = 0; i < 6; i++) {
			System.out.println("Press enter to toss your coins");
			input.nextLine();
			this.coin1.flip();
			this.coin2.flip();
			this.coin3.flip();
			Boolean[] singleToss = new Boolean[] { coin1.isHeads(), coin2.isHeads(), coin3.isHeads() };
			results.put(i, singleToss);
			System.out.println("Results for toss #" + (i + 1) + ": " + coin1 + " " + coin2 + " " + coin3 + "\n");
		}
		input.close();
	}

	// loops through coin toss results map and determines an int value based on the
	// boolean results. Each int value is assigned to a line and
	// that line is saved into an array of strings. Repeats 6 times

	public void determineReading() {
		System.out.println("Below is the I Ching reading to help you answer your question:\n");
		totals = new int[6];
		lines = new String[6];
		for (int i = 0; i < results.size(); i++) {
			int total1 = 0;
			for (Boolean x : results.get(i)) {
				int total2 = 0;
				if (x == true) {
					total2++;
				}
				total1 += total2;
				totals[i] = total1;
			}

			if (total1 == 0 || total1 == 2) {
				lines[i] = (this.getLine1());
			} else if (total1 == 1 || total1 == 3) {
				lines[i] = (this.getLine2());
			}
		}

		for (int i = lines.length - 1; i >= 0; i--) {
			System.out.println(lines[i]);
		}
		System.out.println();
	}

	// loops through a map of readings and lines and if the
	// lines from determineReading() matches a value in
	// the map it prints out the reading

	public void matchReading() {
		for (Map.Entry<String, String[]> entry : hex.entrySet()) {
			int counter = 0;
			//readingId++;
			String[] hexArray = entry.getValue();
			for (int i = 0; i < hexArray.length; i++) {
				if (hexArray[i].equals(lines[i])) {
					counter++;
				}
			}
			if (counter == 6) {
				System.out.println(entry.getKey());
				reading = entry.getKey();
			}
		}
	}

	// reads in from file to get all the readings and lines

	public void setHex() {
		File inputFile = new File("yinyang.csv");
		List<String> readings = new ArrayList<>();
		List<String[]> hexagram = new ArrayList<>();
		int i = 0;
		try (Scanner fileScanner = new Scanner(inputFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] fullReadings = line.split(",");
				String[] fullLines = new String[6];
				readings.add(fullReadings[0]);
				fullLines[0] = fullReadings[1].replace("getLine1()", "___   ___").replace("getLine2()", "_________");
				fullLines[1] = fullReadings[2].replace("getLine1()", "___   ___").replace("getLine2()", "_________");
				fullLines[2] = fullReadings[3].replace("getLine1()", "___   ___").replace("getLine2()", "_________");
				fullLines[3] = fullReadings[4].replace("getLine1()", "___   ___").replace("getLine2()", "_________");
				fullLines[4] = fullReadings[5].replace("getLine1()", "___   ___").replace("getLine2()", "_________");
				fullLines[5] = fullReadings[6].replace("getLine1()", "___   ___").replace("getLine2()", "_________");
				hexagram.add(fullLines);
				hex.put(readings.get(i), hexagram.get(i));
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Must have the proper input file to find your reading");
			e.printStackTrace();
		}
	}
}
