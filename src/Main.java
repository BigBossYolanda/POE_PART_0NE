import java.util.Scanner;

public static void main(String[] args) {
    Registration registration = new Registration();
    registration.Register();

    Scanner scanner = new Scanner(System.in);
    Login login = new Login(registration.username, registration.password,
            registration.firstName, registration.lastName);

    System.out.println("Please log in now. ");

    //for loop: maximum 3 attempts
    for  (int i = 0 ; i < 3; i++) {
        System.out.println("Please enter username. ");
        String loginUser = scanner.nextLine();
        System.out.println("Please enter password. ");
        String loginPass = scanner.nextLine();

        String message = login.LoginUser(loginUser, loginPass);
        System.out.println(message);

        if (message.startsWith("welcome")) {
            break;

        }

        //if it was a third attempt, lock the account
        if (i == 2) {
            System.out.println("Too many failed attempts, account locked: ");
        }

    }
}
