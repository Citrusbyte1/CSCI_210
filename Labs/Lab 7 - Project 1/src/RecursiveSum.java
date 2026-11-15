/**
 * <h2>RecursiveSum.java - Adds up the numbers in an array by recursion.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Finds the sum of the numbers in four test arrays with a recursive
 *   method. The last test array holds the first seven factorials, which
 *   are also calculated recursively.</p>
 * @author Brian Nguyen
 * @version Lab 7, Project 1
 */

public class RecursiveSum {

    public static void main(String[] args) {

        // test cases
        int[] emptyArray = {};
        int[] oneNumber = {18};
        int[] fiveNumbers = {1, 2, 3, 4, 5};
        int[] factorials = new int[7];                  // the first 7 factorials
        for (int i = 0; i < factorials.length; i++) {
            factorials[i] = factorial(i + 1);
        }

        // Show each array and its sum
        showSum(emptyArray);
        showSum(oneNumber);
        showSum(fiveNumbers);
        showSum(factorials);
    }

    // Displays the numbers in an array and the sum returned from recursion
    private static void showSum(int[] numbers) {
        IO.println("Numbers: " + format(numbers));
        IO.println("Sum:     " + sum(numbers));
        IO.println();
    }

    // Uses recursion to return the sum of all of the numbers in an array
    public static int sum(int[] numbers) {

        return sum(numbers, 0);
    }

    // Returns the sum of the numbers from position "start" to the end
    private static int sum(int[] numbers, int start) {

        // Base case is there are no numbers left to add
        if (start >= numbers.length) {
            return 0;
        }

        // Recursive case is this number plus the sum of all of the numbers after it
        return numbers[start] + sum(numbers, start + 1);
    }

    // Returns n factorial
    public static int factorial(int n) {

        // Base case is 0! and 1! are both 1
        if (n <= 1) {
            return 1;
        }

        // Recursive case is n! = n * (n-1)!
        return n * factorial(n - 1);
    }

    // Builds text for display
    private static String format(int[] numbers) {

        if (numbers.length == 0) {
            return "{ }";
        }

        StringBuilder text = new StringBuilder("{ ");
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) {
                text.append(", ");
            }
            text.append(numbers[i]);
        }
        return text.append(" }").toString();
    }
}