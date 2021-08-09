import java.util.Scanner;
// class for nonfiction books; prints and reads
/**
 *Class holds all variables of a nonFiction book and prints accordingly
 */
public class NonFiction extends Book{
    // variable for nonfiction books
    /**
     * nonfiction book type variable
     */
    protected String bookType;

    // reads in info for a book entry
    /**
     * method reads in information of a nonfiction book
     * @param input Keyboard scanner
     */
    @Override
    public void readInBook(Scanner input){
        System.out.print("Enter book ID: ");
        id = input.nextInt();
        input.nextLine(); // clear buffer
        System.out.print("Enter book title: ");
        title = input.nextLine();
        System.out.print("Enter book author: ");
        author = input.nextLine();
        System.out.print("Enter book subject type: ");
        bookType = input.nextLine();
    }

    // prints fiction book information
    /**
     * method prints out information of a fiction book
     */
    @Override
    public void printBookInfo(){
        System.out.printf(
                "%6s | %30s | %20s | %15s |",id, title, author, bookType);
    }
}
