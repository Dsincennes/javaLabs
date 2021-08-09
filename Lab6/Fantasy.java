import java.util.Scanner;

// class for Fantasy books
/**
 * Class that stores genre for all Fantasy books
 */
public class Fantasy extends Fiction{

    // Genre string for books
    /**
     * Genre variable for all books
     */
    protected String genre;

    // overrides to read genre
    /**
     * method overridden to add genre variable for fantasy books
     * @param input keyboard scanner
     */
    @Override
    public void readInBook(Scanner input) {
        super.readInBook(input);
        System.out.print("Enter book Genre: ");
        genre = input.next();
    }

    // overrides to print genre
    /**
     * method that updates printBookInfo method to add genre variable
     */
    @Override
    public void printBookInfo(){
        super.printBookInfo();
        System.out.printf(" %10s |\n", genre);
    }
}
