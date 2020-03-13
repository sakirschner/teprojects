package com.techelevator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class VendingMachineTransactionTest {

	VendingMachineTransaction vMachine1 = new VendingMachineTransaction(); 

	// Test Constructor
	@Test
	public void test_Constructor_is_active() {
		assertEquals(new BigDecimal(0.0), vMachine1.getAmountInMachine());
		assertEquals(new BigDecimal(0.0), vMachine1.resetAmountInMachine());
	}

	// Test Valid money
	@Test
	public void test_if_add_1$_into_machine_should_return_$1() {
		vMachine1.setAmountInMachine(new BigDecimal(1.00));
		assertEquals(new BigDecimal(1.00), vMachine1.getAmountInMachine());
//		assertEquals(new BigDecimal(1.00), transaction.setAmountInMachine(new BigDecimal(1.00)));
	}

	@Test
	public void add_$5_into_machine_should_return_5() {
		// $5 is a valid money
		vMachine1.setAmountInMachine(new BigDecimal(5));
		assertEquals(new BigDecimal(5), vMachine1.getAmountInMachine());
	}

	// Test if adding money multiple time
	@Test
	public void test_if_top_up_money_work_corectly() {

		BigDecimal amount = new BigDecimal(0);
		amount = amount.add(new BigDecimal(1.00));
		amount = amount.add(new BigDecimal(1.00));
		amount = amount.add(new BigDecimal(1.00));
		amount = amount.add(new BigDecimal(1.00));
		amount = amount.add(new BigDecimal(1.00));

		assertEquals(new BigDecimal(5), vMachine1.setAmountInMachine(amount));
	}

	// Test if buy 1 product and stock level will be reduced and get change correct
	@Test
	public void stock_Decreases_When_Customer_Buys() throws FileNotFoundException {

		// Populate the machine with items.
		vMachine1.DistrubuteFile();

		// Simulate putting $5
		vMachine1.setAmountInMachine(new BigDecimal(5.00));
		List<Item> machineTestInventory = vMachine1.getItemList();

		// Get the potato chip item A1 before it is bought and its
		// stock level.
		Item potatoChip = machineTestInventory.get(0);
		String stockBeforeForPotatoChip = potatoChip.getStockLevel();
		assertEquals("5", stockBeforeForPotatoChip);

		// Buy item A1
		Item processedItem = vMachine1.processItem("A1");

		// Time to check & test:
		List<Item> machineTestInventoryAfter = vMachine1.getItemList(); 
		Item potatoChipAfter = machineTestInventory.get(0);
		String stockAfterForPotatoChip = potatoChip.getStockLevel();

		assertEquals("4", stockAfterForPotatoChip);
		BigDecimal oneNinetyFive = new BigDecimal(1.95);
		BigDecimal expectedResult = oneNinetyFive.setScale(2, RoundingMode.CEILING);
		assertEquals(expectedResult, vMachine1.getAmountInMachine());
	}

}
