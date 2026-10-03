import java.util.Scanner;

// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Home Loan
        // ----------------------------------------------------

        String homeData = sc.nextLine();

        // Splitting input using comma
        String[] homeValues = homeData.split(",");

        // Store Home Loan details
        double homePrincipal = Double.parseDouble(homeValues[1]);
        double homeTime = Double.parseDouble(homeValues[2]);

        // Create HomeLoan object
        HomeLoan home = new HomeLoan(
            homePrincipal,
            homeTime
        );


        // ----------------------------------------------------
        // Input Car Loan
        // ----------------------------------------------------

        String carData = sc.nextLine();

        // Splitting input using comma
        String[] carValues = carData.split(",");

        // Store Car Loan details
        double carPrincipal = Double.parseDouble(carValues[1]);
        double carTime = Double.parseDouble(carValues[2]);

        // Create CarLoan object
        CarLoan car = new CarLoan(
            carPrincipal,
            carTime
        );


        // ----------------------------------------------------
        // Display Results
        // ----------------------------------------------------

        home.display();
        car.display();

        sc.close();
    }
}

// Abstract Loan class
abstract class Loan
{
    double principal;
    double rate;
    double time;

    // no argument constructor
    Loan()
    {
        System.out.println("Loan constructor called");
    }

    // parameterized constructor
    Loan(double principal, double rate, double time)
    {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    // abstract method
    // Child classes will provide their own implementation
    abstract double calculateInterest();

    // display method
    void display()
    {
        System.out.println("Interest: " + calculateInterest());
    }
}


// HomeLoan inherits Loan
class HomeLoan extends Loan
{
    // parameterized constructor
    HomeLoan(double principal, double time)
    {
        // Home Loan interest rate = 8%
        super(principal, 8, time);
    }

    // overriding calculateInterest()
    @Override
    double calculateInterest()
    {
        // Simple Interest = (P * R * T) / 100
        return (principal * rate * time) / 100;
    }

    // display method
    void display()
    {
        System.out.println("Home Loan Interest: " + calculateInterest());
    }
}


// CarLoan inherits Loan
class CarLoan extends Loan
{
    // parameterized constructor
    CarLoan(double principal, double time)
    {
        // Car Loan interest rate = 10%
        super(principal, 10, time);
    }

    // overriding calculateInterest()
    @Override
    double calculateInterest()
    {
        // Simple Interest = (P * R * T) / 100
        return (principal * rate * time) / 100;
    }

    // display method
    void display()
    {
        System.out.println("Car Loan Interest: " + calculateInterest());
    }
}


