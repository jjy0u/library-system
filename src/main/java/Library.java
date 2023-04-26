import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks = new ArrayList<>();
    private ArrayList<Book> removedBooks = new ArrayList<>();
    private String name;

    public Library(String name) {
        this.name = name;
    }

    {
        populateLibrary();
    }

    public void populateLibrary(){
    }

    public ArrayList<Book> getRemovedBooks() {
        return removedBooks;
    }

    public void removeBook() {
        removedBooks.add(0, availableBooks.remove(0));
    }

    public void resetLibrary(){
        availableBooks.clear();
        removedBooks.clear();
        populateLibrary();
    }

    }
