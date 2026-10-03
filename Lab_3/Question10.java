import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Transaction1: ₹");
        int amount1 = sc.nextInt();

        System.out.print("Transaction2: ₹");
        int amount2 = sc.nextInt();

        BankTransaction transaction1 =
                new BankTransaction(amount1, "Low-value transaction");

        BankTransaction transaction2 =
                new BankTransaction(amount2, "High-value transaction");

        transaction1.setPriority(Thread.MIN_PRIORITY);
        transaction2.setPriority(Thread.MAX_PRIORITY);

        transaction2.start();

        try {
            transaction2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        transaction1.start();

        try {
            transaction1.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        sc.close();
    }
}

class BankTransaction extends Thread {
    int amount;
    String type;

    BankTransaction(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public void run() {
        System.out.println(type + " processed:  " + amount);
    }
}