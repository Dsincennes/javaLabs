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
public class Preserve extends FoodItem { // Class controls adding of Preserve's
	/**
	 * Jar Size variable for Preserve objects
	 */
	private int jarSize;

	/**
	 * Default constructor, sets jar size to zero
	 */
	public Preserve() {
		jarSize = 0;
	}

	/**
	 * Overrided addItem method, calls super of addItem class, then adds onto it with jar size
	 */
	@Override
	public boolean addItem(Scanner scan) {// adds info to the Preserve item
		super.addItem(scan);
		System.out.print("Enter the size of the jar in millilitres: ");
		jarSize = scan.nextInt();
		return true;
	}
	
	/**
	 * Override'd toString, adds orchard supplier to end of the inventory 
	 */
	@Override
	public String toString() { // adds jarsize to parent toString
		return super.toString() + " Size: " + jarSize + "mL";
	}
}
