import java.util.LinkedHashSet;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseEnrollment course = new CourseEnrollment();

        System.out.print("Enroll: ");
        String name1 = sc.nextLine();
        course.enrollStudent(name1);

        System.out.print("Enroll: ");
        String name2 = sc.nextLine();
        course.enrollStudent(name2);

        System.out.print("Enroll: ");
        String name3 = sc.nextLine();
        course.enrollStudent(name3);

        course.displayEnrolledStudents();

        sc.close();
    }
}

class CourseEnrollment {
    LinkedHashSet<String> students = new LinkedHashSet<>();

    void enrollStudent(String name) {
        if (students.add(name)) {
            System.out.println("Enrolled: " + name);
        } else {
            System.out.println(name + " is already enrolled");
        }
    }

    void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }
}