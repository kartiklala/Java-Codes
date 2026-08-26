import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Reservation Details
        // ----------------------------------------------------

        String reservationData = sc.nextLine();

        // Splitting input using comma
        String[] reservationValues = reservationData.split(",");

        // Store reservation details
        String reservationId = reservationValues[0];
        String roomType = reservationValues[1];
        int numberOfGuests = Integer.parseInt(reservationValues[2]);

        // Create Reservation object
        Reservation reservation = new Reservation(
            reservationId,
            roomType
        );


        // ----------------------------------------------------
        // Input Guest Details
        // ----------------------------------------------------

        // Loop runs according to the number of guests
        for (int i = 0; i < numberOfGuests; i++)
        {
            // Read guest details
            String guestData = sc.nextLine();

            // Splitting input using comma
            String[] guestValues = guestData.split(",");

            // Store guest details
            String name = guestValues[0];
            int age = Integer.parseInt(guestValues[1]);
            String idProof = guestValues[2];

            // Create Guest object
            Guest guest = new Guest(
                name,
                age,
                idProof
            );

            // Add Guest object to Reservation
            reservation.addGuest(guest);
        }


        // ----------------------------------------------------
        // Display Reservation Details
        // ----------------------------------------------------

        reservation.display();

        sc.close();
    }
}


// Guest class
class Guest
{
    String name;
    int age;
    String idProof;

    // no argument constructor
    Guest()
    {
        System.out.println("Guest constructor called");
    }

    // parameterized constructor
    Guest(String name, int age, String idProof)
    {
        this.name = name;
        this.age = age;
        this.idProof = idProof;
    }

    // getters
    String getName()
    {
        return name;
    }

    int getAge()
    {
        return age;
    }

    String getIdProof()
    {
        return idProof;
    }

    // setters
    void setName(String name)
    {
        this.name = name;
    }

    void setAge(int age)
    {
        this.age = age;
    }

    void setIdProof(String idProof)
    {
        this.idProof = idProof;
    }

    // display method
    void display()
    {
        System.out.println(name + "," +
                           age + "," +
                           idProof);
    }
}


// Reservation class
class Reservation
{
    String reservationId;
    String roomType;

    // List to store multiple Guest objects
    List<Guest> guests;

    // no argument constructor
    Reservation()
    {
        // Initialize Guest list
        guests = new ArrayList<>();
    }

    // parameterized constructor
    Reservation(String reservationId, String roomType)
    {
        this.reservationId = reservationId;
        this.roomType = roomType;

        // Initialize Guest list
        this.guests = new ArrayList<>();
    }

    // getters
    String getReservationId()
    {
        return reservationId;
    }

    String getRoomType()
    {
        return roomType;
    }

    List<Guest> getGuests()
    {
        return guests;
    }

    // setters
    void setReservationId(String reservationId)
    {
        this.reservationId = reservationId;
    }

    void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }

    void setGuests(List<Guest> guests)
    {
        this.guests = guests;
    }

    // Method to add a Guest to the reservation
    void addGuest(Guest guest)
    {
        guests.add(guest);
    }

    // display method
    void display()
    {
        System.out.println("Reservation ID: " +
                           reservationId +
                           " Room: " +
                           roomType);

        System.out.println("Guests:");

        // Loop through all Guest objects
        for (Guest guest : guests)
        {
            guest.display();
        }
    }
}