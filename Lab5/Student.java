
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
 * Class that reads info, and marks and then calculates gpa of a student.
 * 
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public class Student extends Person implements Policies {

	// instance variables for a Generic Student.
	protected int studentNumber;
	protected String programName;
	protected double gpa;

	/**
	 * no arg constructor
	 */
	Student() {
	}

	/**
	 * method is basic info of a general student.
	 */
	@Override
	public void readInfo(Scanner input) {

		boolean goodData = false;

		while (goodData == false) { // exception handling invalid input
			try {
				System.out.print("Enter program name: ");
				programName = input.nextLine();
				System.out.print("Enter student number: ");
				studentNumber = input.nextInt();
				input.nextLine(); // clear buffer
				System.out.print("Enter first name: ");
				firstName = input.nextLine();
				System.out.print("Enter last name: ");
				lastName = input.nextLine();
				System.out.print("Enter email Id: ");
				emailId = input.nextLine();
				System.out.print("Enter phone number: ");
				phoneNumber = (long) input.nextLong();
				readMarks(input);
				goodData = true;
			} catch (InputMismatchException e) {
				System.err.println("inputmismatch when inputting student info");
				input.nextLine(); // clear buffer
			}
		}
	}

	/**
	 * method that reads marks of all students courses.
	 */
	private void readMarks(Scanner input) {
		System.out.print("Enter number of courses: ");
		int courses = input.nextInt();
		while (courses <= 0) { // Ensuring courses are inputted above 0
			System.out.print("Please enter Number above 0: ");
			courses = input.nextInt();
		}
			double[] courseMarks = new double[courses]; // course array
			for (int i = 0; i < courses; i++) { // i as number of courses and goes through each course marks
				System.out.print("Enter mark " + (i + 1) + ": ");
				int mark = input.nextInt();
				while (mark > 100 || mark < 0) { // ensuring marks are read correctly
					System.out.println("please enter a mark under between 0-100");
					mark = input.nextInt();
				}
				courseMarks[i] = mark;
			}
			calculateGpa(courseMarks);
		}
	

	/**
	 * method that calculates a students gpa based on marks inputted.
	 */
	@Override
	public void calculateGpa(double[] marks) {
		double totalMark = 0.0;
		int numCourses = marks.length;
		for (int i = 0; i < numCourses; i++) { // for loop that goes through each mark inputted as i and calculates the gpa
			totalMark += marks[i];
		}
		gpa = totalMark / numCourses / MAXMARKS * MAXGPA;
	}

	/**
	 * method that prints info of a general student
	 */
	@Override
	public void printInfo() { // prints info for a student
		String fullName = firstName + " " + lastName;
		System.out.printf("%7s | %8s | %25s | %25s | %12s | %5.2f |", programName, studentNumber, fullName, emailId,
				phoneNumber, gpa);
	}

}
