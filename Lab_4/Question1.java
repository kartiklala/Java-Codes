import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String book = sc.nextLine();
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeBook = sc.nextLine();
                    library.removeBook(removeBook);
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}

class Library {
    ArrayList<String> books = new ArrayList<>();

    void addBook(String book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    void removeBook(String book) {
        if (books.remove(book)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    void displayBooks() {
        System.out.println("Current Books:");

        for (String book : books) {
            System.out.println(book);
        }
    }
}