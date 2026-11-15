/**
 * <h2>SquareRoot.java - Finds square roots by a recursive binary search.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Finds the square roots of the numbers from 2 to 20 by repeatedly
 *   cutting a range of possible answers in half, then compares the results
 *   with Java's Math.sqrt method and counts how many recursive calls each
 *   one took.</p>
 * @author Brian Nguyen
 * @version Lab 7, Project 2
 */

public class SquareRoot {
// How close the square of an answer must be
    private static final double tolerance = 1e-14;

    // The number of times squareRoot has been called
    private static int callCount = 0;

    public static void main(String[] args) {

        // Print headings for the report
        IO.println(String.format("%6s %19s %19s %19s %19s %6s",
                "Target", "Computed-Root", "Computed-Root ^ 2", "Math's Root", "Math's Root ^ 2", "Levels"));
        IO.println(String.format("%6s %19s %19s %19s %19s %6s",
                "------", "-------------------", "-------------------", "-------------------", "-------------------", "------"));

        // Find the sqrt of each number from 2 to 20
        for (int number = 2; number <= 20; number++) {

            // Sqrt root to look for
            double target = number;

            // Start counting the calls over again
            callCount = 0;

            // The sqrt must be between 1 and the target
            double root = squareRoot(1, target, target);

            // What Java's sqrt returns
            double mathRoot = Math.sqrt(target);

            // Print the results within 14 digits after the decimal
            IO.println(String.format("%6d %19.14f %19.14f %19.14f %19.14f %6d",
                    number, root, root * root, mathRoot, mathRoot * mathRoot, callCount));
        }
    }

    /**
     * Finds the square root of target by a recursive binary search. The
     * answer is supposed to be between low and high, where low squared is
     * < target and high squared > target.
     * @param low lower end of the search range
     * @param high upper end of the search range
     * @param target number whose square root to look for
     * @return the square root of target
     */

    private static double squareRoot(double low, double high, double target) {

        callCount++;

        // The midpoint between low and high is my guess at the sqrt
        double midpoint = (low + high) / 2;
        double square = midpoint * midpoint;

        // Base case is when the guess squared is close enough to the target
        if (Math.abs(square - target) < tolerance) {
            return midpoint;
        }

        // Recursive case is when the guess was too small, so the answer must be in the
        // upper half of the range. Otherwise it must be in the lower half.
        if (square < target) {
            return squareRoot(midpoint, high, target);
        } else {
            return squareRoot(low, midpoint, target);
        }
    }
}
