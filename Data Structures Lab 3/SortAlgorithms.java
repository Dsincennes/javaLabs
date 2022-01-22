import java.util.Arrays;

//class that holds all worker methods for sorting
/**
 * CET - CS Academic Level 3 Declaration: I declare that this is my own original
 * work and is free from Plagiarism 
 * This class all worker methods for sorting
 * Student Name: Donald Sincennes 
 * Student Number: 41011305 
 * Section Number: 304
 * Course: CST8130 - Data Structures - Lab3 
 * Professor: James Mwangi PhD.
 *
 * @author Donald Sincennes
 */
public class SortAlgorithms {

	/**
	 * Purpose of this method is to have an array passed to it, to then print the
	 * elements inside.
	 * 
	 * @param intArray Array passed to print
	 */
	public void printArray(int[] intArray) { // prints array thats passed
		System.out.println(Arrays.toString(intArray));
		System.out.println();
	}

	/**
	 * This Method Sorts an array by bubble sort. it compares it self to to the
	 * adjacent element, and swaps it if it is smaller than it.
	 * 
	 * @param intArray Array passed to be sorted
	 */
	public void bubbleSort(int[] intArray) { // Sorts array By bubble Sort, compares Adjacent elements, and swaps when
												// necessary
		// Goes through the list backwards to make sure all elements are checked
		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			// goes through each adjacent index, if the element to the right is smaller,
			// elements swap
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i + 1);
				}
			}
		}
		System.out.println("Bubble Sort: Simple sorting algorithm  - O(n2) Complexity   -  \n");
		printArray(intArray);
	}

	/**
	 * This method performs element Swaps, which is used in many Sorting methods. It
	 * stores an element into a temp element, and swaps the values so that values
	 * are never lost
	 * 
	 * @param array array passed with elements to be swapped
	 * @param i     first element to be swapped
	 * @param j     second element to be swapped
	 */
	public void swap(int[] array, int i, int j) { // Swap method, swaps elments by storing element 1 in a temp array so
													// that no element is lost

		if (i == j) {
			return;
		}

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	/**
	 * The array is split into a sorted and an unsorted array. Values from the
	 * unsorted half are picked and placed at the correct position in the sorted
	 * half.
	 * 
	 * @param intArray Array to be passed to be sorted
	 */
	public void insertionSort(int[] intArray) {
		// set first unsorted half to index 1 to the lenghth of array, and traverse
		// through it
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
			int newElement = intArray[firstUnsortedIndex]; // new element to be compared
			int i;
			// checks if new element is greater to the element to its left all the way to
			// element zero
			for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
				intArray[i] = intArray[i - 1];
			}
			// sets element to its new sorted position
			intArray[i] = newElement;
		}
		System.out.println("Insertion Sort: Simple sorting algorithm  - O(n2) Complexity  - \n");
		printArray(intArray);
	}

	/**
	 * This Method of sorting goes through entire array elements from 0 to length,
	 * and searches for the highest value, then puts it at the end of array when it
	 * is found
	 * 
	 * @param intArray array passed to be sorted
	 */
	public void selectionSort(int[] intArray) { // searches from 0 - 1000, stores the highest value, then swaps it to
												// the last position
		// sets last unsorted to the last index and goes to the start of the array
		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			int largest = 0;
			/*
			 * searches through entire array comparing each element along the way. Each time
			 * an element is greater then the one compared Each time it finds one, it sets
			 * that value to largest and keeps going.
			 */
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[largest]) {
					largest = i;
				}
			}
			// swapping indexes to store the largest in its correct sorted position
			swap(intArray, largest, lastUnsortedIndex);
		}
		// printing elements
		System.out.println("Selection Sort: Simple sorting algorithm  - O(n2) Complexity  - \n");
		printArray(intArray);
	}

	/**
	 * Methods sole purpose is to call the mergeSort method and print it.
	 * 
	 * @param intArray array passed to be sorted
	 */
	public void mergeSortMain(int[] intArray) { // calling merge sort to keep menu clean
		mergeSort(intArray, 0, intArray.length);
		System.out.println("Merge Sort: Recursive Divide-And-Conquer - O(n log n) Complexity - \n");
		printArray(intArray);
	}

	/**
	 * 
	 * @param input array passed to me sorted
	 * @param start start index set to 0 for the sort
	 * @param end   end index which is the length of the array for sorting
	 */
	public void mergeSort(int[] input, int start, int end) {
		if (end - start < 2) {
			return;
		}
		int mid = (start + end) / 2; // dividing the array in half
		mergeSort(input, start, mid); // recursion, creating half an array to sort
		mergeSort(input, mid, end); // recursion, creating half an array to sort
		merge(input, start, mid, end); // calling merge method
	}

	/**
	 * 
	 * @param input array passed to be sorted
	 * @param start start index for where to begin sorting
	 * @param mid   end or start index depending on which half of the array is being
	 *              sorted
	 * @param end   end index for where to end the sort
	 */
	public void merge(int[] input, int start, int mid, int end) {
		/*
		 * optimization, this means when merging sorted arrays, if mid - 1 which is the
		 * last element in the left array is less then the value in the mid value which
		 * is the first element in the right array, then the both sides are already
		 * sorted when they become merged
		 */
		if (input[mid - 1] <= input[mid]) {
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		int[] temp = new int[end - start]; // new temp array
		// when i is less than mid or j less than mid, the array is sorted
		while (i < mid && j < end) {
			// if element i is less than j, then assigns left or right ternary options,
			// repeating while start is less than mid or mid < end
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
		}

		System.arraycopy(input, i, input, start + tempIndex, mid - i); // merging elements from left array
		System.arraycopy(temp, 0, input, start, tempIndex); // merging elements from temp array

	}

	/**
	 * This methods purpose is to call quick sort, to keep menu clean
	 * 
	 * @param intArray array passed to be sorted
	 */
	public void quickSortMain(int[] intArray) { // Calls quicksort

		quickSort(intArray, 0, intArray.length);
		System.out.println("Quick Sort: Recursive Divide-And-Conquer - O(n log n) Complexity - \n");
		printArray(intArray);
	}

	/**
	 * This method quick sorts a left sub array and right sub array by splitting
	 * elements that are less then a pivot and greater then a pivot in left and
	 * right arrays.
	 * 
	 * @param input array passed to be sorted
	 * @param start index where the sorting begins
	 * @param end   index where the sorting ends
	 */
	public static void quickSort(int[] input, int start, int end) {
		// 1 element array, don't need to do anything so just return
		if (end - start < 2) {
			return;
		}

		int pivotIndex = partition(input, start, end);
		quickSort(input, start, pivotIndex); // sort indexes in left array from 0 to pivot
		quickSort(input, pivotIndex + 1, end); // sort indexes in right array from pivot to length
	}

	/**
	 * This method picks an element as pivot, and partitions the array around the pivot. 
	 * All elements smaller then the pivot get put into the left side, and all elements greater
	 * get put in the right side
	 * 
	 * @param input array passed to be sorted
	 * @param start index where sorting begins
	 * @param end index where sorting ends.
	 * @return j element which is the index where we insert the pivot
	 */
	public static int partition(int[] input, int start, int end) {
		// This is using the first element as the pivot
		int pivot = input[start];
		int i = start;
		int j = end;

		while (i < j) {
			// Empty loop to find element less than pivot
			while (i < j && input[--j] >= pivot); // when i crosses j, it stops, or if it finds element that is less
			
			if (i < j) { // if an element that is less than the pivot is found, we assign it to j
				input[i] = input[j];
			}
			// empty loop to find element greater than pivot
			while (i < j && input[++i] <= pivot)
				;
			if (i < j) { // if an element if found greater then element, we assign it to j
				input[j] = input[i];
			}
		}
		input[j] = pivot;
		return j;
	}

}
