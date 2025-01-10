/*Class PasswordVerifyException. It extends the Exception class and from it we can create
our own exceptions */
public class PasswordVerifyException extends Exception {
    String username;
    String password;

    //constructor
    public PasswordVerifyException(String username, String password, String message) {
        super(message);
        this.username = username;
        this.password = password;
    }
}
