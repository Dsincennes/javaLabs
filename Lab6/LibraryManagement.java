import java.util.InputMismatchException;
import java.util.Scanner;

// test class, holds main method, to call all functions
/**
 * Class holds main method for library management system, calls all methods from menu
 *  @author Donald Sincennes
 *  *
 *  @version 1.0
 *  @since 11.0
 */
public class LibraryManagement {
    // variables for menu
    private static final int RENTBOOK = 0;
    private static final int RETURNBOOK = 1;
    private static final int READUSER = 2;
    private static final int READBOOK = 3;
    private static final int READFILE = 4;
    private static final int READBOOKSFILE = 5;
    private static final int PRINTUSERS = 6;
    private static final int PRINTBOOKS = 7;
    private static final int FEES = 8;
    private static final int EXIT = 9;

    /**
     * main method, holds menu for entire library management system
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        int num;

        System.out.print("Enter Library name: ");
        String name = input.nextLine();
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter number of Users: ");
                num = input.nextInt();
                while (num <= 0) {
                    System.out.println("Number of users should be positive.. please try again!");
                    System.out.print("Enter number of users: ");
                    num = input.nextInt();
                }
                break;

            } catch (InputMismatchException e) { // exception handling to make sure correct input is read
                System.err.print("Input mismatch while reading users\n");
                input.nextLine();
            }
        }

        Library l1 = new Library(name, num);

        do {
            try {
                System.out.println("0. Sign out a Book");
                System.out.println("1. Sign in a Book");
                System.out.println("2. Input Users");
                System.out.println("3. Input Books");
                System.out.println("4. Import Users from file");
                System.out.println("5. Import Books from file");
                System.out.println("6. Print Users");
                System.out.println("7. Print Books");
                System.out.println("8. Calculate Fee");
                System.out.println("9. Exit");
                System.out.print("Enter your option: ");
                int choice = input.nextInt();
                System.out.println();

                switch (choice) {
                    case RENTBOOK: // SIGN OUT BOOK
                        l1.rentBooks(input);
                        break;

                    case RETURNBOOK: // RETURN / SIGN IN BOOK
                        l1.returnBook(input);
                        break;

                    case READUSER: // READ IN USER DETAILS MANUALLY
                        l1.readUserDetails(input);
                        break;

                    case READFILE: // READ IN USER DETAILS FROM A FILE
                        l1.readUserFromFile(input);
                        break;

                    case READBOOK: // READ IN BOOK DETAILS MANUALLY
                        l1.readBookDetails(input);
                        break;

                    case READBOOKSFILE: // READ IN BOOK DETAILS FROM A FILE
                        l1.readBookFromFile(input);
                        break;

                    case PRINTBOOKS: // PRINT ALL BOOKS IN LIBRARY
                        l1.printBookTitle();
                        l1.printBooks();
                        break;

                    case PRINTUSERS: // PRINT ALL USERS IN LIBRARY
                        l1.printUserTitle();
                        l1.printUserDetails();
                        break;

                    case FEES: // CALCULATE LATE FEES
                        l1.calculateFee(input);
                        break;

                    case EXIT: // EXIT PROGRAM
                        System.out.println("Goodbye... Have a nice day"); // exits
                        exit = true;
                        break;

                    default: // DEFAULT FOR WRONG ENTRY
                        System.out.println("Invalid Entry, Select 1-9... Please try again!");
                        break;
                }
            }catch(InputMismatchException e) {
                System.err.print(
                        "Input mismatch Exception while reading user's choice in main menu... please try again!\n"); // catches invalid input
                input.nextLine();
            }

        } while (!exit);
        input.close();
    }
}
