package Commands;
import Users.AdminUser;
import Users.CurrentUser;
import Users.LibraryUser;
import Library.Library;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LibraryWelcome {
    static Library library = new Library();
    static ArrayList<LibraryUser> libraryUsersList = library.getLibraryUsersList();
    static ArrayList<AdminUser> adminUsersList = library.getAdminUsersList();

    public static void libraryWelcome() {
        System.out.println("Welcome to The Library, choose one of the following: \n 1: Log in \n 2: Sign Up");
        String logOn = validateInput("");
        if (Objects.equals(logOn, "1")) {
            logIn();
        } else {
            signUp();
        }
    }
    public static void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        LibraryUser newUser = new LibraryUser(firstName, lastName, email, password);
        library.getLibraryUsersList().add(newUser);
        System.out.println("You have successfully created an account! Would you like to log in? \n\n" +
                "1. Yes\n" +
                "2. No, I want to exit.");
        String userInput = validateInput("");
        if (Objects.equals(userInput, "1")){
            logIn();
        }
    }

    public static void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a user or an admin? \n 1: User \n 2: Admin");
        String userType = validateInput("");
        if (Objects.equals(userType, "1")) {
            String email;
            String password;
            do {
                System.out.println("Email:");
                email = scanner.nextLine();
                System.out.println("Password:");
                password = scanner.nextLine();
                if (!validateLibraryUser(email,password)) {
                    System.out.println("Either your email or password were entered incorrectly. Please try again!\n");
                }
            } while (!validateLibraryUser(email,password));
        } else {
            String adminId;
            String password;
            do {
                System.out.println("adminID:");
                adminId = scanner.nextLine();
                System.out.println("Password:");
                password = scanner.nextLine();
            } while (!validateAdminUser(adminId,password));
        }
    }

    public static String validateInput(String input) {
        Scanner scanner = new Scanner(System.in);
        do {
            input = scanner.nextLine();
            if (!Objects.equals(input, "2") && !Objects.equals(input, "1")) {
                System.out.println("Error! Please enter a valid input, either 1 or 2:");
            }
        } while (!Objects.equals(input, "2") && !Objects.equals(input, "1"));
        return input;
    }

    public static boolean validateLibraryUser(String email, String password) {
        for (LibraryUser user : libraryUsersList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                CurrentUser currentUser = new CurrentUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),user);
                new LibraryCommands(currentUser).menu();
                return true;
            }
        }
        return false;
    }

    public static boolean validateAdminUser(String adminID, String password) {
        for (AdminUser user : adminUsersList) {
            if (user.getEmail().equals(adminID) && user.getPassword().equals(password)) {
                CurrentUser currentUser = new CurrentUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user);
                return true;
            }
        }
        return false;
    }
}