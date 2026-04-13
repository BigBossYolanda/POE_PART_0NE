import java.util.Scanner;

public class Registration {

    Scanner scanner = new Scanner(System.in);

    String username;
    String password;
    String phoneNumber;
    String firstName;
    String lastName;
//Checks conditions for username must be less or equal to 5 chars and also contain an underscore
    public boolean checkuserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

//Checks conditions for password and must be 8 or more chars and must contain uppercase, digit and
// special characters

    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasSpecial = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUppercase = true;
            if (Character.isLetterOrDigit(ch)) hasSpecial = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        return hasUppercase && hasSpecial && hasDigit;
    }

//Checks conditions for phone number, it must start with +27 or 0 and must have 9 following digits
    public boolean checkphoneNumber(String phoneNumber) {
        return phoneNumber.matches("(\\+27|0)[0-9]{9}");
    }
    public void Register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first name");
        firstName = scanner.nextLine();
        System.out.println("Please enter last name");
        lastName = scanner.nextLine();

//username
        do {
            System.out.println("Please enter a username, must contain '_' and should not be more than 5");
            username = scanner.nextLine();

            if (!checkuserName(username)){
                System.out.println("Invalid username, please try again");
            }
        }while (!checkuserName(username));

//phone number
        do {
            System.out.println("Please enter phone number(must contain South African county code and 10 digits)");
            phoneNumber = scanner.nextLine();

            if (!checkphoneNumber(phoneNumber)){
                System.out.println("Invalid phone number, please try again");
            }
        }while (!checkphoneNumber(phoneNumber));

//password
        while (true){
            System.out.println("Please enter a password");
            password = scanner.nextLine();

            if (checkPassword(password)){
                break;
            }
            else {
                System.out.println("Incorrect password");
                System.out.println("Password should contain a capital letter, special character or digits");
            }
        }

        System.out.println("Your registration was successful :)");

        Login login = new Login(username,password,"Yolanda","Maholwana");
        login.LoginUser(username, password);
    }
}




