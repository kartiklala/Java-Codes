import java.util.Scanner;


// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Course Details
        // ----------------------------------------------------

        String courseData = sc.nextLine();

        // Splitting input using comma
        String[] courseValues = courseData.split(",");

        // Store course details
        String courseName = courseValues[0];
        String duration = courseValues[1];

        // Create Course object
        Course course = new Course(courseName, duration);


        // ----------------------------------------------------
        // Input Normal Student
        // ----------------------------------------------------

        String studentData = sc.nextLine();

        // Splitting input using comma
        String[] studentValues = studentData.split(",");

        // Store student details
        String studentName = studentValues[0];
        String studentCourse = studentValues[1];
        int studentDiscount = Integer.parseInt(studentValues[2]);

        // Create Student object
        Student student = new Student(
            studentName,
            course,
            studentDiscount
        );


        // ----------------------------------------------------
        // Input Premium Student
        // ----------------------------------------------------

        String premiumData = sc.nextLine();

        // Splitting input using comma
        String[] premiumValues = premiumData.split(",");

        // Store premium student details
        String premiumName = premiumValues[0];
        String premiumCourse = premiumValues[1];
        int premiumDiscount = Integer.parseInt(premiumValues[2]);

        // Create PremiumStudent object
        PremiumStudent premiumStudent = new PremiumStudent(
            premiumName,
            course,
            premiumDiscount
        );


        // ----------------------------------------------------
        // Display Results
        // ----------------------------------------------------

        student.display();
        premiumStudent.display();

        sc.close();
    }
}


// Course class
class Course
{
    String courseName;
    String duration;

    // no argument constructor
    Course()
    {
        System.out.println("Course constructor called");
    }

    // parameterized constructor
    Course(String courseName, String duration)
    {
        this.courseName = courseName;
        this.duration = duration;
    }

    // display method
    void display()
    {
        System.out.println("Course: " + courseName +
                           " (" + duration + ")");
    }
}


// Student class
class Student
{
    String name;
    Course enrolledCourse;
    int discount;

    // no argument constructor
    Student()
    {
        System.out.println("Student constructor called");
    }

    // parameterized constructor
    Student(String name, Course enrolledCourse, int discount)
    {
        this.name = name;
        this.enrolledCourse = enrolledCourse;
        this.discount = discount;
    }

    // display method
    void display()
    {
        System.out.println("Student: " + name +
                           " Course: " +
                           enrolledCourse.courseName +
                           " (" + enrolledCourse.duration + ")" +
                           " Discount: " + discount + "%");
    }
}


// PremiumStudent inherits Student
class PremiumStudent extends Student
{
    // parameterized constructor
    PremiumStudent(String name, Course enrolledCourse, int discount)
    {
        // calling Student constructor
        super(name, enrolledCourse, discount);
    }

    // display method
    void display()
    {
        System.out.println("Premium Student: " + name +
                           " Course: " +
                           enrolledCourse.courseName +
                           " (" + enrolledCourse.duration + ")" +
                           " Discount: " + discount + "%");
    }
}