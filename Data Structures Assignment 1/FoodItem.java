import java.util.Scanner;

/**
* CET - CS Academic Level 3 Declaration: I declare that this is my own original
* work and is free from plagiarism 
* This class contains all methods for controlling what goes in and out of the food inventory
* Student Name: Donald Sincennes 
* Student Number: 41011305 
* Section Number: 304 
* Course: CST8130 - Data Structures - Assignment 1 
* Professor: James Mwangi PhD
*
* @author Donald Sincennes
*/
public abstract class FoodItem {
	/**
	 * Item Code of item being stored
	 */
	protected int itemCode;
	/**
	 * Item name of item being stored
	 */
	private String itemName;
	/**
	 * Item Price of item being stored
	 */
	private float itemPrice;
	/**
	 * Item Cost of item being stored
	 */
	private float itemCost;
	/**
	 * Item Quantity In Stock of item being stored
	 */
	private int itemQuantityInStock;

	/**
	 * Default Constructor, sets 0 or blank to all inventory variables
	 */
	public FoodItem() { // Default Constructor. settings zero values.
		this.itemCode = 0;
		this.itemName = "";
		this.itemPrice = 0.0f;
		this.itemQuantityInStock = 0;
		this.itemCost = 0.0f;
	}

	/**
	 * This method updates the stock based on the amount passed.
	 * If the resulting pass, would put amount to less than zero,
	 * method would return false.
	 * @param amount amount to update quantity
	 * @return returns true if successfully updates quantity
	 */
	public boolean updateItem(int amount) { // method updates quantity based on amount passed.
		if (itemQuantityInStock + amount < 0) { // checking if enough quantity in stock
			System.out.println("Not enough items");
			return false;
		} else {
			itemQuantityInStock += amount;
		}
		return true;
	}

	/**
	 * This method is checking to see if the item code passed is equal to any 
	 * item code already in the inventory Array.
	 * 
	 * @param item Item object passed in 
	 * @return returns true if item is equal to one in system, or false if not.
	 */
	public boolean isEqual(FoodItem item) { // method checks if item code is equal to one in the system.
		return itemCode == item.itemCode;
	}

	/**
	 * This method adds item details based on the item type passed from the addItem in Inventory Class.
	 * 
	 * @param scan scanner for user input
	 * @return returns true if items are added succesfully
	 */
	public boolean addItem(Scanner scan) { // Method adds item details for the object that calls it.
		Prompt p = new Prompt(scan); // Prompt Object for input validation
		itemName = p.prompt(scan::nextLine, "Enter the name for the item: ");  // asks user for name
		itemQuantityInStock = p.prompt(() -> { // asks user for quantity, if less than 0, throws runtime exception
			int stockQuantity = scan.nextInt();
			if (stockQuantity <= 0) {
				throw new RuntimeException(); // Cannot be negative
			}
			return stockQuantity;
		}, "Enter the quantity for the item: ");
		itemCost = p.prompt(() -> { // asks user for cost, if less than 0, throws runtime exception
			float cost = scan.nextFloat();
			if (cost <= 0) {
				throw new RuntimeException(); // Cannot be negative
			}
			return cost;
		}, "Enter the cost of the item: ");
		itemPrice = p.prompt(() -> { // asks user for price, if less than 0, throws runtime exception
			float price = scan.nextFloat();
			if (price <= 0) {
				throw new RuntimeException(); // Cannot be negative
			}
			return price;
		}, "Enter the sales price of the item: ");
		scan.nextLine(); // Clear Buffer
		return true;
	}
	
	/*
	 * In case Professor doesn't like helper class Creation
	 * 
	 * System.out.print("Enter the name for the item: "); itemName =
	 * scan.nextLine(); System.out.print("Enter the quantity for the item: ");
	 * itemQuantityInStock = scan.nextInt();
	 * System.out.print("Enter the cost of the item: "); itemCost =
	 * scan.nextFloat(); System.out.print("Enter the sales price of the item: ");
	 * itemPrice = scan.nextFloat(); } catch (InputMismatchException e) {
	 * System.err.println("Input mismatch error when reading addItem"); return
	 * false; }
	 */

	/**
	 * This method controls the input of the item code for the items in the inventory Array
	 * 
	 * @param scan scanner passed for user input
	 * @return returns true when code is correctly input by user.
	 */
	public boolean inputCode(Scanner scan) { // item code input method.
		boolean goodInput = false;
		while (!goodInput) {
			System.out.print("Enter the code for the item: "); // user input for item code
			if (scan.hasNextInt()) { // input validation
				goodInput = true;
			} else {
				System.out.println("Invalid code");
//				scan.nextLine(); // clear buffer
			}
			itemCode = scan.nextInt();
			scan.nextLine(); // clear buffer
		}
		return true;
	}

	/**
	 * Override'd toString method, to print all details of the inventory Array
	 */
	@Override
	public String toString() { // prints inventory array items, with formatted output.
		return String.format("Item: %d Name: %s Quantity: %d Price: $%.2f Cost: $%.2f", itemCode, itemName,
				itemQuantityInStock, itemPrice, itemCost);
	}
}
