import java.util.Scanner;
/**
* CET - CS Academic Level 3 Declaration: I declare that this is my own original
* work and is free from plagiarism 
* This class controls the adding of Preserves
* Student Name: Donald Sincennes 
* Student Number: 41011305 
* Section Number: 304 
* Course: CST8130 - Data Structures - Assignment 1 
* Professor: James Mwangi PhD
*
* @author Donald Sincennes
*/
public class Vegetable extends FoodItem { // Class controls adding of Vegetables
	/**
	 * Farm Name for all Vegetable items being stores
	 */
	private String farmName;

	/**
	 * Default constructor, sets farmName to blank
	 */
	public Vegetable() {
		farmName = "";
	}

	/**
	 * Overrided addItem method, calls super of addItem class, then adds onto it with jar size
	 */
	@Override
	public boolean addItem(Scanner scan) { // adds info to the Vegetable item
		super.addItem(scan);
		System.out.print("Enter the name of the farm supplier: ");
		farmName = scan.nextLine();
		return true;
	}

	/**
	 * Override'd toString, adds orchard supplier to end of the inventory 
	 */
	@Override
	public String toString() { // adds farmname to parent toString
		return super.toString() + " Farm Supplier: " + farmName;
	}
}
