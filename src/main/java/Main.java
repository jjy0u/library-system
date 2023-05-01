import Commands.LibraryCommands;
import Commands.LibraryWelcome;
import Library.Library;

import java.io.IOException;

public class Main {
    static Library library = new Library();

    public static void main(String[] args) throws IOException {
        //LibraryWelcome.libraryWelcome();

        //library.populateBook();


        LibraryCommands.menu();

    }
}