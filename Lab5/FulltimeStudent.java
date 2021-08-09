/*
 * Assessment: Lab 3
 * Student Name: Donald Sincennes
 * Due Date: 06/20/21
 * Description: A program that stores info on a student including GPA and fees.
 * Professor Name: Dr. James Mwandi
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that reads and prints info of full-time student.
 * 
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public class FulltimeStudent extends Student {

	// variable of a fulltime student only.
	double tuitionFees;

	/**
	 * method that reads info of a full-time student.
	 */
	@Override
	public void readInfo(Scanner input) {

		boolean goodData = false;

		super.readInfo(input);
		while (goodData == false) {
			try {
				System.out.print("Enter tuition fees: ");
				tuitionFees = input.nextDouble();
				goodData = true;
			} catch (InputMismatchException e) { // catches invalid input
				input.nextLine();
				System.err.print("input mismatch when reading full-time student info\n");
			}
		}
	}

	/**
	 * method that prints info of a full time students
	 */
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf(" %10.2f |\n", tuitionFees);
	}
}
