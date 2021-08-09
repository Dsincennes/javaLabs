/*
 * Assessment: Lab 3
 * Student Name: Donald Sincennes
 * Due Date: 06/20/21
 * Description: A program that stores info on a student including GPA and fees.
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;

/**
 * Person class that has all Basic information of a student and methods to be used for future
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public abstract class Person {

	// instance variables of a Person.
	protected String firstName;
	protected String lastName;
	protected String emailId;
	protected long phoneNumber;

	/**
	 * no param constructor
	 */
	Person() {
	}

	/**
	 * 
	 * abstract method, readinfo for use in student classes
	 */
	public void readInfo(Scanner input) {
	}

	/**
	 * abstract method for use in student classes
	 */
	public void printInfo() {
	}
}
