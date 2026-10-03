import java.util.Scanner;


// Main class
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Taking input
        String data = sc.nextLine();

        // Splitting input using comma
        String[] values = data.split(",");

        // Storing book details
        String title = values[0];
        double price = Double.parseDouble(values[1]);

        // Storing author details
        String authorName = values[2];
        String email = values[3];
        String gender = values[4];

        // Creating Author object
        Author a1 = new Author(
            authorName,
            email,
            gender
        );

        // Creating Book object
        // Author object is passed to Book
        Book b1 = new Book(
            title,
            price,
            a1
        );

        // Displaying book details
        b1.display();

        sc.close();
    }
}

// Author class
class Author
{
    String name;
    String email;
    String gender;

    // no argument constructor
    Author()
    {
        System.out.println("Author constructor called");
    }

    // parameterized constructor
    Author(String name, String email, String gender)
    {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // display method
    void display()
    {
        System.out.println("Author: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);
    }
}


// Book class
class Book
{
    String title;
    double price;
    Author author;

    // no argument constructor
    Book()
    {
        System.out.println("Book constructor called");
    }

    // parameterized constructor
    Book(String title, double price, Author author)
    {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    // display method
    void display()
    {
        System.out.println("Book: " + title);
        System.out.println("Price: " + price);
        System.out.println("Author: " + author.name +
                           " (" + author.gender + ")" +
                           ", Email: " + author.email);
    }
}


