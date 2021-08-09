/*
 * Assessment: Lab 4
 * Student Name: Donald Sincennes
 * Due Date: 07/1/21
 * Description: A banking system, that holds accounts and processes fees or interest.
 * Professor Name: Dr. James Mwandi
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that reads type of bank account, run monthly processes, and display accounts.
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public class Bank {
 
	// Store name, and account arrayList
	private static String name;
	private ArrayList<Account> accounts;

	// constructor for main method to pass store name and size of array list.
	public Bank(String name, int size) {
		Bank.name = name;
		accounts = new ArrayList<Account>(size);
	}

	/**
	 * Reads type of account, then account details.
	 * @param input
	 * 
	 */
	public void readAccounts(Scanner input) {

		int accountType = 0;
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		System.out.print("Enter the type of account you want to create: ");
		accountType = User.inputInteger(input);

		for (int i = 0; i <= accounts.size(); i++) { // loop that stores accounts as index (i) as the user reads more accounts.

			switch (accountType) {
			case 1: // checking account case, creates new checking object and then reads the details.
				accounts.add(i, new Checking());
				accounts.get(i).readAccountDetails(input);
				return;
			case 2: // savings account case, creates new savings object and then reads the details.
				accounts.add(i, new Savings());
				accounts.get(i).readAccountDetails(input);
				return;
			default: // default case for incorrect input.
				System.out.println("Please try again!");
				break;
			}
		}
	}

	/**
	 * Runs monthly process' for all accounts. Fee's for checking, interest for savings.
	 */
	public void runMonthlyProcess() {
		if (accounts.isEmpty()) { // if user promps for run monthly process , and no accounts have been read.
			System.out.println("No accounts to process");
		} else
			for (int i = 0; i < accounts.size(); i++) { // goes through accounts arrayList and updates the balances of all accounts.
				accounts.get(i).updateBalance();
			}
	}

	/**
	 * Displays all Bank accounts.
	 */
	public void displayAccounts() {
		if (accounts.size() == 0) { // in the case no accounts to display
			System.out.println("No accounts to display");
		} else
			printTitle();
		for (int i = accounts.size() - 1; i >= 0; i--) { // goes through accounts arrayList and displays all accounts in order of read.
			accounts.get(i).displayAccount();
		}
	}

	/**
	 * Prints stars in a line for Bank title.
	 */
	public static void printStar() {
		for (int i = 0; i < 98; i++) { // prints stars for menu (98 stars)
			System.out.print("*");
		}
		System.out.println();
	}

	/**
	 * titles with headers for bank.
	 */
	public static void printTitle() {
		printStar();
		System.out.printf("%50s BANK\n", name);
		printStar();
		System.out.printf("%10s | %25s | %25s | %10s | %12s |\n", "Acc Number", "Name", "Email", "Phone Number",
				"Balance");
		printStar();
	}
} // end class
