/*
 * Assessment: Lab 3
 * Student Name: Donald Sincennes
 * Due Date: 06/20/21
 * Description: A program that stores info on a student including GPA and fees.
 * Professor Name: Dr. James Mwandi
 */
/**
 * Interface class that holds instance variables to be used for GPA 
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public interface Policies {

	// constant instance variables for gpa calculation. 
	public static final int MAXMARKS = 100;
	public static final double MAXGPA = 4.0;
	
	/**
	 * method placement for future use in student class
	 * @param marks
	 * 
	 */
	public void calculateGpa(double[] marks);
}

