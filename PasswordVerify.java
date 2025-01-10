/*Class PasswordVerify. The constructor of this class throws an exception if the
username or password violates any of the rules, and displays a message to the user
to let them know which password/username rule was broken.
 */
public class PasswordVerify {
    String username;
    String password;

    //Constructor. It throws a PasswordVerifyException
    public PasswordVerify(String username, String password) throws PasswordVerifyException{

        //if condition to check whether the username has at least 6 characters
        if (username.length() < 6) {
            throw new PasswordVerifyException(username, password, "Username must be at least 6 characters long. " +
                    "Press enter to try again. ");
        }

       //The following code checks whether the username has at least 2 vowels
        int vowelCount = 0; //variable to store the number of vowels

        //for loop that checks whether each character is a vowel and increments vowelCount accordingly
        for (int i = 0; i < username.length(); i++ ){
            if (username.charAt(i) =='a' || username.charAt(i) =='e' || username.charAt(i) =='i'
                    || username.charAt(i) =='o' ||username.charAt(i) =='u'){
                vowelCount++;
            }
        }
        //checks whether the username has at least 2 vowels
        if (vowelCount < 2){
            throw new PasswordVerifyException (username, password, "The username needs to have at least 2 vowels. " +
                    "Press Enter to try again. ");
        }

        //check if password has exactly 8 characters
        if (password.length() != 8){
            throw new PasswordVerifyException(username, password, "The password needs to have exactly 8 characters. " +
                    "Press Enter to try again. ");
        }

        //checks if the 4th character of the password is an '%'
        if(password.charAt(3)!= '%'){
            throw new PasswordVerifyException(username, password, "The 4th character of the password needs to be an '%." +
                    " Press Enter to try again. ");
        }

        this.username= username;
        this.password = password;
    }

    //ToString method to print class attributes
    @Override
    public String toString(){
        return "Username: " + username + ", Password: " + password;
    }

}
