public class ArraysLoops {
    public static void main(String[] args) {

        int[] numbers = {12, 45, 7, 89, 23, 56, 34, 91, 18, 67};

        // Find maximum value
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("Maximum value: " + max);
    }
}