// EXPERIMENT 2

import java.util.Scanner;


// ============================================================
// Main Class
// Program execution starts from main() method
// ============================================================
public class Main {

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Flight Details
        // ----------------------------------------------------

        System.out.println("Enter flight type,number,airline,fare");

        // Read first flight details
        String[] flight1 = sc.nextLine().split(",");

        // Store first flight details
        String type1 = flight1[0];
        String number1 = flight1[1];
        String airline1 = flight1[2];
        double fare1 = Double.parseDouble(flight1[3]);

        // Create Flight object based on flight type
        Flight f1;

        if (type1.equalsIgnoreCase("Domestic")) {

            // Create DomesticFlight object
            f1 = new DomesticFlight(number1, airline1, fare1);

        } else {

            // Create InternationalFlight object
            f1 = new InternationalFlight(number1, airline1, fare1);
        }


        // ----------------------------------------------------
        // Input Second Flight
        // ----------------------------------------------------

        // Read second flight details
        String[] flight2 = sc.nextLine().split(",");

        // Store second flight details
        String type2 = flight2[0];
        String number2 = flight2[1];
        String airline2 = flight2[2];
        double fare2 = Double.parseDouble(flight2[3]);

        // Create Flight object based on flight type
        Flight f2;

        if (type2.equalsIgnoreCase("Domestic")) {

            // Create DomesticFlight object
            f2 = new DomesticFlight(number2, airline2, fare2);

        } else {

            // Create InternationalFlight object
            f2 = new InternationalFlight(number2, airline2, fare2);
        }


        // ----------------------------------------------------
        // Display Flight Details
        // ----------------------------------------------------

        // toString() is automatically called
        System.out.println(f1);
        System.out.println(f2);

        // Close Scanner
        sc.close();
    }
}


// ============================================================
// Abstract Flight Class
// Represents common properties and behavior of all flights
// ============================================================
abstract class Flight {

    // Private attributes of Flight
    private String flightNumber;
    private String airline;
    private double fare;

    // Parameterized Constructor
    // Initializes flight details
    public Flight(String flightNumber, String airline, double fare) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.fare = fare;
    }

    // Getter method for flight number
    public String getFlightNumber() {
        return flightNumber;
    }

    // Getter method for airline
    public String getAirline() {
        return airline;
    }

    // Getter method for base fare
    public double getFare() {
        return fare;
    }

    // Abstract method
    // Subclasses must provide their own fare calculation
    public abstract double calculateFare();

    // Override toString() method
    // Displays flight details with final calculated fare
    @Override
    public String toString() {
        return "Flight No: " + flightNumber +
               " Airline: " + airline +
               " Fare: " + calculateFare();
    }
}


// ============================================================
// DomesticFlight Class
// Inherits properties and methods from Flight
// Domestic flight has 10% tax
// ============================================================
class DomesticFlight extends Flight {

    // Constructor
    // Calls the parent class constructor using super()
    public DomesticFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }

    // Implement calculateFare() method
    // Domestic fare = base fare + 10% tax
    @Override
    public double calculateFare() {
        return getFare() + (getFare() * 0.10);
    }
}


// ============================================================
// InternationalFlight Class
// Inherits properties and methods from Flight
// International flight has 25% tax
// ============================================================
class InternationalFlight extends Flight {

    // Constructor
    // Calls the parent class constructor using super()
    public InternationalFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }

    // Implement calculateFare() method
    // International fare = base fare + 25% tax
    @Override
    public double calculateFare() {
        return getFare() + (getFare() * 0.25);
    }
}


