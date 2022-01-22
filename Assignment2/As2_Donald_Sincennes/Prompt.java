import java.util.Scanner;
import java.util.function.Supplier;
/**
 * CET - CS Academic Level 3 Declaration: I declare that this is my own original
 * work and is free from plagiarism
 * This class has a helper method for input validation
 * Student Name: Donald Sincennes
 * Student Number: 41011305
 * Section Number: 304
 * Course: CST8130 - Data Structures - Assignment 1
 * Professor: James Mwangi PhD
 *
 * @author Donald Sincennes
 */
public class Prompt { // class holds utility method for input validation
	/**
	 * Scanner object for user input
	 */
	final Scanner scan;

	/**
	 * default constructor, sets scan
	 *
	 * @param scan passes scanner for input
	 */
	public Prompt(Scanner scan) { // sets scanner
		this.scan = scan;
	}

	// utility method, passed an input type, and message, checks for correct input,
	// and returns, else catches the exception and prints result

	/**
	 * This method is a helper method, that takes in a generic, and returns the type
	 * if true, otherwise catches the runTimeException and prints invalid entry
	 *
	 * @param <T>     generic type passed for input validation
	 * @param supply  takes in Supplier type, meant for input
	 * @param message string to be sent for user input
	 * @return returns result of the input
	 */
	public <T> T prompt(Supplier<T> supply, String message) {
		while (true) { // loops until good input is given
			try {
				System.out.print(message);
				return supply.get();
			} catch (RuntimeException e) {
				scan.nextLine();
				System.out.println("Invalid Entry");
			}
		}
	}
}
