/*
 * Assessment: Lab 3
 * Student Name: Donald Sincennes
 * Due Date: 06/20/21
 * Description: A program that stores info on a student including GPA and fees.
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;

/**
 * User input class for input validation.
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public class User {
	
	/**
	 * 
	 * @return returns integer
	 * Makes sure integer is input from user.
	 */
	public static int inputInteger(Scanner input) {
		int value = 0;
		while( ! input.hasNextInt() ) {
			System.out.println("Invalid input, expecting integer number");
			System.out.print("Please enter an integer number:");
			input.nextLine(); // clear buffer
		}
		value = input.nextInt();
		input.nextLine(); // clear buffer
		return value;
	}
	
	/**
	 * 
	 * Makes sure a double is input from user.
	 * @return returns double
	 */
	public static double inputDouble(Scanner input) {
		double value = 0.0;
		while( ! input.hasNextDouble() ) {
			System.out.println("Invalid input, expecting double(decimal) number");
			System.out.print("Please enter a decimal-point number:");
			input.nextLine(); // clear buffer
		}
		value = input.nextDouble();
		input.nextLine(); // clear buffer
		return value;
	}
	
	/**
	 * 
	 * Makes sure a long is input from user.
	 * @return returns long.
	 */
	public static long inputLong(Scanner input) {
		long value = 0;
		while( ! input.hasNextLong() ) {
			System.out.println("Invalid input, expecting long number");
			System.out.print("Please enter a long number:");
			input.nextLine(); // clear buffer
		}
		value = input.nextLong();
		input.nextLine(); // clear buffer
		return value;
	}
}
