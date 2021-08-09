/*
 * Assessment: Lab 6
 * Student Name: Donald Sincennes
 * Due Date: 07/1/21
 * Description: Library person
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;

// class that holds information of a person
/**
 * Class that reads and stores information of a person.
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public abstract class Person {

	// instance variables of a person
	protected String firstName;
	protected String lastName;
	protected String email;
	protected long phoneNumber;

	// no arg constructor
	/**
	 * no param constructor
	 */
	public Person() {
	}

	// placeholder method for users
	/**
	 * 
	 * abstract method, readinfo for use in student classes
	 */
	public void readInfo(Scanner input) {
	}

	// placeholder method for users
	/**
	 * abstract method for use in student classes
	 */
	public void printInfo() {
	}
}

