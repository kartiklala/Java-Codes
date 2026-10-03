import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Student student = new Student();

        try {
            student.registerStudent(age);
            System.out.println("Registration Successful");
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}

class Student {
    void registerStudent(int age) throws InvalidAgeException {
        if (age < 17) {
            throw new InvalidAgeException("Age must be above 17 for registration");
        }
    }
}

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}