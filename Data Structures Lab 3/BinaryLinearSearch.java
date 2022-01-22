import java.security.SecureRandom;
import java.util.Arrays;

// class that holds all worker methods for recursion and iterative searching
/**
 * CET - CS Academic Level 3 Declaration: I declare that this is my own original
 * work and is free from Plagiarism 
 * This class all worker methods for searching
 * Student Name: Donald Sincennes 
 * Student Number: 41011305 
 * Section Number: 304
 * Course: CST8130 - Data Structures - Lab2 
 * Professor: James Mwangi PhD.
 *
 * @author Donald Sincennes
 */
public class BinaryLinearSearch {
	/**
	 * private array, holds random numbers
	 */
	private static int[] array; // array that holds 30 random ints

	/**
	 * constructor to instantiate array
	 */
	public BinaryLinearSearch() { // instantiates array to size 30
		array = new int[1000];
	}

	/**
	 * Method is splitting array in half over and over to find that value being passed.
	 *
	 * @param array 30 random numbers
	 * @param value value passed to search
	 * @return returns index where value is located
	 */
	public int iterativeBinarySearch(int[] array, int value) { // Method searches for a value with binary method iteratively
		int start = 0;
		int end = array.length;

		while (start < end) {
			int midpoint = (start + end) / 2;
			if (array[midpoint] == value) {
				System.out.println(value + " was found at index " + midpoint + ": iterative Binary Search");
				return midpoint;
			} else if (array[midpoint] < value) {
				start = midpoint + 1;
			} else {
				end = midpoint;
			}
		}
		System.out.println(value + " was not found : iterative Binary Search");
		return -1;
	}

	/**
	 * Method searches for a value by splitting an array in half over and over by recursively
	 * calling the split method until it finds the value its looking for
	 *
	 * @param array 30 random numbers
	 * @param start first index
	 * @param end   last index
	 * @param value value to be searched
	 * @return index placement of value searched
	 */
	public int recursiveBinarySearch(int[] array, int start, int end, int value) { // searched for a value using binary and recursive calling
		if (start >= end) {
			System.out.println(value + " was not found : recursive binary Search");
			return -1;
		}
		int midpoint = (start + end) / 2;
		if (array[midpoint] == value) {
			System.out.println(value + " was found at index " + midpoint + ": recursive binary Search");
			return midpoint;
		} else if (array[midpoint] < value) {
			return recursiveBinarySearch(array, midpoint + 1, end, value);
		} else {
			end = midpoint;
			return recursiveBinarySearch(array, start, end, value);
		}

	}

	/**
	 * method generates random numbers and fills the numbers array
	 * 
	 * @return array returns array filled with 30 numbers ranged from 11 to 99
	 */
	public int[] generateRandomInts() { // generates random integers from 11-99 based on size of array
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < array.length; i++) { // iterates through array to generate random integers based on size
			array[i] = random.nextInt(979) + 21;
		}
		System.out.println("Array of randomly generated integers:");
		System.out.println(Arrays.toString(array));
		return array;
	}

	/**
	 * Method searched for a value by searching from the first element to the last.
	 *
	 * @param array 30 random numbers
	 * @param value value to be searched
	 * @return index of value searched
	 */
	public int iterativeLinearSearch(int[] array, int value) { // searches for value using iterative linear search
		for (int i = 0; i < array.length; i++) { // searches through entire array
			if (array[i] == value) {
				System.out.println(value + " was found at index " + i + ": iterative Linear Search");
				return i;
			}
		}
		System.out.println(value + " was not found : iterative Linear Search");
		return -1;
	}

	/**
	 * Method does a search by calling itself and searches from the beginning forward
	 * as well as the end backwards until it finds the value.
	 *
	 * @param array 30 random numbers
	 * @param start first index
	 * @param end   last index
	 * @param value value to be searched
	 * @return index of value searched
	 */
	public int recursiveLinearSearch(int[] array, int start, int end, int value) { // searches for a value using linear
																					// search recursively
		if (end < 1) {
			System.out.println(value + " was not found : Recursive Linear Search");
			return -1;
		}
		if (array[start] == value) {
			System.out.println(value + " was found at index " + start + ": recursive Linear Search");
			return start;
		}
		if (array[end] == value) {
			System.out.println(value + " was found at index " + end + ": recursive Linear Search");
			return end;
		}
		return recursiveLinearSearch(array, start + 1, end - 1, value);
	}
	
} // end class
