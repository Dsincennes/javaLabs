import java.util.InputMismatchException;
import java.util.Scanner;

// reads in user information and prints
/**
 * Class that holds information of all users
 */
public class User extends Person {
	protected String userType;
	protected int id;

	// no arg constructor
	/**
	 * no arg constructor
	 */
	User() {
	}

	// reads information of a user
	/**
	 * method that reads information about a user
	 * @param input keyboard scanner
	 */
	@Override
	public void readInfo(Scanner input) {
		boolean goodData = false;
		
		while (!goodData) { // exception handling invalid input
			try {
				System.out.print("Enter User Type: ");
				userType = input.next();
				System.out.print("Enter ID: ");
				id = input.nextInt();
				input.nextLine(); // clear buffer
				System.out.print("Enter first name: ");
				firstName = input.nextLine();
				System.out.print("Enter last name: ");
				lastName = input.nextLine();
				System.out.print("Enter email Id: ");
				email = input.nextLine();
				System.out.print("Enter phone number: ");
				phoneNumber = input.nextLong();
				goodData = true;
			} catch (InputMismatchException e) {
				System.err.println("inputmismatch when inputting user info");
				input.nextLine(); // clear buffer
			}
		}
	}

	// prints information of a user
	/**
	 * prints information of a user
	 */
	public void printInfo() {
		String fullName = firstName + " " + lastName;
		System.out.printf(
				"%8s | %8s | %25s | %25s | %12s |",userType, id ,fullName, email, phoneNumber);
	}
}
