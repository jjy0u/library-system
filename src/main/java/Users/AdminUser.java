package Users;

public class AdminUser extends User{
    private int adminID;

    public AdminUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
}
