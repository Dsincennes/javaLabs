/*
 * Assessment: Lab 4
 * Student Name: Donald Sincennes
 * Due Date: 07/1/21
 * Description: A banking system, that holds accounts and processes fees or interest.
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;

/**
 * Class that reads a persons bank account information.
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public abstract class Account {

	// instance variables, for accounts
	protected long accNumber;
	protected Person accHolder;
	protected double balance;

	// sets account info to zero's for when input is needed.
	public Account() {
		accNumber = 0;
		accHolder = new Person("", "", "", 0);
		balance = 0.0;
	}

	/**
	 * reads all account information of a person.
	 * @param input
	 * 
	 */
	public void readAccountDetails(Scanner input) {

		System.out.print("Enter Account Number: ");
		accNumber = User.inputLong(input);
		accHolder.readPersonalDetails(input);
		System.out.print("Enter balance: ");
		balance = User.inputDouble(input);
	}

	/**
	 * displays account information of a person.
	 */
	public void displayAccount() { // formatted to match headers in bank class.
		System.out.printf("%10s | %25s | %25s | %12s | %12.2f |\n", accNumber, accHolder.getFullName(),
				accHolder.getEmail(), accHolder.getPhoneNumber(), balance);
	}

	/**
	 * abstract method for updating balance for different accounts.
	 */
	public void updateBalance() {
	}
	
}
