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
public class Assign1 { // Class that holds main method for program,

	/**
	 *  Main method, calls display menu
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) {
		displayMenu();
	}

	/**
	 * Method that displays menu for program. Calls all necessary methods to ADD, DISPLAY, BUY or SELL
	 */
	public static void displayMenu() { // Menu display method for add, display, buy and sell. 
		Inventory inv = new Inventory();
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.println(
						"Please select one of the following: \n1. Add Item to Inventory\n2: Display Current Inventory\n"
								+ "3: Buy Item(s)\n4: Sell Item(s)\n5: To Exit");
				System.out.print("> ");
				String choice = scan.nextLine(); // user input
				int numChoice = Integer.parseInt(choice);
				switch (numChoice) {
				// Add item Case
				case 1: 
					inv.addItem(scan);
					break;
				// Print inventory Case
				case 2:
					System.out.println("Inventory:");
					System.out.println(inv);
					break;
				// Buy item case
				case 3: // buy
					inv.updateQuantity(scan, true);
					break;
				// Sell item case
				case 4: // sell
					inv.updateQuantity(scan, false);
					break;
				// Exit Case
				case 5:
					System.out.println("Exiting...");
					exit = true;
					break;
				// Default case for bad input
				default:
					System.err.println("must be a number between 1-5");
					break;
				}
			} catch (NumberFormatException e) {
				System.err.println("Input Mismatch Error when reading from menu");
			}
		} while (!exit);
		scan.close();
	}
	
} // End Class
