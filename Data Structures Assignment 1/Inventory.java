import java.util.InputMismatchException;
import java.util.Scanner;

/**
* CET - CS Academic Level 3 Declaration: I declare that this is my own original
* work and is free from plagiarism 
* This class contains the datastructure for my inventory. 
* It also controls adding to the datastructure and buying or selling
* Student Name: Donald Sincennes 
* Student Number: 41011305 
* Section Number: 304 
* Course: CST8130 - Data Structures - Assignment 1 
* Professor: James Mwangi PhD
*
* @author Donald Sincennes
*/
public class Inventory { // Class holds array of inventory. It also controls adding, buying and selling of items.

	/**
	 * number of items in the inventory Array
	 */
	private int numItems; // Variable to control number of items added to array
	/**
	 * Inventory array, stores all items being held to buy or sell
	 */
	private final FoodItem[] inventory; // inventory array

	/**
	 * Default Constructor, sets numItems to zero, and instantiates the array to size 20
	 */
	public Inventory() {
		numItems = 0;
		inventory = new FoodItem[20];
	}

	/**
	 * This method checks if an item code already exists in item object, calls isEqual method to check.
	 * 
	 * @param item passed object FoodItem item
	 * @return returns -1 if item code already exists
	 */
	public int alreadyExists(FoodItem item) { // Method calls isEqual() to check if itemCode already exists in.
		for (int i = 0; i < numItems; i++) { // reads through all items that are in the array
			if (inventory[i].isEqual(item)) { // checks if each item's itemcode in the array is equal
				return i;
			}
		}
		return -1;
	}

	/**
	 * This method is used to add items to the array based on which item is called,
	 * the method will create a new fruit, vegetable, or preserve.
	 * 
	 * @param scan Scanner for user input
	 * @return true if item is added
	 */
	public boolean addItem(Scanner scan) {
		FoodItem food = null;
		boolean exit2 = false;
		do {
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
			String choice = scan.nextLine().toLowerCase(); // User Choice
			switch (choice) {
			// Fruit case, adds fruit item
			case "f":
				food = new Fruit();
				exit2 = true;
				break;
			// vegetable case, adds vegetable item
			case "v":
				food = new Vegetable();
				exit2 = true;
				break;
			// Preserve case, adds preserve item
			case "p":
				food = new Preserve();
				exit2 = true;
				break;
			// Default case for invalid input
			default:
				System.err.println("Invalid Entry");
				break;
			}

		} while (!exit2);
		if (food.inputCode(scan)) { // checking for correct input code
			if (alreadyExists(food) < 0) { // checking if item code exits
				food.addItem(scan);
				inventory[numItems] = food;
				numItems++;
				return true;
			} else {
				System.out.println("Item code exists");
				return false;
			}
		}
		return true;
	}

	/**
	 * This method is used to update the quantity in the array depending if a user
	 * buys or sells a certain item.
	 * 
	 * @param scan Scanner for user input
	 * @param buyOrSell True for buy, False for sell
	 * @return returns true when correctly updated quantity
	 */
	public boolean updateQuantity(Scanner scan, boolean buyOrSell) { // Method is used to update quantity of items.
		FoodItem food = null;
		boolean goodData = false;
		int tempCode = 0;
		if (buyOrSell && numItems == 0) { // empty array
			System.out.println("Error... could not buy item");
			return false;
		}
		else if (!buyOrSell && numItems == 0) { // empty array
			System.out.println("Error... could not sell item");
			return false;
		}
		do {
			try {
				System.out.print("Enter code of item: ");
				tempCode = scan.nextInt();
				goodData = true;
			}catch(InputMismatchException e) {
				System.out.println("Error while reading code");
				scan.nextLine();
			}
		}while(!goodData);
		for(int i = 0; i < numItems; i++) { // searching through entire array for item code
			if(inventory[i].itemCode == tempCode) {
				food = inventory[i];
			}
		}
		if(food == null) { // item not found with given code
			System.out.println("Code not found in inventory...");
			scan.nextLine();
			return false;
		}
		goodData = false;
		do {
			try {
				if (buyOrSell) { // buy
					System.out.print("Enter valid quantity to buy: ");
					food.updateItem(scan.nextInt());
					goodData = true;
				}
				else { // sell
					System.out.print("Enter valid quantity to sell: ");
					food.updateItem(scan.nextInt() * -1);
					goodData = true;
				}
			}catch(InputMismatchException e) {
				System.out.println("Error while reading code");
				scan.nextLine();
			}
		}while(!goodData);
		scan.nextLine(); // clear buffer
		return true;
	}


	/**
	 * Override toString to print contents of the inventory Array
	 */
	@Override
	public String toString() { // overloaded to string to print item array
		String text = "";
		for (int i = 0; i < numItems; i++) // loops through entire array
			text += inventory[i].toString() + "\n";
		return text;
	}
}
