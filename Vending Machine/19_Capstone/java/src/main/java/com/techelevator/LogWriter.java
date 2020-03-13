package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {

	public static String getTime() {

		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter timeFormatted = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
		String formattedDate = time.format(timeFormatted);
		return formattedDate;
	}

	public static boolean createLog() {

		File logFile = new File("log.txt");
		if (logFile.exists() == false) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Can't create file");
				e.printStackTrace();
			}
			System.out.println("log.txt created");
		}
		PrintWriter logWriter = null;
		try {
			logWriter = new PrintWriter(logFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String startMessage = getTime() + " Transaction Initiated: $0.00 $0.00";
		logWriter.append(startMessage);
		logWriter.close();
		logFile.exists();
		return logFile.exists();
	}

	public static void enterToLog(String transaction, BigDecimal startingBalance, BigDecimal endingBalance) {

		FileWriter logFileWriter = null;
		PrintWriter logWriter = null;
		try {
			logFileWriter = new FileWriter("log.txt", true);
			logWriter = new PrintWriter(logFileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String output = "\n" + getTime() + " " + transaction + "  $" + startingBalance.setScale(2, BigDecimal.ROUND_DOWN)
				+ "  $" + endingBalance.setScale(2, BigDecimal.ROUND_DOWN);
		logWriter.append(output);
		logWriter.close();
	}
}
