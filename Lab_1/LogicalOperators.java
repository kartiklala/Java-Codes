// EXPERIMENT 4
import java.util.Scanner;

public class LogicalOperators {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept age and citizenship status
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Are you a citizen? (true/false): ");
        boolean citizen = sc.nextBoolean();

        // Check voting eligibility
        if (age >= 18 && citizen) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        sc.close();
    }
}