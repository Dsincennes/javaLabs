import java.util.Scanner;

// class for staff, holds information and prints
/**
 * Class that holds all information of a staff and prints
 *
 */
public class Staff extends User{

	/**
	 * floor a staff works on
	 */
	protected int floor;
	/**
	 * Section a staff works in
	 */
	protected String section;

	// manual input of a staff
	/**
	 * method reads information about a staff
	 * @param input keyboard scanner
	 */
	@Override
	public void readInfo(Scanner input) {
		super.readInfo(input);
		System.out.print("Enter Floor: ");
		floor = input.nextInt();
		System.out.print("Enter Section: ");
		section = input.next();
	}

	// prints staff information
	/**
	 * print format for staff information
	 */
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("%6s | %8s | %8s | %7s |\n","", "", floor, section);
	}
}
