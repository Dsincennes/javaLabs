import java.util.InputMismatchException;
import java.util.Scanner;

// Class that holds main method for program,
/**
 * CET - CS Academic Level 3 
 * Declaration: I declare that this is my own original work and is free from Plagiarism 
 * This class contains main method that drives the program. 
 * Student Name: Donald Sincennes 
 * Student Number: 41011305 
 * Section Number: 304 
 * Course: CST8130 - Data Structures - Lab2 
 * Professor: James Mwangi PhD
 *
 * @author Donald Sincennes
 */
public class Lab2BinLinSearchTest {

	// All Variables for Menu

	/**
	 * Menu option populates array
	 */
	private static final int POP = 1;

	/**
	 * Menu option recursion
	 */
	private static final int RECUR = 2;

	/**
	 * Menu option iterative
	 */
	private static final int ITER = 3;

	/**
	 * Menu option exit
	 */
	private static final int EXIT = 4;

	/**
	 * Main method, drives the program. holds a menu.
	 *
	 * @param args array of strings
	 */
	public static void main(String[] args) {

		boolean exit = false; // variable for loop
		int value; // Key for searching
		Scanner scan = new Scanner(System.in); // Scanner for input
		BinaryLinearSearch bin = new BinaryLinearSearch(); // object to call all methods
		int[] randomArr = { 0 }; // empty array to pass
		// Variables for timing
		long startNanoTime;
		long endNanoTime;
		long startMillTime;
		long endMillTime;
//		int[] randomArr = null; // ask professor

		do {
			try {
				System.out.println();
				System.out.println("Select your option in the menu:");
				System.out.println("1: Initialize and populate an array of 30 random integers.");
				System.out.println("2: Perform recursive binary and linear search.");
				System.out.println("3: Perform iterative binary and linear search.");
				System.out.println("4: Exit.");
				System.out.print("> ");

				int choice = scan.nextInt();

				switch (choice) {
				case POP: // Populates array with 30 random integers from 11-99
					randomArr = bin.generateRandomInts();
					break;
				case RECUR: // demonstrates recursive searching, both binary and linear
					System.out.println("Please enter value to search: ");
					value = scan.nextInt();
					startNanoTime = System.nanoTime();
					startMillTime = System.currentTimeMillis();
					bin.recursiveBinarySearch(randomArr, 0, randomArr.length - 1, value);
					endMillTime = System.currentTimeMillis();
					endNanoTime = System.nanoTime();
					System.out.println("Time taken in nanoseconds: " + (endNanoTime - startNanoTime));
					System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
					startNanoTime = System.nanoTime();
					startMillTime = System.currentTimeMillis();
					bin.recursiveLinearSearch(randomArr, 0, randomArr.length - 1, value);
					endMillTime = System.currentTimeMillis();
					endNanoTime = System.nanoTime();
					System.out.println("Time taken in nanoseconds: " + (endNanoTime - startNanoTime));
					System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
					break;
				case ITER: // Demonstrates iterative searching both binary and linear
					System.out.println("Please enter value to search: ");
					value = scan.nextInt();
					startNanoTime = System.nanoTime();
					startMillTime = System.currentTimeMillis();
					bin.iterativeBinarySearch(randomArr, value);
					endNanoTime = System.nanoTime();
					endMillTime = System.currentTimeMillis();
					System.out.println("total time: " + (endNanoTime - startNanoTime));
					System.out.println("Millisecond: " + (endMillTime - startMillTime));
					startMillTime = System.currentTimeMillis();
					startNanoTime = System.nanoTime();
					bin.iterativeLinearSearch(randomArr, value);
					endNanoTime = System.nanoTime();
					endMillTime = System.currentTimeMillis();
					System.out.println("total time: " + (endNanoTime - startNanoTime));
					System.out.println("Millisecond: " + (endMillTime - startMillTime));
					break;
				case EXIT: // Exits
					System.out.println("Exiting...");
					exit = true;
					break;
				default: // Default statement
					System.err.println("Please choose the option 1 to 4");
				}
			} catch (InputMismatchException e) { // In case improper input from user
				System.err.println("*****Input Mismatch Exception*****");
				scan.nextLine();
			}
//			catch (NullPointerException ne) { // Ask Professor
//				System.err.println("*****NullPointer Exception*****");
//			}
		} while (!exit); // loop escape
		scan.close(); // closing scanner
	} // end main

} // end class
