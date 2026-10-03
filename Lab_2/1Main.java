//EXPERIMENT 1

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//============================================================
// Main Class
// Program execution starts from the main() method
//============================================================
public class Main {

    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Department Details
        // ----------------------------------------------------

        System.out.println("Enter Department details (deptName,hodName)");

        // Read department details and split them using comma
        String[] deptDetails = sc.nextLine().split(",");

        // Store department name and HOD name
        String deptName = deptDetails[0];
        String hodName = deptDetails[1];

        // Create Department object using parameterized constructor
        Department department = new Department(deptName, hodName);


        // ----------------------------------------------------
        // Input Number of Professors
        // ----------------------------------------------------

        System.out.println("Enter number of professors");

        // Read number of professors
        int n = Integer.parseInt(sc.nextLine());


        // ----------------------------------------------------
        // Input Professor Details
        // ----------------------------------------------------

        System.out.println(
            "Enter professor details (name,employeeId,specialization)"
        );

        // Loop runs according to the number of professors
        for (int i = 0; i < n; i++) {

            // Read professor details and split using comma
            String[] professorDetails = sc.nextLine().split(",");

            // Store individual professor details
            String name = professorDetails[0];
            String employeeId = professorDetails[1];
            String specialization = professorDetails[2];

            // Create Professor object using parameterized constructor
            Professor professor = new Professor(
                name,
                employeeId,
                specialization
            );

            // Add Professor object to the Department
            department.addProfessor(professor);
        }


        // ----------------------------------------------------
        // Display Department Details
        // ----------------------------------------------------

        // Print the Department object
        // Java automatically calls the overridden toString() method
        System.out.println(department);

        // Close Scanner object
        sc.close();
    }
}


// ============================================================
// Professor Class
// Represents a Professor in the university
// ============================================================
class Professor {

    // Private attributes of Professor
    private String name;
    private String employeeId;
    private String specialization;

    // Default Constructor
    public Professor() {
        // Default constructor initialized
    }

    // Parameterized Constructor
    // Initializes professor details
    public Professor(String name, String employeeId, String specialization) {
        this.name = name;
        this.employeeId = employeeId;
        this.specialization = specialization;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for employeeId
    public String getEmployeeId() {
        return employeeId;
    }

    // Setter method for employeeId
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    // Getter method for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter method for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Override toString() method
    // Returns all professor details in one line
    @Override
    public String toString() {
        return "Name: " + name +
               ", ID: " + employeeId +
               ", Specialization: " + specialization;
    }
}


// ============================================================
// Department Class
// Represents a Department which can have multiple Professors
// Demonstrates One-to-Many relationship
// ============================================================
class Department {

    // Private attributes of Department
    private String deptName;
    private String hodName;

    // List to store multiple Professor objects
    private List<Professor> professors; //List means a vector is being created and the objects of professor classe are being stored in it

    // Default Constructor
    public Department() {

        // Initialize the professor list
        professors = new ArrayList<>();
    }

    // Parameterized Constructor
    // Initializes department name and HOD name
    public Department(String deptName, String hodName) {

        this.deptName = deptName;
        this.hodName = hodName;

        // Initialize the professor list
        this.professors = new ArrayList<>();
    }

    // Getter method for department name
    public String getDeptName() {
        return deptName;
    }

    // Setter method for department name
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    // Getter method for HOD name
    public String getHodName() {
        return hodName;
    }

    // Setter method for HOD name   
    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    // Getter method for professor list
    public List<Professor> getProfessors() {
        return professors;
    }

    // Setter method for professor list
    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    // Method to add a Professor object to the department
    public void addProfessor(Professor p) {
        professors.add(p);
    }

    // Override toString() method
    // Returns department, HOD and professor details
    @Override
    public String toString() {

        // StringBuilder is used to construct the output
        StringBuilder result = new StringBuilder();

        // Add department details
        result.append("Department: ").append(deptName).append("\n");

        // Add HOD details
        result.append("HOD: ").append(hodName).append("\n");

        // Add professor heading
        result.append("Professors:\n");

        // Loop through all Professor objects
        for (Professor p : professors) {    

            // Add each professor's details on a new line
            result.append(p).append("\n");
        }

        return result.toString();
    }
}