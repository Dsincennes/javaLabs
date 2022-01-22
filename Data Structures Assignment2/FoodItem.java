import java.util.Formatter;
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
public abstract class FoodItem implements Comparable <FoodItem>{
	/**
	 * Item Code of item being stored
	 */
	private int itemCode;

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
	 * Default Constructor, sets 0 to all inventory variables
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
	 * This method adds item details based on the item type passed from the addItem in Inventory Class.
	 * 
	 * @param scan scanner for user input
	 * @param fromFile boolean to determine if reading from file for true, or user input for false
	 * @return returns true if items are added successfully
	 */
	public boolean addItem(Scanner scan, boolean fromFile) { // Method adds item details for the object that calls it.
		if(fromFile){ // boolean for if reading from a file.
			itemName = scan.nextLine();
			itemQuantityInStock = scan.nextInt();
			itemCost = scan.nextFloat();
			itemPrice = scan.nextFloat();
		}else { // user input
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
		}
		scan.nextLine();
		return true;
	}

	/**
	 * This method controls the input of the item code for the items in the inventory Array
	 * 
	 * @param scan scanner passed for user input
	 * @param fromFile boolean to determine if reading from file for true, or user input for false
	 * @return returns true when code is correctly input by user.
	 */
	public boolean inputCode(Scanner scan, boolean fromFile) { // item code input method.
		if(fromFile){ // reading from file if true
			itemCode = scan.nextInt();
			scan.nextLine();
		}else { // user input , false
			boolean goodInput = false;
			while (!goodInput) {
				System.out.print("Enter the code for the item: "); // user input for item code
				if (scan.hasNextInt()) { // input validation
					goodInput = true;
					itemCode = scan.nextInt();
				} else {
					System.out.println("Invalid code");
				}
				scan.nextLine(); // clear buffer
			}
		}
		return true;
	}

	/**
	 * Overwritten toString method, to print all details of the inventory Array
	 */
	@Override
	public String toString() { // prints inventory array items, with formatted output.
		return String.format("Item: %d Name: %s Quantity: %d Price: $%.2f Cost: $%.2f", itemCode, itemName,
				itemQuantityInStock, itemPrice, itemCost);
	}

	/**
	 * This method formats the way a list is written to a file. every variable is placed on a new line starting by the food type.
	 *
	 * @param writer formatter object. For formatting output.
	 */
	public void outputItem (Formatter writer) {
		writer.format(
				"%d\n%s\n%d\n%.2f\n%.2f\n", itemCode, itemName, itemQuantityInStock, itemCost, itemPrice );
	}

	/**
	 * Overwritten CompareTo, used to compare item code's. when calling sort().
	 *
	 * @param food food object passed to method to get item code of specific item.
	 * @return returns value based on item code is less, equal or greater than its compared item code.
	 */
	@Override
	public int compareTo(FoodItem food) {
		return Integer.compare(itemCode, food.itemCode);
	}
	
	/**
	 * Method allows other classes access to itemCode variable
	 * @return returns the itemCode.
	 */
	public int getItemCode() {
		return itemCode;
	}
}
