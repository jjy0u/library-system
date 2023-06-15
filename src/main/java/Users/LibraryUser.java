package Users;
import Books.LoanedBook;
import Commands.LibraryCommands;
import Library.Library;

import java.util.ArrayList;


public class LibraryUser extends User{
    private int libraryID;
    private ArrayList<LoanedBook> booksLoaned = new ArrayList<>();

    public LibraryUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        libraryID++;
        addLoanedBooks();
    }

    public int getLibraryID() {
        return libraryID;
    }

    public void addLoanedBooks() {
        for (LoanedBook loanedBook : LibraryCommands.library.getLoanedBooks()) {
            if (loanedBook.getLoaner().getLibraryID() == this.libraryID && !booksLoaned.contains(loanedBook) ){
                booksLoaned.add(loanedBook);
            }
        }
    }

    public void removeLoanedBooks(int bookNumber) {
        for (LoanedBook loanedBook : LibraryCommands.library.getLoanedBooks()) {
            if (loanedBook.getBook().getNumber() == bookNumber ){
                booksLoaned.remove(loanedBook);
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
