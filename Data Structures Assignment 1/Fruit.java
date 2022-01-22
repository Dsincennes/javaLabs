import java.util.Scanner;

/**
* CET - CS Academic Level 3 Declaration: I declare that this is my own original
* work and is free from plagiarism 
* This class controls the adding of Fruits
* Student Name: Donald Sincennes 
* Student Number: 41011305 
* Section Number: 304 
* Course: CST8130 - Data Structures - Assignment 1 
* Professor: James Mwangi PhD
*
* @author Donald Sincennes
*/
public class Fruit extends FoodItem { // class is for Fruit object adding
	/**
	 * Name of Orchard for fruit objects
	 */
	private String orchardName; // stores name of fruit store

	/**
	 * Default constructor, sets name to blank
	 */
	public Fruit() {
		orchardName = "";
	}

	/**
	 * Overrided addItem method, calls super of addItem class, then adds onto it with orchard supplier
	 */
	@Override
	public boolean addItem(Scanner scan) { // adds info to the fruit item
		super.addItem(scan);
		System.out.print("Enter the name of the orchard supplier: ");
		orchardName = scan.nextLine();
		return true;
	}

	/**
	 * Override'd toString, adds orchard supplier to end of the inventory 
	 */
	@Override
	public String toString() { // Override'd to string for array printing. 
		return super.toString() + " Orchard Supplier: " + orchardName;
	}
}
