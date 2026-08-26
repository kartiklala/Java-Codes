import java.util.Scanner;


// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        // ----------------------------------------------------
        // Create Account Object
        // ----------------------------------------------------

        // Create Account object
        Account account = new Account(
            "A101",
            "Ravi",
            0
        );


        // ----------------------------------------------------
        // Input Number of Operations
        // ----------------------------------------------------

        System.out.println("Enter number of operations:");

        int n = Integer.parseInt(sc.nextLine());


        // ----------------------------------------------------
        // Perform ATM Operations
        // ----------------------------------------------------

        for (int i = 0; i < n; i++)
        {
            System.out.println();
            System.out.println("Enter operation " + (i + 1) +
                               " (deposit / withdraw / getBalance):");

            // Read operation
            String operation = sc.nextLine();

            // Split operation using space
            String[] values = operation.split(" ");


            // ------------------------------------------------
            // Deposit
            // ------------------------------------------------

            if (values[0].equals("deposit"))
            {
                // Convert amount from String to double
                double amount = Double.parseDouble(values[1]);

                // Call deposit method
                account.deposit(amount);
            }


            // ------------------------------------------------
            // Withdraw
            // ------------------------------------------------

            else if (values[0].equals("withdraw"))
            {
                // Convert amount from String to double
                double amount = Double.parseDouble(values[1]);

                // Call withdraw method
                account.withdraw(amount);
            }


            // ------------------------------------------------
            // Check Balance
            // ------------------------------------------------

            else if (values[0].equals("getBalance"))
            {
                // Call getBalance method
                System.out.println("Balance: " +
                                   account.getBalance());
            }
        }


        // Close Scanner
        sc.close();
    }
}

// Account class
class Account
{
    String accNo;
    String holderName;

    // private variable
    // This demonstrates Encapsulation
    private double balance;

    // no argument constructor
    Account()
    {
        System.out.println("Account constructor called");
    }

    // parameterized constructor
    Account(String accNo, String holderName, double balance)
    {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    // deposit method
    void deposit(double amount)
    {
        balance = balance + amount;

        System.out.println("Deposited: " + amount);
    }

    // withdraw method
    void withdraw(double amount)
    {
        balance = balance - amount;

        System.out.println("Withdrawn: " + amount);
    }

    // getter method for balance
    double getBalance()
    {
        return balance;
    }
}

