import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// class with all worker methods, read, input, loan, fees, print for library
/**
 * Class that has all methods to read, print, and loan all books and users for the library
 *
 * @author Donald Sincennes
 *
 * @version 1.0
 * @since 11.0
 */
public class Library {
    // variables final for switch
    private static final int MEMBER = 1;
    private static final int STAFF = 2;
    /**
     * library name
     */
    private final String libraryName;
    /**
     * contains all users in library
     */
    private ArrayList<User> users;
    /**
     * contains all books in library
     */
    private ArrayList<Book> books;

    // constructor takes in library name, sets it. Also instantiates users arraylist and books
    /**
     * Constructor for Library name and number of users in system. Creates Arraylist of users and books.
     * @param libraryName Library Name
     * @param numUsers number of users in library
     */
    Library(String libraryName, int numUsers) {
        this.libraryName = libraryName;
        users = new ArrayList<>(numUsers);
        books = new ArrayList<>();
    }

    // allows staff to enter new users to library
    /**
     * Reads User details, either member or staff, then creates that type object.
     * @param input Keyboard scanner
     */
    public void readUserDetails(Scanner input) {
        int userType = 0;

        while (true) {
            try {
                System.out.println("User Type");
                System.out.println("==========================");
                System.out.println("1 - Member");
                System.out.println("2 - Staff");
                System.out.print("Enter type: ");
                userType = input.nextInt();
                input.nextLine(); // clear buffer

            } catch (InputMismatchException e) { // catches invalid input
                e.printStackTrace();
                input.next();
            }

            switch (userType) {
                case MEMBER: // new member
                    Member member = new Member();
                    users.add(member);
                    member.readInfo(input);
                    return;
                case STAFF: // new staff
                    Staff staff = new Staff();
                    users.add(staff);
                    staff.readInfo(input);
                    return;
                default: // default in case wrong entry
                    System.out.println("Wrong User type! Please Try again!");
                    break;
            }
        }
    }

    // allow books to be manually entered to the library
    /**
     * method that allows staff to read in books to the library manually.
     * @param input keyboard scanner
     */
    public void readBookDetails(Scanner input) {
        int bookType = 0;

        while (true) {
            try {
                System.out.println("Book type ");
                System.out.println("==========================");
                System.out.println("1 - Comic");
                System.out.println("2 - Fantasy");
                System.out.println("3 - History");
                System.out.println("4 - Science");
                System.out.println("5 - Biography");
                System.out.print("Enter type: ");
                bookType = input.nextInt();

            } catch (InputMismatchException e) { // catches invalid input
                e.printStackTrace();
                input.next();
            }

            switch (bookType) {
                case 1: // Adds new comic book
                    Comic comic = new Comic();
                    books.add(comic);
                    comic.readInBook(input);
                    return;

                case 2: // Adds new Fantasy book
                    Fantasy fantasy = new Fantasy();
                    books.add(fantasy);
                    fantasy.readInBook(input);
                    return;

                case 3: // Adds new History Book
                    History history = new History();
                    books.add(history);
                    history.readInBook(input);
                    return;

                case 4: // Adds new Science Book
                    Science science = new Science();
                    books.add(science);
                    science.readInBook(input);
                    return;

                case 5: // Adds new Biography Book
                    Biography biography = new Biography();
                    books.add(biography);
                    biography.readInBook(input);
                    return;

                default: // default for wrong input
                    System.out.println("Wrong book type! Please Try again!");
                    break;
            }
        }
    }

    // reads all users from .txt file, stores in users array
    /**
     * method that reads in user information from users.txt file and stores it in users arraylist
     * @param input passing scanner from main
     */
    public void readUserFromFile(Scanner input) {
        try {
            File studentFile = new File("Users.txt");
            input = new Scanner(studentFile);

            while (input.hasNextLine()) {
                String userType = input.next();
                if (userType.equalsIgnoreCase("Staff")) { // staff
                    Staff staff = new Staff();
                    staff.userType = userType;
                    staff.firstName = input.next();
                    staff.lastName = input.next();
                    staff.email = input.next();
                    staff.phoneNumber = input.nextLong();
                    staff.id = input.nextInt();
                    staff.floor = input.nextInt();
                    staff.section = input.next();
                    users.add(staff);
                }
                if (userType.equalsIgnoreCase("Member")) { // members
                    Member member = new Member();
                    member.userType = userType;
                    member.firstName = input.next();
                    member.lastName = input.next();
                    member.email = input.next();
                    member.phoneNumber = input.nextLong();
                    member.id = input.nextInt();
                    member.age = input.nextInt();
                    users.add(member);
                }
            }
        } catch (FileNotFoundException | SecurityException |  NoSuchElementException e) { // catches no file found
            e.printStackTrace();
        }
    }

