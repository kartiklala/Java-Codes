public class PortabilityDemo {
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("     JAVA PORTABILITY DEMO");
        System.out.println("=================================");

        System.out.println("Hello from Java!");
        // System.out.println("This program was compiled on Windows.");
        // System.out.println("The .class file can run on macOS using the JVM.");

        System.out.println();
        // Demonstrating a loop
        System.out.println("Running a loop:");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i + ": Java is portable!");
        }

        System.out.println();
        System.out.println("Operating System: " + System.getProperty("os.name"));

        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println();

        System.out.println("Same bytecode + Different OS = Java Portability!");
    }
}