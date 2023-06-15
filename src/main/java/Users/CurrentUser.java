package Users;

import Books.LoanedBook;
import Library.Library;

public class CurrentUser extends User{
    private LibraryUser libraryUser;
    private AdminUser adminUser;

    private static Library library = new Library();

    public CurrentUser(String firstName, String lastName, String email, String password, LibraryUser libraryUser) {
        super(firstName, lastName, email, password);
        this.libraryUser = libraryUser;
    }

    public CurrentUser(String firstName, String lastName, String email, String password, AdminUser adminUser) {
        super(firstName, lastName, email, password);
        this.adminUser = adminUser;
    }

    public void addLoanedBooks() {
        this.libraryUser.addLoanedBooks();
    }

    public void removeLoanedBooks(int bookNumber) {
        this.libraryUser.removeLoanedBooks(bookNumber);
    }

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    @Override
    public String toString() {
        return "the current user is " + libraryUser;
    }
}
