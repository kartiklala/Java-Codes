public class WhileLoop {
    public static void main(String[] args) {

        int num = 2;
        int sum = 0;

        while (num <= 50) {
            sum = sum + num;
            num = num + 2;
        }

        System.out.println("Sum of even numbers between 1 and 50: " + sum);
    }
}