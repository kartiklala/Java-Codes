import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Available Seats: ");
        int seats = sc.nextInt();

        System.out.print("User1 wants to book: ");
        int user1Seats = sc.nextInt();

        System.out.print("User2 wants to book: ");
        int user2Seats = sc.nextInt();

        TicketBooking booking = new TicketBooking(seats);

        User1 user1 = new User1(booking, user1Seats);
        User2 user2 = new User2(booking, user2Seats);

        user1.start();
        try {
            user1.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        user2.start();
        try {
            user2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        sc.close();
    }
}

class TicketBooking {
    int availableSeats;

    TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    synchronized void bookSeat(int seats, String user) {
        if (seats <= availableSeats) {
            availableSeats = availableSeats - seats;
            System.out.println(user + " booked " + seats + " seat(s) successfully");
        } else {
            System.out.println(user + " booking failed. Not enough seats");
        }
    }
}

class User1 extends Thread {
    TicketBooking booking;
    int seats;

    User1(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat(seats, "User1");
    }
}

class User2 extends Thread {
    TicketBooking booking;
    int seats;

    User2(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat(seats, "User2");
    }
}