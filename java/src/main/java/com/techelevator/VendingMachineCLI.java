package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	//MAIN OPTION
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	//PURCHASE OPTIONS
	private static final String MAIN_MENU_DEPOSIT_MONEY = "Add Money";
	private static final String MAIN_MENU_END_TRANSACTION = "Purchase";
	private static final String MAIN_MENU_RETURN_MAIN = "Main Menu";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { MAIN_MENU_DEPOSIT_MONEY, MAIN_MENU_END_TRANSACTION, MAIN_MENU_RETURN_MAIN};


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		VendingMachine newVendingMachine = new VendingMachine();
		String[] activeMenu = MAIN_MENU_OPTIONS;

		while (true) {
			String userChoice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (userChoice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items -
				// newVendingMachine.listItems (if listItems is the method)
			} else if (userChoice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				activeMenu = PURCHASE_MENU_OPTIONS;
				// do purchase
			} else if(userChoice.equals(MAIN_MENU_OPTION_EXIT)){
				//newVendingMachine - close out
				//newVendingMachine - exit diaglog (if we have it)
				//System.exit(1);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
