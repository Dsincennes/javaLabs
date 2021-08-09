
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
 * class that reads and prints info of a part-time student.
 * 
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public class ParttimeStudent extends Student {

	// variables for part-time students only.
	double courseFeesTotal;
	double credits;

	/**
	 * method that reads in additional info required of a part-time student.
	 */
	@Override
	public void readInfo(Scanner input) { 

		boolean goodData = false;
		
		super.readInfo(input);
		while (goodData == false) { // exception handling
			try {
		System.out.print("Enter total course fees: ");
		courseFeesTotal = input.nextDouble();
		System.out.print("Enter credit hours: ");
		credits = input.nextDouble();
		goodData = true;
			}catch(InputMismatchException e) { // catches invalid input
				input.nextLine();
				System.err.print("input mismatch when reading part-time student info\n");
			}
		}
	}

	/**
	 * method that prints additional info of a part-time student.
	 */
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf(" %10.2f | %4.2f\n", courseFeesTotal, credits);
	}
}
