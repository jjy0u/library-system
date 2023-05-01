package Users;

public class CurrentUser extends User{
    private static LibraryUser libraryUser;
    private static AdminUser adminUser;


    public CurrentUser(String firstName, String lastName, String email, String password, LibraryUser libraryUser) {
        super(firstName, lastName, email, password);
        this.libraryUser = libraryUser;
    }

    public CurrentUser(String firstName, String lastName, String email, String password, AdminUser adminUser) {
        super(firstName, lastName, email, password);
        this.adminUser = adminUser;

    }

    public static LibraryUser getLibraryUser() {
        return libraryUser;
    }

    public static AdminUser getAdminUser() {
        return adminUser;
    }
}
