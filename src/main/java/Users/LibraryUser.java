package Users;
import Books.LoanedBook;
import Library.Library;

import java.util.ArrayList;


public class LibraryUser extends User{
    private int libraryID;
    private ArrayList<LoanedBook> booksLoaned = new ArrayList<>();

    private static Library library = new Library();

    public LibraryUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        libraryID++;
        addLoanedBooks();
    }

    public int getLibraryID() {
        return libraryID;
    }

    public void addLoanedBooks() {
        for (LoanedBook loanedBook : library.getLoanedBooks()) {
            if (loanedBook.getLoaner().libraryID == libraryID){
                booksLoaned.add(loanedBook);
            }
        }
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public ArrayList<LoanedBook> getBooksLoaned() {
        return booksLoaned;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }

}
