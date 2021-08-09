import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// member class, stores information pertaining to a member
/**
 * Class that stores all information of a member for the library
 *  @author Donald Sincennes
 *  *
 *  @version 1.0
 *  @since 11.0
 */
public class Member extends User implements Policies{
	// variables for members
	/**
	 * age variable for a member
	 */
	protected int age;
	/**
	 * balance for late fees
	 */
	protected int balance;
	/**
	 * array for each member amount of books loaned out
	 */
	protected ArrayList<Book> bookList = new ArrayList<>();

	// user input for a members
	/**
	 * method reads in information pertaining to a member
	 * @param input keyboard scanner
	 */
	@Override
	public void readInfo(Scanner input) {
		boolean goodData = false;
		super.readInfo(input);
		while (!goodData) {
			try {
				System.out.print("Enter Age: ");
				age = input.nextInt();
				goodData = true;
			} catch (InputMismatchException e) { // catches invalid input
				input.nextLine();
				System.err.print("input mismatch when reading full-time student info\n");
			}
		}
	}
	// member printing format
	/**
	 * prints information for a member
	 */
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf(" %5s | %8s | %8s | %7s | %30s |\n", age, balance, "", "", bookList);
	}
}
