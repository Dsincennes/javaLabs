/*
 * Assessment: Lab 4
 * Student Name: Donald Sincennes
 * Due Date: 07/1/21
 * Description: A banking system, that holds accounts and processes fees or interest.
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;

/**
 * Class that holds main method.
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public class BankTest {

	/**
	 * method main, reads in name and account holders. Prints menu to read accounts, run process, display accounts or exit.
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		int exit = 0;
		int num = 0;
		String name;
		Scanner input = new Scanner(System.in);

		// input for Bank name.
		System.out.print("Enter the name of the bank: ");
		name = input.nextLine();

		// input for account holders.
		System.out.print("How many account holders do you have: ");
		num = User.inputInteger(input);
		if ( num < 0 ) {
			System.out.print("How many account holders do you have: ");
			num = User.inputInteger(input);
		}
		

		// bank object with name and number of accounts
		Bank bank = new Bank(name, num);

		// loop for menu. keeps running unless exit is input.
		do {
			System.out.println("1. Read Accounts");
			System.out.println("2. Run monthly Process");
			System.out.println("3. Display Accounts");
			System.out.println("4. Exit");
			System.out.print("Enter your option: ");

			int choice = User.inputInteger(input);

			switch (choice) {
			
			// case one reads accounts
			case 1: 
				bank.readAccounts(input);
				break;
				
			// case two will run monthly processes based on savings or checking acocunt
			case 2:
				bank.runMonthlyProcess();
				break;

			// case three will display all accounts.
			case 3:
				bank.displayAccounts();
				break;
				
			// case four exits.
			case 4:
				exit = 99;
				System.out.println("Goodbye... Have a nice day");
				break;
			
			// default incase wrong input
			default:
				System.out.println("Invalid entry... please try again!");
			}
		} while (exit != 99);
		input.close();
	} // end method
} // end class
