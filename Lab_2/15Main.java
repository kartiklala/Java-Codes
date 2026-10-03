import java.util.Scanner;


// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        // ----------------------------------------------------
        // Input Citizen Details
        // ----------------------------------------------------

        System.out.println("Enter Citizen details:");

        String citizenData = sc.nextLine();

        // Splitting input using comma
        String[] citizenValues = citizenData.split(",");

        // Store citizen details
        String name = citizenValues[0];
        String dob = citizenValues[1];
        String address = citizenValues[2];


        // ----------------------------------------------------
        // Input Passport Details
        // ----------------------------------------------------

        System.out.println("Enter Passport details:");

        String passportData = sc.nextLine();

        // Splitting input using comma
        String[] passportValues = passportData.split(",");

        // Store passport details
        String passportNo = passportValues[0];
        String issueDate = passportValues[1];
        String expiryDate = passportValues[2];


        // ----------------------------------------------------
        // Create Passport Object
        // ----------------------------------------------------

        Passport passport = new Passport(
            passportNo,
            issueDate,
            expiryDate
        );


        // ----------------------------------------------------
        // Create Citizen Object
        // ----------------------------------------------------

        // Pass Passport object to Citizen
        Citizen citizen = new Citizen(
            name,
            dob,
            address,
            passport
        );


        // ----------------------------------------------------
        // Display Details
        // ----------------------------------------------------

        citizen.display();


        // Close Scanner
        sc.close();
    }
}


// Passport class
class Passport
{
    String passportNo;
    String issueDate;
    String expiryDate;

    // no argument constructor
    Passport()
    {
        System.out.println("Passport constructor called");
    }

    // parameterized constructor
    Passport(String passportNo, String issueDate, String expiryDate)
    {
        this.passportNo = passportNo;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    // getters
    String getPassportNo()
    {
        return passportNo;
    }

    String getIssueDate()
    {
        return issueDate;
    }

    String getExpiryDate()
    {
        return expiryDate;
    }

    // setters
    void setPassportNo(String passportNo)
    {
        this.passportNo = passportNo;
    }

    void setIssueDate(String issueDate)
    {
        this.issueDate = issueDate;
    }

    void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    // display method
    void display()
    {
        System.out.println("Passport: " + passportNo +
                           " Issue: " + issueDate +
                           " Expiry: " + expiryDate);
    }
}


// Citizen class
class Citizen
{
    String name;
    String dob;
    String address;

    // Passport object
    Passport passport;

    // no argument constructor
    Citizen()
    {
        System.out.println("Citizen constructor called");
    }

    // parameterized constructor
    Citizen(String name, String dob, String address, Passport passport)
    {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.passport = passport;
    }

    // getters
    String getName()
    {
        return name;
    }

    String getDob()
    {
        return dob;
    }

    String getAddress()
    {
        return address;
    }

    Passport getPassport()
    {
        return passport;
    }

    // setters
    void setName(String name)
    {
        this.name = name;
    }

    void setDob(String dob)
    {
        this.dob = dob;
    }

    void setAddress(String address)
    {
        this.address = address;
    }

    void setPassport(Passport passport)
    {
        this.passport = passport;
    }

    // display method
    // Prints citizen and passport details
    void display()
    {
        System.out.println("Citizen: " + name +
                           " DOB: " + dob +
                           " Address: " + address);

        System.out.println("Passport: " +
                           passport.getPassportNo() +
                           " Issue: " +
                           passport.getIssueDate() +
                           " Expiry: " +
                           passport.getExpiryDate());
    }
}

