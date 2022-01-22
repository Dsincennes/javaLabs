import java.util.Scanner;
/**
 * CET - CS Academic Level 3 Declaration: I declare that this is my own original
 * work and is free from plagiarism
 * This class contains main method that drives the program
 * Student Name: Donald Sincennes
 * Student Number: 41011305
 * Section Number: 304
 * Course: CST8130 - Data Structures - Assignment 1
 * Professor: James Mwangi PhD
 *
 * @author Donald Sincennes
 */
public class Assign2 { // Class that holds main method for program,

	/**
	 * Main method, calls display menu
	 *
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		displayMenu();
	}

	/**
	 * Method that displays menu for program. Calls all necessary methods to ADD,
	 * DISPLAY, BUY or SELL, SAVE, READ, SEARCH
	 */
	public static void displayMenu() { // Menu display for program
		Inventory inv = new Inventory();
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println(
						"Please select one of the following: \n1. Add Item to Inventory\n2: Display Current Inventory\n"
								+ "3: Buy Item(s)\n4: Sell Item(s)\n5: Search for Item\n6: Save Inventory to File\n7: Read Inventory from File\n8: To Exit");
				System.out.print("> ");
				String choice = scan.nextLine(); // user input
				int numChoice = Integer.parseInt(choice);
				switch (numChoice) {
				// Add item Case
				case 1:
					inv.addItem(scan, false);
					break;
				// Print inventory Case
				case 2:
					System.out.println("Inventory:");
					System.out.println(inv);
					break;
				// Buy item case
				case 3:
					inv.updateQuantity(scan, true);
					break;
				// Sell item case
				case 4:
					inv.updateQuantity(scan, false);
					break;
				// Search for item case
				case 5:
					inv.searchForItem(scan);
					break;
				// Save list to a file case
				case 6:
					inv.saveToFile(scan);
					break;
				// Read from file Case
				case 7:
					inv.addItem(scan, true);
					break;
				// Exit Case
				case 8:
					System.out.println("Exiting...");
					exit = true;
					break;
				// Default case for bad input
				default:
					System.err.println("must be a number between 1-8");
					break;
				}
			} catch (NumberFormatException e) { // Catches faulty input during menu input.
				System.err.println("Input Mismatch Error when reading from menu");
			}
		} while (!exit);
		scan.close(); // closing scanner
	} // end method

} // End Class
