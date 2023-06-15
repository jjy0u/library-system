package Library;

import Books.Book;
import Utils.CsvToJsonConverter;
import Books.LoanedBook;
import Users.AdminUser;
import Users.LibraryUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Library {
    private ArrayList<Book> allBooks = new ArrayList<>();

    private ArrayList<Book> availableBooks = new ArrayList<>();
    private ArrayList<LoanedBook> loanedBooks = new ArrayList<>();
    private ArrayList<LibraryUser> libraryUsersList = new ArrayList<>();
    private ArrayList<AdminUser> adminUsersList = new ArrayList<>();

    public Library() {
    }

    {
        try {
            populateBook();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Library(ArrayList<Book> availableBooks, ArrayList<LoanedBook> loanedBooks, ArrayList<LibraryUser> libraryUsersList, ArrayList<AdminUser> adminUsersList) {
        this.availableBooks = availableBooks;
        this.loanedBooks = loanedBooks;
        this.libraryUsersList = libraryUsersList;
        this.adminUsersList = adminUsersList;
    }

    public void populateBook() throws IOException {
        allBooks = CsvToJsonConverter.convertJsonToBookList("src/main/resources/books_data.json");
        availableBooks = CsvToJsonConverter.convertJsonToBookList("src/main/resources/books_data.json");
    }

    public void listAvailableBooks() {
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println(availableBooks.get(i));
        }
    }

//    public void populateLibraryUsersList() {
//            libraryUsersList.add(LibraryUser);
//    }

    public void loanBook(int bookNumber, LibraryUser loaner) {
        for (int i = 0; i < availableBooks.size(); i++) {
            if (availableBooks.get(i).getNumber() == bookNumber){
                Book removedBook = availableBooks.remove(i);
                LoanedBook loanedBook = new LoanedBook(removedBook, loaner);
                loanedBooks.add(0, loanedBook);
            }
        }
    }

    public void returnBook(int bookNumber, LibraryUser loaner) {
        for (int i = 0; i < loanedBooks.size(); i++) {
            if (loanedBooks.get(i).getBook().getNumber() == bookNumber){
                LoanedBook removedBook = loanedBooks.remove(i);
                availableBooks.add(0, allBooks.get(removedBook.getBook().getNumber()-1));
                availableBooks.sort(Comparator.comparing(Book::getNumber));

            }
        }
    }

    public void resetLibrary(){
        availableBooks.clear();
        loanedBooks.clear();
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public ArrayList<LoanedBook> getLoanedBooks() {
        return loanedBooks;
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
