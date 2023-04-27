package Library;

import Books.Book;
import Books.LoanedBook;
import Users.AdminUser;
import Users.LibraryUser;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks = new ArrayList<>();
    private ArrayList<LoanedBook> loanedBooks = new ArrayList<>();
    private ArrayList<LibraryUser> libraryUsersList = new ArrayList<>();
    private ArrayList<AdminUser> adminUsersList = new ArrayList<>();

    public Library() {
    }

    public Library(ArrayList<Book> availableBooks, ArrayList<LoanedBook> loanedBooks, ArrayList<LibraryUser> libraryUsersList, ArrayList<AdminUser> adminUsersList) {
        this.availableBooks = availableBooks;
        this.loanedBooks = loanedBooks;
        this.libraryUsersList = libraryUsersList;
        this.adminUsersList = adminUsersList;
    }

    {
        populateLibrary();
    }

    public void populateLibrary(){
    }

    public ArrayList<LoanedBook> getLoanedBooks() {
        return loanedBooks;
    }

    public void loanBook() {
        Book removedBook = availableBooks.remove(0);
        LoanedBook loanedBook = new LoanedBook(removedBook, null);
        loanedBooks.add(0, loanedBook);
    }

    public void resetLibrary(){
        availableBooks.clear();
        loanedBooks.clear();
        populateLibrary();
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void setLoanedBooks(ArrayList<LoanedBook> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public ArrayList<LibraryUser> getLibraryUsersList() {
        return libraryUsersList;
    }

    public void setLibraryUsersList(ArrayList<LibraryUser> libraryUsersList) {
        this.libraryUsersList = libraryUsersList;
    }

    public ArrayList<AdminUser> getAdminUsersList() {
        return adminUsersList;
    }

    public void setAdminUsersList(ArrayList<AdminUser> adminUsersList) {
        this.adminUsersList = adminUsersList;
    }


}
