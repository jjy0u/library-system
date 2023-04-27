package Users;
import Books.LoanedBook;

import java.util.ArrayList;


public class LibraryUser extends User{
    private int libraryID;
    private ArrayList<LoanedBook> BooksLoaned = new ArrayList<>();


    public LibraryUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public int getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public ArrayList<LoanedBook> getBooksLoaned() {
        return BooksLoaned;
    }

    public void setBooksLoaned(ArrayList<LoanedBook> booksLoaned) {
        BooksLoaned = booksLoaned;
    }
}
