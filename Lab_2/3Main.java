import java.util.Scanner;


// ============================================================
// Main Class
// Program execution starts from the main() method
// ============================================================
public class Main {

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);


        // ----------------------------------------------------
        // Input Employee Details
        // ----------------------------------------------------

        // Read employee details
        String[] employeeData = sc.nextLine().split(",");

        // Store employee details
        String employeeType = employeeData[0];
        String employeeName = employeeData[1];
        String employeeId = employeeData[2];
        double employeeSalary = Double.parseDouble(employeeData[3]);

        // Create Employee object
        Employee employee;

        if (employeeType.equalsIgnoreCase("Employee")) {

            // Create Employee object using parameterized constructor
            employee = new Employee(
                employeeName,
                employeeId,
                employeeSalary
            );

        } else {

            // Create Manager object if type is Manager
            double bonus = Double.parseDouble(employeeData[4]);

            employee = new Manager(
                employeeName,
                employeeId,
                employeeSalary,
                bonus
            );
        }


        // ----------------------------------------------------
        // Input Manager Details
        // ----------------------------------------------------

        // Read manager details
        String[] managerData = sc.nextLine().split(",");

        // Store manager details
        String managerType = managerData[0];
        String managerName = managerData[1];
        String managerId = managerData[2];
        double managerSalary = Double.parseDouble(managerData[3]);
        double managerBonus = Double.parseDouble(managerData[4]);

        // Create Manager object
        Manager manager = new Manager(
            managerName,
            managerId,
            managerSalary,
            managerBonus
        );


        // ----------------------------------------------------
        // Display Employee Details
        // ----------------------------------------------------

        // Print Employee details
        System.out.println(employee);

        // Print Manager details
        System.out.println(manager);


        // Close Scanner object
        sc.close();
    }
}

// ============================================================
// Employee Class
// Represents a basic employee in the company
// ============================================================
class Employee {

    // Private attributes of Employee
    private String name;
    private String id;
    private double basicSalary;

    // Default Constructor
    public Employee() {
        // Default constructor initialized
    }

    // Parameterized Constructor
    // Initializes employee details
    public Employee(String name, String id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for id
    public String getId() {
        return id;
    }

    // Setter method for id
    public void setId(String id) {
        this.id = id;
    }

    // Getter method for basic salary
    public double getBasicSalary() {
        return basicSalary;
    }

    // Setter method for basic salary
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    // Method to calculate salary
    // For a normal employee, salary is equal to basic salary
    public double calculateSalary() {
        return basicSalary;
    }

    // Override toString() method
    // Returns employee details and calculated salary
    @Override
    public String toString() {
        return "Employee " + name +
               " (" + id + ") Salary: " +
               calculateSalary();
    }
}


// ============================================================
// Manager Class
// Inherits properties and methods from Employee
// Manager receives an additional bonus
// ============================================================
class Manager extends Employee {

    // Extra attribute specific to Manager
    private double bonus;

    // Parameterized Constructor
    // Calls the Employee constructor using super()
    // and initializes the manager's bonus
    public Manager(String name, String id, double basicSalary, double bonus) {

        // Constructor chaining
        // Calls the parent Employee constructor
        super(name, id, basicSalary);

        // Initialize Manager-specific attribute
        this.bonus = bonus;
    }

    // Getter method for bonus
    public double getBonus() {
        return bonus;
    }

    // Setter method for bonus
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // Override calculateSalary() method
    // Manager salary = basic salary + bonus
    @Override
    public double calculateSalary() {
        return getBasicSalary() + bonus;
    }

    // Override toString() method
    // Returns manager details and calculated salary
    @Override
    public String toString() {
        return "Manager " + getName() +
               " (" + getId() + ") Salary: " +
               calculateSalary();
    }
}


