import java.util.Scanner;

// Main Class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Device 1
        // ----------------------------------------------------

        String device1 = sc.nextLine();

        // ----------------------------------------------------
        // Input Device 2
        // ----------------------------------------------------

        String device2 = sc.nextLine();


        // ----------------------------------------------------
        // Create Device Objects
        // ----------------------------------------------------

        Device d1;
        Device d2;

        // Check first device
        if (device1.equalsIgnoreCase("Fan"))
        {
            // Creating Fan object
            d1 = new Fan();
        }
        else
        {
            // Creating Light object
            d1 = new Light();
        }

        // Check second device
        if (device2.equalsIgnoreCase("Fan"))
        {
            // Creating Fan object
            d2 = new Fan();
        }
        else
        {
            // Creating Light object
            d2 = new Light();
        }


        // ----------------------------------------------------
        // Turn Devices ON and OFF
        // ----------------------------------------------------

        d1.turnOn();
        d1.turnOff();

        d2.turnOn();
        d2.turnOff();

        sc.close();
    }
}

// Device interface
interface Device
{
    // Methods declared in interface
    void turnOn();
    void turnOff();
}


// Fan class implements Device
class Fan implements Device
{
    // turnOn method
    @Override
    public void turnOn()
    {
        System.out.println("Fan is now ON");
    }

    // turnOff method
    @Override
    public void turnOff()
    {
        System.out.println("Fan is now OFF");
    }
}


// Light class implements Device
class Light implements Device
{
    // turnOn method
    @Override
    public void turnOn()
    {
        System.out.println("Light is now ON");
    }

    // turnOff method
    @Override
    public void turnOff()
    {
        System.out.println("Light is now OFF");
    }
}


