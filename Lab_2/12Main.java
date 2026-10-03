import java.util.Scanner;


// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Car Details
        // ----------------------------------------------------

        String carData = sc.nextLine();

        // Splitting input using comma
        String[] carValues = carData.split(",");

        // Store Car details
        String carRegNo = carValues[1];
        String carBrand = carValues[2];
        double carBaseRate = Double.parseDouble(carValues[3]);

        // Create Car object
        Car car = new Car(
            carRegNo,
            carBrand,
            carBaseRate
        );


        // ----------------------------------------------------
        // Input Bike Details
        // ----------------------------------------------------

        String bikeData = sc.nextLine();

        // Splitting input using comma
        String[] bikeValues = bikeData.split(",");

        // Store Bike details
        String bikeRegNo = bikeValues[1];
        String bikeBrand = bikeValues[2];
        double bikeBaseRate = Double.parseDouble(bikeValues[3]);

        // Create Bike object
        Bike bike = new Bike(
            bikeRegNo,
            bikeBrand,
            bikeBaseRate
        );


        // ----------------------------------------------------
        // Display Results
        // ----------------------------------------------------

        car.display();
        bike.display();

        sc.close();
    }
}


// Vehicle class
class Vehicle
{
    String regNo;
    String brand;
    double baseRate;

    // no argument constructor
    Vehicle()
    {
        System.out.println("Vehicle constructor called");
    }

    // parameterized constructor
    Vehicle(String regNo, String brand, double baseRate)
    {
        this.regNo = regNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    // method to calculate rental cost
    // This method is overridden by child classes
    double calculateRent()
    {
        return baseRate;
    }

    // display method
    void display()
    {
        System.out.println("Vehicle " + regNo +
                           " " + brand +
                           " Rent: " +
                           calculateRent());
    }
}


// Car class inherits Vehicle
class Car extends Vehicle
{
    // parameterized constructor
    Car(String regNo, String brand, double baseRate)
    {
        // calling Vehicle constructor
        super(regNo, brand, baseRate);
    }

    // overriding calculateRent()
    // Car rental rate = baseRate * 1.5
    @Override
    double calculateRent()
    {
        return baseRate * 1.5;
    }

    // overriding display method
    void display()
    {
        System.out.println("Car " + regNo +
                           " " + brand +
                           " Rent: " +
                           calculateRent());
    }
}


// Bike class inherits Vehicle
class Bike extends Vehicle
{
    // parameterized constructor
    Bike(String regNo, String brand, double baseRate)
    {
        // calling Vehicle constructor
        super(regNo, brand, baseRate);
    }

    // overriding calculateRent()
    // Bike rental rate = baseRate * 1.2
    @Override
    double calculateRent()
    {
        return baseRate * 1.2;
    }

    // overriding display method
    void display()
    {
        System.out.println("Bike " + regNo +
                           " " + brand +
                           " Rent: " +
                           calculateRent());
    }
}