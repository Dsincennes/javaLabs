import java.util.Arrays;
import java.util.Scanner;

// Class that holds main method for program,
/**
 * CET - CS Academic Level 3 Declaration: I declare that this is my own original
 * work and is free from Plagiarism 
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
	 * Menu option Sort
	 */
	private static final int SORT = 4;
	/**
	 * Menu option exit
	 */
	private static final int EXIT = 5;

	/**
	 * Main method, drives the program. holds a menu.
	 *
	 * @param args array of strings
	 */
	public static void main(String[] args) {

		boolean exit = false; // variable for loop
		boolean exit2 = false; // variable for inner menu
		int value; // Key for searching
		Scanner scan = new Scanner(System.in); // Scanner for input
		BinaryLinearSearch bin = new BinaryLinearSearch(); // object to call all methods
		SortAlgorithms sort = new SortAlgorithms(); // object for sort methods
		int[] randomArr = { 0 }; // empty array to pass
		/*
		 * Copies of array to pass to the different sort methods
		 */
		int[] copyArr = new int[1000];
		int[] bubbleArr = new int[1000];
		int[] insertArr = new int[1000];
		int[] selectionArr = new int[1000];
		int[] mergeArr = new int[1000];
		int[] quickArr = new int[1000];

		// Variables for timing
		long startNanoTime;
		long endNanoTime;
		long startMillTime;
		long endMillTime;

		do {
			try {
				System.out.println();
				System.out.println("Select your option in the menu:");
				System.out.println("1: Initialize and populate an array of 1000 random integers.");
				System.out.println("2: Perform recursive binary and linear search.");
				System.out.println("3: Perform iterative binary and linear search.");
				System.out.println("4: Sort the array.");
				System.out.println("5: Exit.");
				System.out.print("> ");

				String choice = scan.nextLine();
				int numChoice = Integer.parseInt(choice); // nextInt will just not throw an error *** TIP

				switch (numChoice) {
				case POP: // Populates array with 30 random integers from 11-99
					randomArr = bin.generateRandomInts();
					System.arraycopy(randomArr, 0, copyArr, 0, 1000);
					System.arraycopy(randomArr, 0, bubbleArr, 0, 1000);
					System.arraycopy(randomArr, 0, insertArr, 0, 1000);
					System.arraycopy(randomArr, 0, selectionArr, 0, 1000);
					System.arraycopy(randomArr, 0, mergeArr, 0, 1000);
					System.arraycopy(randomArr, 0, quickArr, 0, 1000);
					break;
				case RECUR: // demonstrates recursive searching, both binary and linear
					Arrays.sort(randomArr);
					System.out.println("Please enter value to search: ");
					System.out.print(">");
					value = scan.nextInt();
					scan.nextLine(); // clear buffer
					sort.printArray(copyArr);
					startNanoTime = System.nanoTime();
					startMillTime = System.currentTimeMillis();
					bin.recursiveBinarySearch(randomArr, 0, randomArr.length - 1, value);
					endMillTime = System.currentTimeMillis();
					endNanoTime = System.nanoTime();
					System.out.println("\nTime taken in nanoseconds: " + (endNanoTime - startNanoTime));
					System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
					System.out.println();
					startNanoTime = System.nanoTime();
					startMillTime = System.currentTimeMillis();
					bin.recursiveLinearSearch(randomArr, 0, randomArr.length - 1, value);
					endMillTime = System.currentTimeMillis();
					endNanoTime = System.nanoTime();
					System.out.println("\nTime taken in nanoseconds: " + (endNanoTime - startNanoTime));
					System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
					break;
				case ITER: // Demonstrates iterative searching both binary and linear
					Arrays.sort(randomArr);
					System.out.println("Please enter value to search: ");
					System.out.print(">");
					value = scan.nextInt();
					scan.nextLine(); // clear buffer
					sort.printArray(copyArr);
					startNanoTime = System.nanoTime();
					startMillTime = System.currentTimeMillis();
					bin.iterativeBinarySearch(randomArr, value);
					endNanoTime = System.nanoTime();
					endMillTime = System.currentTimeMillis();
					System.out.println("\nTime taken in nanoseconds: " + (endNanoTime - startNanoTime));
					System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
					System.out.println();
					startMillTime = System.currentTimeMillis();
					startNanoTime = System.nanoTime();
					bin.iterativeLinearSearch(randomArr, value);
					endNanoTime = System.nanoTime();
					endMillTime = System.currentTimeMillis();
					System.out.println("\nTime taken in nanoseconds: " + (endNanoTime - startNanoTime));
					System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
					break;
				case SORT:
					do {
						/*
						 * Prints Menu for Sorting methods
						 */
						System.out.println("Select a sorting algorithm to sort the data array\n");
						System.out.println("\tB. Bubble Sort\n\tI. Insertion Sort\n\tS. Selection Sort\n"
								+ "\tM. Merge Sort\n\tQ. Quick Sort\n\tR. Return to Main Menu\n");
						System.out.print("> ");
						String choice2 = scan.nextLine().toUpperCase(); // User input for type of sort it wants to use
						System.out.println();
						switch (choice2) {
						case "B": // Bubble sort
							sort.printArray(bubbleArr);
							startMillTime = System.currentTimeMillis();
							startNanoTime = System.nanoTime();
							sort.bubbleSort(bubbleArr);
							endNanoTime = System.nanoTime();
							endMillTime = System.currentTimeMillis();
							System.out.println("Time taken in nanoseconds: " + (endNanoTime - startNanoTime));
							System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
							break;
						case "I": // Insertion Sort
							sort.printArray(insertArr);
							startMillTime = System.currentTimeMillis();
							startNanoTime = System.nanoTime();
							sort.insertionSort(insertArr);
							endNanoTime = System.nanoTime();
							endMillTime = System.currentTimeMillis();
							System.out.println("Time taken in nanoseconds: " + (endNanoTime - startNanoTime));
							System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
							break;
						case "S": // Selection Sort
							sort.printArray(selectionArr);
							startMillTime = System.currentTimeMillis();
							startNanoTime = System.nanoTime();
							sort.selectionSort(selectionArr);
							endNanoTime = System.nanoTime();
							endMillTime = System.currentTimeMillis();
							System.out.println("Time taken in nanoseconds: " + (endNanoTime - startNanoTime));
							System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
							break;
						case "M": // Merge Sort
							sort.printArray(mergeArr);
							startMillTime = System.currentTimeMillis();
							startNanoTime = System.nanoTime();
							sort.mergeSortMain(mergeArr);
							endNanoTime = System.nanoTime();
							endMillTime = System.currentTimeMillis();
							System.out.println("Time taken in nanoseconds: " + (endNanoTime - startNanoTime));
							System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
							break;
						case "Q": // Quick Sort
							sort.printArray(quickArr);
							startMillTime = System.currentTimeMillis();
							startNanoTime = System.nanoTime();
							sort.quickSortMain(quickArr);
							endNanoTime = System.nanoTime();
							endMillTime = System.currentTimeMillis();
							System.out.println("Time taken in nanoseconds: " + (endNanoTime - startNanoTime));
							System.out.println("Time taken in milliseconds: " + (endMillTime - startMillTime));
							break;
						case "R": // Return to main menu
							System.out.println("Returning to main menu...");
							exit2 = true;
							break;
						default: // Default case for invalid entry
							System.err.println("Invalid Entry");
						}
					} while (!exit2);
					break;
				case EXIT: // Exits
					System.out.println("Exiting...");
					exit = true;
					break;
				default: // Default statement
					System.err.println("Please choose the option 1 to 4");
				}
			} catch (NumberFormatException e) { // In case improper input from user
				System.err.println("*****" + e.getClass().getCanonicalName() + "*****");
			}
		} while (!exit); // loop escape
		scan.close(); // closing scanner
	} // end main

} // end class
