import java.util.Scanner;

// class that stores basic information of a Book
/**
 * Abstract Class that holds variables for all books
 */
public abstract class Book {

	// Variables for book id, title and author
	/**
	 * book id variable
	 */
	protected int id;
	/**
	 * Book Title Variable
	 */
	protected String title;
	/**
	 * Book Author Variable
	 */
	protected String author;

	// placeholder method to input books
	/**
	 * abstract method for child classes to read in books from a keyboard
	 * @param input Keyboard scanner
	 */
	public void readInBook(Scanner input) {
		
	}

	// placeholder method to print information of books
	/**
	 * abstract method for child classes to print all book info for stored books in library
	 */
	public void printBookInfo() {
		
	}

	// prints book title when printing book array list
	/**
	 * overridden toString to return title name for any books a user has loaned out
	 * @return returns book title name when printing book array list
	 */
	@Override
	public String toString(){
		return title;
	}
}
