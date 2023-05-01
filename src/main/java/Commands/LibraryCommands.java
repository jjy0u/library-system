package Commands;

import Books.Book;
import Books.LoanedBook;
import Library.Library;
import Users.CurrentUser;

import java.util.Objects;
import java.util.Scanner;

public class LibraryCommands {
    private static CurrentUser currentUser;

    static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public LibraryCommands(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public static void menu() {
            System.out.println("What would you like to do?\n\n"+
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
                    redirectUser();
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

    }

    private static void searchForBook() {

    }

    private static void listAvailableBooks() {
        library.listAvailableBooks();
    }

    public static void redirectUser() {
        System.out.println("Would you like to loan a book?\n\n" +
                "1. Yes\n" +
                "2. No, return to main menu\n");
        String userInput = LibraryWelcome.validateInput("");
        if (Objects.equals(userInput, "1")){
            System.out.println("Please state the number of the book");
            int bookNumber = Integer.parseInt(scanner.nextLine());
            for (Book book : library.getAvailableBooks()) {
                if (book.getNumber() == bookNumber){
                    library.loanBook(currentUser.getLibraryUser());
                    System.out.println("you have loaned " + book.getTitle() +" by " + book.rearrangeAuthor() + ". Please return by " + library.getLoanedBooks().get(0).getDueDate() + ".");
                    redirectUser();
                }
            }
        }
    }

}



