package Commands;

import Books.Book;
import Books.LoanedBook;
import Library.Library;
import Users.CurrentUser;
import Users.LibraryUser;

import java.util.Objects;
import java.util.Scanner;

public class LibraryCommands {
    private static CurrentUser currentUser;
    static Scanner scanner = new Scanner(System.in);
    public static Library library = new Library();

    public LibraryCommands(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public static void menu() {
            System.out.println( "What would you like to do, " + currentUser.getFirstName() + "?\n" +
            "1. View your loaned books\n" +
            "2. Search for a book\n" +
            "3. List all available books\n" +
            "4. Quit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    viewLoanedBooks();
                    break;
                case "2":
                    searchForBook();
                    break;
                case "3":
                    listAvailableBooks();
                    userLoanBook();
                    break;
                case "4":
                    System.out.println("Thank you for visiting The Library, Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    menu();
                    break;
            }

    }

    private static void viewLoanedBooks() {
        System.out.println("\nHere are the books you currently have loaned:");
        for (LoanedBook loanedBook : currentUser.getLibraryUser().getBooksLoaned()) {
            System.out.println("("+loanedBook.getBook().getNumber()+")    " + loanedBook.getBook().getTitle() + " by " + loanedBook.getBook().rearrangeAuthor() + " | due on: " + loanedBook.getDueDate());
        }
        returnBook();
    }

    private static void searchForBook() {

    }

    private static void listAvailableBooks() {
        library.listAvailableBooks();
    }

    public static void userLoanBook() {
        System.out.println("\nWould you like to loan a book?\n" +
                "1. Yes\n" +
                "2. No, return to main menu");
        String userInput = LibraryWelcome.validateInput("");
        if (Objects.equals(userInput, "1")){
            System.out.println("\nPlease state the number of the book you would like to borrow.");
            int bookNumber = Integer.parseInt(scanner.nextLine());
            for (Book book : library.getAvailableBooks()) {
                if (book.getNumber() == bookNumber) {
                    library.loanBook(bookNumber, currentUser.getLibraryUser());
                    currentUser.addLoanedBooks();
                    // add a "would like to loan xyz - yes or no" first
                    System.out.println("\nYou have loaned " + book.getTitle() +" by " + book.rearrangeAuthor() + ". Please return by " + library.getLoanedBooks().get(0).getDueDate() + ".");
                    userLoanBook();
                }
            }
        } else {
            menu();
        }
    }

    public static void returnBook() {
        System.out.println("\nWould you like to return a book?\n" +
                "1. Yes\n" +
                "2. No, return to main menu");
        String userInput = LibraryWelcome.validateInput("");
        if (Objects.equals(userInput, "1")){
            System.out.println("\nPlease state the number of the book you would like to return");
            int bookNumber = Integer.parseInt(scanner.nextLine());
            for (LoanedBook loanedBook : library.getLoanedBooks()) {
                if (loanedBook.getBook().getNumber() == bookNumber){
                    currentUser.removeLoanedBooks(bookNumber);
                    library.returnBook(bookNumber, currentUser.getLibraryUser());
                    System.out.println("\nYou have returned " + loanedBook.getBook().getTitle() +" by " + loanedBook.getBook().rearrangeAuthor() + ".");
                    returnBook();
                }
            }
        } else {
            menu();
        }
    }

}



