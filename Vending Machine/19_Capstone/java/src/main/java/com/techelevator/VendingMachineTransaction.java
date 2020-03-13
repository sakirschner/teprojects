package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineTransaction {

	private BigDecimal amountInMachine;
	private static List<Item> itemList = new ArrayList<>(); 
	public static List<Item> getItemList() {
		return itemList;
	}

	private LogWriter writer = new LogWriter();


	public VendingMachineTransaction() {
		this.amountInMachine = new BigDecimal(0.0);  
	}

	public BigDecimal getAmountInMachine() {
		return amountInMachine;
	}

	public BigDecimal setAmountInMachine(BigDecimal amountInMachine) {
		return this.amountInMachine = amountInMachine;
	}

	public BigDecimal resetAmountInMachine() {
		return this.amountInMachine = new BigDecimal(0.0);
	}

	public boolean DistrubuteFile() throws FileNotFoundException {

		File inputFile = new File("vendingmachine.csv");
		try (Scanner fileScanner = new Scanner(inputFile)) {
			if(!inputFile.exists()) {
				return false;
			}

			while (fileScanner.hasNextLine()) {
				String fullLine = fileScanner.nextLine();
				if (fullLine.length() != 0) {

					String[] itemArray = fullLine.split("\\|");

					switch (itemArray[3]) {
					case "Chip":
						itemList.add(new Chip(itemArray[0], itemArray[1], new BigDecimal(itemArray[2])));
						break;
					case "Gum":
						itemList.add(new Gum(itemArray[0], itemArray[1], new BigDecimal(itemArray[2])));
						break;
					case "Candy":
						itemList.add(new Candy(itemArray[0], itemArray[1], new BigDecimal(itemArray[2])));
						break;
					case "Drink":
						itemList.add(new Drink(itemArray[0], itemArray[1], new BigDecimal(itemArray[2])));
						break;
					}
				}
			} 
		}
		return true;
	}

	public BigDecimal addMoneyToMachine() throws IOException {

		BigDecimal amount = getAmountInMachine();
		System.out.println("Please insert amount of money"); 
		System.out.println("$1   $2   $5   $10");
		boolean shouldLoop = true;
		while (shouldLoop) {
			Scanner input = new Scanner(System.in);
			String userChoice = input.nextLine();
			BigDecimal cash = new BigDecimal(userChoice);

			if (cash.compareTo(new BigDecimal(1.00)) == 0) {
				amount = amount.add(new BigDecimal(1.00));
				shouldLoop = false;
			} else if (cash.compareTo(new BigDecimal(2.00)) == 0) { 
				amount = amount.add(new BigDecimal(2.00));
				shouldLoop = false;
			} else if (cash.compareTo(new BigDecimal(5.00)) == 0) {
				amount = amount.add(new BigDecimal(5.00));
				shouldLoop = false;
			} else if (cash.compareTo(new BigDecimal(10.00)) == 0) {
				amount = amount.add(new BigDecimal(10.00));
				shouldLoop = false;
			} else {
				System.out.println("Choose amount provided");
			}
			
			LogWriter.enterToLog("FEED MONEY", cash, amount); 
			
		}
		setAmountInMachine(amount);
		return amount;
		
	}

	public BigDecimal getChange() {

		BigDecimal currentBalance = getAmountInMachine().multiply(new BigDecimal(100));
		int penny = currentBalance.intValue();

		int quarters = penny / 25;
		penny = penny % 25;

		int dimes = penny / 10;
		penny = penny % 10;

		int nickles = penny / 5;

		System.out.println("Amount Tendered: $" + getAmountInMachine());
		System.out.println("quarters : " + quarters);
		System.out.println("dimes : " + dimes);
		System.out.println("nickles : " + nickles);

		LogWriter.enterToLog("GIVE CHANGE", getAmountInMachine(), new BigDecimal(0.0));
		return getAmountInMachine();
	}

	public void DisplayItems() {
		System.out.println(" Code     Product Name\t           $Price\t Type    Stock");
		System.out.println("=============================================================");
		for (Item item : itemList) {
			System.out.printf("%4s\t  %-25s %.2f\t %-10s %-10s\n", item.getItemLocation(), item.getItemName(),
					item.getItemPrice(), item.getItemType(), item.getStockLevel());
		}
	}

	
	public Item processItem(String selection) {
		
		BigDecimal before = getAmountInMachine();
		Item selectedItem = null;

		
		for (Item item : itemList) {
			if (selection.equals(item.getItemLocation())) {
				
				if (item.getItemPrice().compareTo(getAmountInMachine()) < 0) {

					item.deductStockLevel();
					setAmountInMachine(getAmountInMachine().subtract(item.getItemPrice()));

					if (item.getItemType().equals("Chip")) {
						System.out.println("Crunch Crunch, Yum!");
					} else if (item.getItemType().equals("Candy")) {
						System.out.println("Munch Munch, Yum!");
					} else if (item.getItemType().equals("Drink")) {  
						System.out.println("Glug Glug, Yum!");
					} else {
						System.out.println("Chew Chew, Yum!");
					}
					System.out.println("Current balance: $" + getAmountInMachine());
				} else {
					System.out.println("Transaction failed! Please input more money.");
				}
				selectedItem = item;
				LogWriter.enterToLog(item.getItemName() + " " + item.getItemLocation(), before, getAmountInMachine());
				
			}
		}
		
		return selectedItem;
		
	}
	
	public void ItemSelection() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nCurrent Money Provided: $" + getAmountInMachine());
		System.out.println("\nPlease input product code: ");
		String userSelection = input.nextLine();
		Item processedItem = processItem(userSelection);

	}

}
