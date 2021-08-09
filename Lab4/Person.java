/*
 * Assessment: Lab 4
 * Student Name: Donald Sincennes
 * Due Date: 07/1/21
 * Description: A banking system, that holds accounts and processes fees or interest.
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;

/**
 * Class that reads and stores information of a person.
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public class Person {

	// instance variables of a person
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;

	// no arg constructor
	public Person() {
	}

	// parameterized constructor that sets all information of a person
	public Person(String fName, String lName, String email, long phoneNumber) {
		firstName = fName;
		lastName = lName;
		this.email = email;
		this.phoneNumber = phoneNumber;

	}

	/**
	 * getter for full name
	 * @return
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * getter for email
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * getter for phone number
	 * @return
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * reads all personal details of a person.
	 * @param input
	 * 
	 */
	public void readPersonalDetails(Scanner input) {
		System.out.print("Enter first name: ");
		firstName = input.nextLine();
		System.out.print("Enter last name: ");
		lastName = input.nextLine();
		System.out.print("Enter email: ");
		email = input.nextLine();
		System.out.print("Enter phone number: ");
		phoneNumber = User.inputLong(input);
	}
}
