package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	// main menu options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	// customer select menu options
	private static final String CUSTOMER_SELECT_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String CUSTOMER_SELECT_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String CUSTOMER_SELECT_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] CUSTOMER_SELECT_MENU_OPTIONS = { CUSTOMER_SELECT_MENU_OPTION_FEED_MONEY,
			CUSTOMER_SELECT_MENU_OPTION_SELECT_PRODUCT, CUSTOMER_SELECT_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;

	VendingMachineTransaction transaction = new VendingMachineTransaction(); 
	private LogWriter writer = new LogWriter();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		LogWriter.createLog();
		transaction.DistrubuteFile();
		boolean mainLoop = true;
		while (mainLoop) {
			boolean shouldLoop = true;
			while (shouldLoop) {
				String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

				if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
					transaction.DisplayItems();
				} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
					shouldLoop = false;
				} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
					System.out.println("Good Bye");
					mainLoop = false;
					System.exit(0);
				}
			}
			shouldLoop = true;
			while (shouldLoop) {
				String choice = (String) menu.getChoiceFromOptions(CUSTOMER_SELECT_MENU_OPTIONS);
				if (choice.equals(CUSTOMER_SELECT_MENU_OPTION_FEED_MONEY)) {
					transaction.addMoneyToMachine();
					System.out.println("Current Money Provided: $" + transaction.getAmountInMachine());
				} else if (choice.equals(CUSTOMER_SELECT_MENU_OPTION_SELECT_PRODUCT)) {
					transaction.DisplayItems();
					transaction.ItemSelection();
				} else if (choice.contentEquals(CUSTOMER_SELECT_MENU_OPTION_FINISH_TRANSACTION)) {
					transaction.getChange();
					transaction.resetAmountInMachine();
					shouldLoop = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		cli.run();

	}

}
