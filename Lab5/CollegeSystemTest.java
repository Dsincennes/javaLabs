
/*
 * Assessment: Lab 3
 * Student Name: Donald Sincennes
 * Due Date: 06/20/21
 * Description: A program that stores info on a student including GPA and fees.
 * Professor Name: Dr. James Mwandi
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class holds main method of College info.
 * 
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 *
 */
public class CollegeSystemTest {

	/**
	 * 
	 * @param args method main, reads name of college, number of students, then
	 *             prints all info.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int exit = 0;
		int n;

		System.out.print("Enter name of College: "); // Getting input for college name
		String name = input.nextLine();

		while (true) {

			try {
				System.out.print("Enter number of students: "); // Request input number of students in college to read
				n = input.nextInt();
				input.nextLine();
				while (n <= 0) {
					System.out.println("Number of students should be positive.. please try again!");
					System.out.print("Enter number of students: ");
					n = input.nextInt();
				}
				break;

			} catch (InputMismatchException e) { // exception handling to make sure correct input is read
				System.err.print("Input mismatch Exception while reading student type\n");
				input.nextLine();
			}
		}

		College c1 = new College(name, n);
		// menu to read student info from file or keyboard, prints info or exits.
		do {
			try {
				System.out.println("1. Read Students info from keyboard");
				System.out.println("2. Read Students info from file");
				System.out.println("3. Print details of all students");
				System.out.println("4. Exit");
				System.out.print("Enter your option: ");
				int choice = input.nextInt();
				input.nextLine(); // clear buff
				switch (choice) {

				case 1:
					c1.readStudentsDetails(input); // reads student input via user input ( keyboard )
					break;

				case 2:
					c1.readFromFile(input); // reads student info from a file
					break;

				case 3:
					c1.printTitle();
					c1.printStudentDetails(); // prints all details of read students
					break;

				case 4:
					System.out.println("Goodbye... Have a nice day"); // exits
					exit = 99;
					break;

				default:
					System.out.println("Invalid entry... selection options 1-4... please try again!"); // default incase invalid input
					break;
				}
			} catch (InputMismatchException e) {
				System.err.print(
						"Input mismatch Exception while reading user's choice in main menu... please try again!\n"); // catches invalid input
				input.nextLine();
			}

		} while (exit != 99);
		input.close();
	}
}