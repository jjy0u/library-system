import Commands.LibraryWelcome;
import Library.Library;

import java.io.IOException;

public class Main {
    static Library library = new Library();

    public static void main(String[] args) throws IOException {
        //LibraryWelcome.libraryWelcome();

        library.addBook();

        for (int i = 0; i < library.getAvailableBooks().size(); i++) {
            System.out.println(library.getAvailableBooks().get(i));
        }

    }
}