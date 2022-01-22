import java.io.*;
import java.util.*;
/**
 * CET - CS Academic Level 3 Declaration: I declare that this is my own original
 * work and is free from plagiarism
 * This class contains the data structure for my inventory.
 * It also controls adding to the data structure and buying or selling
 * Student Name: Donald Sincennes
 * Student Number: 41011305
 * Section Number: 304
 * Course: CST8130 - Data Structures - Assignment 1
 * Professor: James Mwangi PhD
 *
 * @author Donald Sincennes
 */
public class Inventory { // Class holds arrayList of inventory. It also controls adding, buying and
							// selling of items.

	/**
	 * number of items in the inventory ArrayList
	 */
	private int numItems; // Variable to control number of items added to array
	/**
	 * Inventory arrayList, stores all items being held to buy or sell
	 */
	private final ArrayList<FoodItem> inventory; // inventory arrayList

	/**
	 * Default Constructor, sets numItems to zero, and instantiates the array to
	 * size 20
	 */
	public Inventory() {
		numItems = 0;
		inventory = new ArrayList<>();
	}

	/**
	 * This method is used to search for a specific food type, based on its item
	 * code. It calls input code to verify proper input, checks whether it already
	 * exists, and prints out the item if it is found.
	 *
	 * @param scan Scanner object for user input
	 */
	public void searchForItem(Scanner scan) {
		FoodItem food = new Fruit();
		food.inputCode(scan, false);
		int itemLocation = alreadyExists(food);
		if (itemLocation == -1) // itemLocation returns -1 if no item is found
			System.out.println("Code not Found in inventory...");
		else
			System.out.println(inventory.get(itemLocation).toString());
	}

	/**
	 * This method reads different food types from a file specified by the user.
	 *
	 * @param reader scanner object to read food types from a file
	 */
	public void readFromFile(Scanner reader) {
		System.out.print("Enter file to read from: ");
		String file = reader.nextLine();
		FoodItem item = null;
		File inventoryFile = new File(file);
		try {
			reader = new Scanner(inventoryFile);
			String type;
			char foodType;
			while (reader.hasNext()) {
				type = reader.nextLine();
				foodType = type.charAt(0);
				if (foodType == 'f') { // fruit object is created if user specifies f as input
					item = new Fruit();
				} else if (foodType == 'v') { // vegetable object is created if user specifies v as input
					item = new Vegetable();
				} else if (foodType == 'p') { // Preserve object is created if user specifies p as input
					item = new Preserve();
				} else {
					foodType = 0;
				}
				if (foodType != 0) { // If successful foodType is created, prompt user for code input.
					item.inputCode(reader, true);
					if (alreadyExists(item) == -1) { // if code input doesn't already exist, add item via user input and
														// sort the list.
						item.addItem(reader, true);
						inventory.add(item);
						Collections.sort(inventory);
						numItems++;
					} else {
						System.out.println("Item Code Already Exists");
						System.out.println("Error Encountered while reading the file, aborting...");
						break;
					}
				}
			}
		} catch (SecurityException | NoSuchElementException e) {
			System.out.println("Error while reading from file.");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, ignoring...");
		}
	}

	/**
	 * This method saves the food list created to a file specified by a user.
	 * 
	 * @param scan scanner objet for user input
	 */
	public void saveToFile(Scanner scan) {
		System.out.print("Enter the filename to save to: ");
		String fileName = scan.nextLine();
		try {
			Formatter form = new Formatter(fileName);
			for (int i = 0; i < numItems; i++) { // iterates through the list to write each food type to the file.
				inventory.get(i).outputItem(form);
			}
			form.close(); // close formatter
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, ignoring...");
		}
	}

	/**
	 * This method uses iterative binary search to search through lists to see if
	 * itemCode already exists.
	 *
	 * @param item passed object FoodItem
	 * @return returns -1 if item code already exists
	 */
	public int alreadyExists(FoodItem item) {
		int start = 0;
		int end = numItems;
		while (start < end) {
			int midpoint = (start + end) / 2;
			if (inventory.get(midpoint).getItemCode() == item.getItemCode()) { // If code is found. returns index where
																				// it is found.
				return midpoint;
			} else if (inventory.get(midpoint).getItemCode() < item.getItemCode()) { // splits list in half to find item
																						// code
				start = midpoint + 1;
			} else {
				end = midpoint;
			}
		}
		return -1;
	}

	/**
	 * This method is used to add items to the array based on which item is called,
	 * the method will create a new fruit, vegetable, or preserve. if true, reads
	 * from file, else user input
	 *
	 * @param scan     Scanner for user input
	 * @param fromFile boolean to determine if reading from file for true, or user
	 *                 input for false
	 * @return true if item is added
	 */
	public boolean addItem(Scanner scan, boolean fromFile) {
		if (fromFile) { // read from file
			readFromFile(scan);
		} else { // user input
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
			if (food.inputCode(scan, false)) { // checking for correct input code
				if (alreadyExists(food) < 0) { // checking if item code exits
					food.addItem(scan, false);
					inventory.add(food);
					Collections.sort(inventory);
					numItems++;
					return true;
				} else {
					System.out.println("Item code exists");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method is used to update the quantity in the array depending on if a
	 * user buys or sells a certain item.
	 *
	 * @param scan      Scanner for user input
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
		} else if (!buyOrSell && numItems == 0) { // empty array
			System.out.println("Error... could not sell item");
			return false;
		}
		do {
			try {
				System.out.print("Enter code of item: ");
				tempCode = scan.nextInt();
				goodData = true;
			} catch (InputMismatchException e) {
				System.out.println("Error while reading code");
				scan.nextLine();
			}
		} while (!goodData);
		for (int i = 0; i < numItems; i++) { // searching through entire array for item code
			if (inventory.get(i).getItemCode() == tempCode) {
				food = inventory.get(i);
			}
		}
		if (food == null) { // item not found with given code
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
				} else { // sell
					System.out.print("Enter valid quantity to sell: ");
					food.updateItem(scan.nextInt() * -1);
				}
				goodData = true;
			} catch (InputMismatchException e) {
				System.out.println("Error while reading code");
				scan.nextLine();
			}
		} while (!goodData);
		scan.nextLine(); // clear buffer
		return true;
	}

	/**
	 * Override toString to print contents of the inventory Array
	 */
	@Override
	public String toString() { // overloaded to string to print item array
		StringBuilder text = new StringBuilder();
		for (int i = 0; i < numItems; i++) // loops through entire array
			text.append(inventory.get(i).toString()).append("\n");
		return text.toString();
	}
}
