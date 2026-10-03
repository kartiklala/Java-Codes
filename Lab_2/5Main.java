import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Taking input
        String data = sc.nextLine();

        // Splitting input using comma
        String[] values = data.split(",");

        String name = values[0];
        int age = Integer.parseInt(values[1]);
        String specialization = values[2];
        String surgeryType = values[3];

        // Creating Surgeon object
        // Surgeon constructor is called automatically
        Surgeon s1 = new Surgeon(
            name,
            age,
            specialization,
            surgeryType
        );

        // Displaying details
        s1.display();

        sc.close();
    }
}

// Person class
class Person
{
    String name;
    int age;

    // no argument constructor
    Person()
    {
        System.out.println("Person constructor called");
    }

    // parameterized constructor
    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    // display method
    void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}


// Doctor inherits Person
class Doctor extends Person
{
    String specialization;

    // parameterized constructor
    Doctor(String name, int age, String specialization)
    {
        // calling Person constructor
        super(name, age);

        this.specialization = specialization;
    }

    // display method
    void display()
    {
        super.display();
        System.out.println("Specialization: " + specialization);
    }
}


// Surgeon inherits Doctor
class Surgeon extends Doctor
{
    String surgeryType;

    // parameterized constructor
    Surgeon(String name, int age, String specialization, String surgeryType)
    {
        // calling Doctor constructor
        super(name, age, specialization);

        this.surgeryType = surgeryType;
    }

    // display method
    void display()
    {
        super.display();
        System.out.println("Surgery Type: " + surgeryType);
    }
}