    // reads all books from file, stores in books arraylist
    /**
     * Method that reads all books from a books.txt file and stores it into books array
     * @param input passing scanner from main
     */
    public void readBookFromFile(Scanner input) {
        try {
            File bookFile = new File("Books.txt");
            input = new Scanner(bookFile);

            while (input.hasNextLine()) {
                String lines = input.nextLine();
                String[] bookLines = lines.split(",");

                String bookGenre = bookLines[0];
                int bookId = Integer.parseInt(bookLines[1]);
                String bookTitle = bookLines[2];
                String author = bookLines[3];
                String bookType = bookLines[4];

                if (bookGenre.equalsIgnoreCase("fantasy")) { // fantasy books
                    Fantasy fantasy = new Fantasy();
                    fantasy.id = bookId;
                    fantasy.title = bookTitle;
                    fantasy.author = author;
                    fantasy.bookType = bookType;
                    fantasy.genre = bookGenre;
                    books.add(fantasy);
                } else if (bookGenre.equalsIgnoreCase("comic")) { // comic books
                    Comic comic = new Comic();
                    comic.id = bookId;
                    comic.title = bookTitle;
                    comic.author = author;
                    comic.bookType = bookType;
                    comic.genre = bookGenre;
                    books.add(comic);
                } else if (bookGenre.equalsIgnoreCase("biography")) { // biography books
                    Biography biography = new Biography();
                    biography.id = bookId;
                    biography.title = bookTitle;
                    biography.author = author;
                    biography.bookType = bookType;
                    biography.genre = bookGenre;
                    books.add(biography);
                } else if (bookGenre.equalsIgnoreCase("science")) { // science books
                    Science science = new Science();
                    science.id = bookId;
                    science.title = bookTitle;
                    science.author = author;
                    science.bookType = bookType;
                    science.genre = bookGenre;
                    books.add(science);
                } else if (bookGenre.equalsIgnoreCase("history")) { // history books
                    History history = new History();
                    history.id = bookId;
                    history.title = bookTitle;
                    history.author = author;
                    history.bookType = bookType;
                    history.genre = bookGenre;
                    books.add(history);
                }
            }
        } catch (FileNotFoundException | NoSuchElementException | SecurityException e) {
            e.printStackTrace();
        }
    }

    // finds book id in book array
    /**
     * Method that finds Book id in the library
     * @param id allow for book id to be passed into
     * @return returns book id
     */
    public Book findBookId(int id) {
        for (Book book : books) { // goes through arrayList and finds id passed into argument
            if (book.id == id)
                return book;
        }
        return null;
    }

    // finds the member ID that needs updating
    /**
     * method finds member id as inputted by staff
     * @param id member id as parameter to search for member
     * @return returns member id
     */
    public Member findMemberId(int id) {
        for (User user : users) { // goes through users array list and sets id equal to inputted id
            if (user.id == id) {
                return (Member) user;
            }
        }
        return null;
    }

    // adds book to specified user
    /**
     * Method loans out book, takes book id and user id as arguments, and adds book to user.
     * @param input keyboard scanner
     */
    public void rentBooks(Scanner input){
        System.out.print("Enter Book's ID: ");
        int bookId = input.nextInt();
        System.out.print("Enter Member's ID: ");
        int memberId = input.nextInt();
        System.out.println();

        Book b = findBookId(bookId);
            if ( b != null ){
                Member m = findMemberId(memberId);
                    if ( m != null ) {
                        if (m.bookList.size() == Policies.MAXBOOKS){
                            System.out.println("User already has Maximum of 5 Books!");
                            System.out.println();
                        } else {
                            m.bookList.add(b);
                        }
                    }
        }
    }

