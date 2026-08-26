import java.util.Scanner;


// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // ----------------------------------------------------
        // Input Student Details
        // ----------------------------------------------------

        String studentData = sc.nextLine();

        // Splitting input using comma
        String[] studentValues = studentData.split(",");

        // Store student details
        String name = studentValues[0];
        int roll = Integer.parseInt(studentValues[1]);
        String course = studentValues[2];


        // ----------------------------------------------------
        // Input Room Details
        // ----------------------------------------------------

        String roomData = sc.nextLine();

        // Splitting input using comma
        String[] roomValues = roomData.split(",");

        // Store room details
        String roomNumber = roomValues[0];
        String block = roomValues[1];
        String type = roomValues[2];

        // Create Room object
        Room room = new Room(
            roomNumber,
            block,
            type
        );


        // ----------------------------------------------------
        // Create Student Object
        // ----------------------------------------------------

        // Pass Room object to Student
        Student student = new Student(
            name,
            roll,
            course,
            room
        );


        // ----------------------------------------------------
        // Display Student Details
        // ----------------------------------------------------

        student.display();

        sc.close();
    }
}

// Room class
class Room
{
    String roomNumber;
    String block;
    String type;

    // no argument constructor
    Room()
    {
        System.out.println("Room constructor called");
    }

    // parameterized constructor
    Room(String roomNumber, String block, String type)
    {
        this.roomNumber = roomNumber;
        this.block = block;
        this.type = type;
    }

    // getters
    String getRoomNumber()
    {
        return roomNumber;
    }

    String getBlock()
    {
        return block;
    }

    String getType()
    {
        return type;
    }

    // setters
    void setRoomNumber(String roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    void setBlock(String block)
    {
        this.block = block;
    }

    void setType(String type)
    {
        this.type = type;
    }

    // display method
    void display()
    {
        System.out.println("Room: " + roomNumber +
                           " " + block +
                           " " + type);
    }
}


// Student class
class Student
{
    String name;
    int roll;
    String course;
    Room room;

    // no argument constructor
    Student()
    {
        System.out.println("Student constructor called");
    }

    // parameterized constructor
    Student(String name, int roll, String course, Room room)
    {
        this.name = name;
        this.roll = roll;
        this.course = course;
        this.room = room;
    }

    // getters
    String getName()
    {
        return name;
    }

    int getRoll()
    {
        return roll;
    }

    String getCourse()
    {
        return course;
    }

    Room getRoom()
    {
        return room;
    }

    // setters
    void setName(String name)
    {
        this.name = name;
    }

    void setRoll(int roll)
    {
        this.roll = roll;
    }

    void setCourse(String course)
    {
        this.course = course;
    }

    void setRoom(Room room)
    {
        this.room = room;
    }

    // display method
    // Prints student details and room details
    void display()
    {
        System.out.println("Student: " + name +
                           " (" + roll + ") " +
                           course);

        System.out.println("Room: " +
                           room.roomNumber + " " +
                           room.block + " " +
                           room.type);
    }
}


