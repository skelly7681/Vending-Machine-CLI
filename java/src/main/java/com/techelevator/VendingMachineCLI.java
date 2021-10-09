package com.techelevator;

import com.techelevator.view.Menu;

import java.awt.*;
import java.util.Scanner;

public class VendingMachineCLI {

	//MAIN OPTIONS
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	//PURCHASE OPTIONS
	private static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_PURCHASE = "Purchases";
	private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "End Transaction";
	private static final String PURCHASE_MENU_OPTION_RETURN_TO_MAIN = "Main Menu";
	//DEPOSIT_OPTIONS
	private static final String DEPOSIT_MENU_OPTION_ONE = "$1";
	private static final String DEPOSIT_MENU_OPTION_TWO = "$2";
	private static final String DEPOSIT_MENU_OPTION_FIVE = "$5";
	private static final String DEPOSIT_MENU_OPTION_TEN = "$10";
	//MENU COLLECTIONS
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_DEPOSIT_MONEY, PURCHASE_MENU_OPTION_PURCHASE, PURCHASE_MENU_OPTION_END_TRANSACTION, PURCHASE_MENU_OPTION_RETURN_TO_MAIN };
	private static final String[] DEPOSIT_MENU_OPTIONS = { DEPOSIT_MENU_OPTION_ONE,DEPOSIT_MENU_OPTION_TWO,DEPOSIT_MENU_OPTION_FIVE,DEPOSIT_MENU_OPTION_TEN};


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		ChangeAccount newChangeAccount = new ChangeAccount();
		VendingMachine vm = new VendingMachine();
		vm = new VendingMachine(new Stock().getInventory());

		String[] activeMenu = MAIN_MENU_OPTIONS;
		boolean run = true;

		while (run) {
			String userChoice = (String) menu.getChoiceFromOptions(activeMenu);

			if (userChoice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
//				vm.listItems();
				vm.displayInventory();

			} else if (userChoice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// display purchase menu / do purchase
				activeMenu = PURCHASE_MENU_OPTIONS;
			} else if(userChoice.equals(PURCHASE_MENU_OPTION_PURCHASE)){
				System.out.println("Please input your selection: ");
				Scanner selection = new Scanner(System.in);
				String chosenProduct = selection.nextLine();
				vm.purchase(chosenProduct);
			} else if (userChoice.equals(MAIN_MENU_OPTION_EXIT)) {
//				vm.closeBank();
//				vm.exitDialog();
				run = false;
				System.exit(1);
			} else if (userChoice.equals(PURCHASE_MENU_OPTION_RETURN_TO_MAIN)) {
				activeMenu = MAIN_MENU_OPTIONS;
			} else if (userChoice.equals(PURCHASE_MENU_OPTION_DEPOSIT_MONEY)) {
				String deposit = (String) menu.getChoiceFromOptions(DEPOSIT_MENU_OPTIONS);
				if (deposit.equals(DEPOSIT_MENU_OPTION_ONE)) {
					newChangeAccount.insertMoney(1);
				} else if (deposit.equals(DEPOSIT_MENU_OPTION_TWO)) {
					newChangeAccount.insertMoney(2);
				} else if (deposit.equals(DEPOSIT_MENU_OPTION_FIVE)) {
					newChangeAccount.insertMoney(5);
				} else if (deposit.equals(DEPOSIT_MENU_OPTION_TEN)) {
					newChangeAccount.insertMoney(10);
				}
			}
		}
	}
	//EXECUTION ENTRY POINT
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

}