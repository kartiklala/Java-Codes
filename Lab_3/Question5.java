import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        UniversityLogin login = new UniversityLogin();

        try {
            login.login(username);
            System.out.println("Login Successful");
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}

class UniversityLogin {
    void login(String username) {
        if (username == null || username.equals("null")) {
            throw new NullPointerException("Username cannot be null");
        }

        System.out.println("Welcome " + username);
    }
}