    // method calculates overdue balance
    /**
     * calculates late fee if books not returned in time
     * @param input keyboard scanner
     */
    public void calculateFee(Scanner input){
        System.out.print("Enter Member's ID: ");
        int memberId = input.nextInt();
        System.out.println();
        System.out.println("Enter days overdue");
        int days = input.nextInt();
        Member m = findMemberId(memberId);
        m.balance += (Policies.LATEFEE * days) * m.bookList.size(); // balance * 1$ * days inputted * amount of books
    }

    // returns a book based on the id given
    /**
     * method returns book based on id and user id
     * @param input keyboard scanner
     */
    public void returnBook(Scanner input){
        System.out.print("Enter Book's ID: ");
        int bookId = input.nextInt();
        System.out.print("Enter Member's ID: ");
        int memberId = input.nextInt();
        System.out.println();

        Book b = findBookId(bookId);
        if ( b != null ){
            Member m = findMemberId(memberId);
            if ( m != null ) {
                    m.bookList.remove(b);
                }
            }
        }


//    // method finds book id
//    /**
//     * method that finds a book by its id inputted by a staff
//     * @param id takes in staff's input for book id
//     * @return book id of specific book
//     */
//    public Optional<Book> findBookById(int id) {
//        return books
//                .stream()
//                .filter(book -> book.id == id)
//                .findFirst();
//    }
//
//    // method finds member id
//    /**
//     * @param id takes in staff's input for member id
//     * @return member id of a specific member
//     */
//    public Optional<Member> findMemberById(int id) {
//        return users
//                .stream()
//                .filter(Member.class::isInstance)
//                .map(Member.class::cast)
//                .filter(user -> user.id == id)
//                .findFirst();
//    }
//    // Rent book method, staff enters book id into specific member id requesting loan
//    /**
//     * Rent book method, takes in book id, members id, and adds book id to the member id.
//     * @param input keyboard Scanner
//     */
//    public void rentBook(Scanner input) {
//        System.out.print("Enter Book's ID: ");
//        int bookId = input.nextInt();
//        System.out.print("Enter Member's ID: ");
//        int memberId = input.nextInt();
//
//
//        Optional<Book> bookById = findBookById(bookId); // takes input for book id and sets it to findBookId
//        bookById.ifPresent(book -> {
//            Optional<Member> userOptional = findMemberById(memberId); // takes input for member id and sets it equal to find memberId
//            userOptional.ifPresent(member -> member.bookList.add(book)); // adds book id specific member requesting book
//        });
//    }

    // user title method
    /**
     * This method prints user title and headers for all users in the library.
     */
    public void printUserTitle() {
        if (users.size() == 0) {
            System.out.println("\n##### No users To Display #####");// in case no users have been read, no student
            // display
        } else {
            for (int i = 0; i < 165; i++) { // for loop for title format 165 "="s
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%75s - List of Users\n", libraryName);
            for (int i = 0; i < 165; i++) { // for loop for title format 165 "="s
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%8s | %8s | %25s | %25s | %12s | %5s | %8s | %8s | %7s | %30s |\n", "Type", "id", "Name", "Email", "Phone",
                    "Age", "balance", "Floor", "Section", "Books rented");
            for (int i = 0; i < 165; i++) { // for loop for title format 165 "="s
                System.out.print("=");
            }
            System.out.println();
        }
    }

    // prints users in the library
    /**
     * Method that prints all users in the library
     */
    public void printUserDetails() {
        for (User user : users) user.printInfo(); // goes through the users array list and prints each user detail
        System.out.println();
    }

    // prints all books in library
    /**
     * method prints all books in the library
     */
    public void printBooks() {
        for (Book book : books) book.printBookInfo(); // goes through the books array list and prints each book
        System.out.println();
    }

    // formatted printing headers for all books.
    /**
     * Method that prints title and headers for all books in the library
     */
    public void printBookTitle() {
        if (books.size() == 0) {
            System.out.println("\n##### No Books To Display #####");// in case no books have been read, no books display
        } else {
            for (int i = 0; i < 95; i++) { // for loop for title format 95 "="s
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%47s - List of Books\n", libraryName);
            for (int i = 0; i < 95; i++) { // for loop for title format 95 "="s
                System.out.print("=");
            }
            System.out.println();
            System.out.printf(
                    "%6s | %30s | %20s | %15s | %10s |\n"
                    , "ID", "Book Title", "Author", "Book Type", "Book Genre");
            for (int i = 0; i < 95; i++) { // for loop for title format 95 "="s
                System.out.print("=");
            }
            System.out.println();
        }
    }
}
