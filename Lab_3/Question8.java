import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of print jobs: ");
        int jobs = sc.nextInt();

        Thread[] threads = new Thread[jobs];

        for (int i = 0; i < jobs; i++) {
            String student = "Student " + (char)('A' + i);
            PrinterJob job = new PrinterJob(i + 1, student);

            threads[i] = new Thread(job);
            threads[i].start();
        }

        for (int i = 0; i < jobs; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted");
            }
        }

        sc.close();
    }
}

class PrinterJob implements Runnable {
    int jobNumber;
    String student;

    PrinterJob(int jobNumber, String student) {
        this.jobNumber = jobNumber;
        this.student = student;
    }

    public void run() {
        System.out.println("Printing job " + jobNumber + " by " + student);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Printing interrupted");
        }
    }
}