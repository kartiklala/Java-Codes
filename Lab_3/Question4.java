import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        StudentMarks student = new StudentMarks();

        try {
            student.enterMarks(marks);
            System.out.println("Marks entered successfully");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using the system");
        }

        sc.close();
    }
}

class StudentMarks {
    void enterMarks(int marks) throws Exception {
        if (marks < 0 || marks > 100) {
            throw new Exception("Marks must be between 0 and 100");
        }
    }
}