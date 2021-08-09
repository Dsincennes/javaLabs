/*
 * Assessment: Lab 3
 * Student Name: Donald Sincennes
 * Due Date: 06/20/21
 * Description: A program that stores info on a student including GPA and fees.
 * Professor Name: Dr. James Mwandi
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class that holds and prints all info of the college.
 * 
 * @author Donald Sincennes
 *
 * @version 1.0
 * @since 11.0
 */
public class College {

	// instance variables for college name, and number of students array.
	private String name;
	private ArrayList<Student> students;

	/**
	 * constructor for college name and student array list
	 * 
	 * @param name        college name
	 * @param numStudents sets input from user to name and students
	 */
	College(String name, int numStudents) {
		this.name = name;
		students = new ArrayList<Student>(numStudents);
	}

	/**
	 * printTitle method that prints out the list of students header and title
	 */
	public void printTitle() {
		if (students.size() == 0) {
			System.out.println("\n##### No Students To Display #####");// incase no students have been read, no student
																		// display
		} else {
			for (int i = 0; i < 122; i++) { // for loop for title format 122 "="s
				System.out.print("=");
			}
			System.out.println();
			System.out.printf("%60s - List of Students\n", name);
			System.out.println();
			for (int i = 0; i < 122; i++) { // for loop for title format 122 "="s
				System.out.print("=");
			}
			System.out.println();
			System.out.printf("%7s | %8s | %25s | %25s | %12s | %5s | %10s | %7s |\n", "Program", "Student#", "Name",
					"Email", "Phone", "GPA", "Fees", "Credits");
		}
	}

	/**
	 * Method that reads a student type, fulltime or parttime, then creates that
	 * student type object and reads their info
	 * 
	 * @param input
	 */
	public void readStudentsDetails(Scanner input) {

		int studentType = 0;
		boolean goodData = false;

		while (goodData == false) {
			try {
				System.out.println("Enter details of student " + students.size() + ": ");
				System.out.println("==========================");
				System.out.println("1 - Fulltime student");
				System.out.println("2 - Parttime student");
				System.out.print("Enter student type: ");

				studentType = input.nextInt();

				input.nextLine(); // clear buff

			} catch (InputMismatchException e) { // catches invalid input
				System.err.println("Input Mismatch Exception while reading student type");
				input.next();
			}

			switch (studentType) {

			// case 1 reads information of a fulltime students and stores it in students
			// array.
			case 1:
				Student fullTimeStudent = new FulltimeStudent();
				students.add(fullTimeStudent);
				fullTimeStudent.readInfo(input);
				goodData = true;
				return;

			// case 2 reads information of a fulltime students and stores it in students
			// array.
			case 2:
				Student partTimeStudent = new ParttimeStudent();
				students.add(partTimeStudent);
				partTimeStudent.readInfo(input);
				goodData = true;
				return;

			// default case that lets user know an incorrect student type is used.
			default:
				System.out.println("Wrong student type");
				break;

			}
		}
	}

	/**
	 * method that reads student info from a text file
	 * 
	 * @param input
	 */
	public void readFromFile(Scanner input) {

		try {
			File studentFile = new File("students.txt");
			input = new Scanner(studentFile);

			while (input.hasNextLine()) { // while loop that keeps going as long as their is multiple lines to read in
											// the text file

				String lines = input.nextLine();
				String[] info = lines.split(" "); // creates array and splits each line by the space

				// setting student info from created array
				String studentType = info[0];
				int studentNumber = Integer.parseInt(info[1]);
				String firstName = info[2];
				String lastName = info[3];
				String email = info[4];
				long phoneNumber = Long.parseLong(info[5]);
				String programName = info[6];
				double gpa = Double.parseDouble(info[7]);
				double fees;

				if (studentType.equalsIgnoreCase("f")) { // f for fulltime, first line in the text file

					FulltimeStudent student = new FulltimeStudent();
					fees = Double.parseDouble(info[8]);
					student.studentNumber = studentNumber;
					student.firstName = firstName;
					student.lastName = lastName;
					student.emailId = email;
					student.phoneNumber = phoneNumber;
					student.programName = programName;
					student.gpa = gpa;
					student.tuitionFees = fees;
					students.add(student);

				} else if (studentType.equalsIgnoreCase("p")) { // p for parttime, first line in text file

					ParttimeStudent student = new ParttimeStudent();
					fees = Double.parseDouble(info[8]);
					student.courseFeesTotal = fees;
					double credits = Double.parseDouble(info[9]);
					student.credits = credits;
					student.studentNumber = studentNumber;
					student.firstName = firstName;
					student.lastName = lastName;
					student.emailId = email;
					student.phoneNumber = phoneNumber;
					student.programName = programName;
					student.gpa = gpa;
					students.add(student);
				}
			}
		} catch (FileNotFoundException | SecurityException | NoSuchElementException e) { // catches no file found
			System.err.println("input mismatch exception while reading from file");
		}
	}

	/**
	 * prints student details based on how many students their is saved in the
	 * students array
	 */
	public void printStudentDetails() {
		for (int i = 0; i < students.size(); i++) { // goes through the array list as i and prints each student detail
			students.get(i).printInfo();
		}
		System.out.println();
	}

}
