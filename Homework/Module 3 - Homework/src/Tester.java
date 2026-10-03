/**
 * <h2>Tester.java - Tests the BigNumber class.</h2>
 *
 * <p><b>Problem Statement:</b> Shows that a BigNumber can be built
 * one digit at a time (from either end, or with a decimal point inserted
 * in), that it rejects invalid input, and that its digits can be read
 * both as a formatted String and an iterator.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Build three BigNumbers, each with 10 or more digits. Two of them
 *       use addRight, addDecimal, and addLeft so that the decimal point
 *       ends up in the middle of the number, with digits on both sides.
 *       The third is a plain whole number built with addRight.</li>
 *   <li>Each BigNumber is displayed using toString(), then again by
 *       reading its digits one at a time with an iterator.</li>
 *   <li>Demonstrate that addRight, addLeft, and addDecimal all reject
 *       invalid input without changing the number.</li>
 * </ol>
 *
 * @author Brian Nguyen
 * @version Module 3, Homework 3, Project 1
 */
public class Tester {

    public static void main(String[] args) {

        // ===============================================================
        // Test 1: a decimal point in the middle of the number.
        //
        // Expected result: 12345.678901
        // ===============================================================
        BigNumber<Integer> number1 = new BigNumber<>();

        // Build the "678901" part first, left to right
        number1.addRight(6);
        number1.addRight(7);
        number1.addRight(8);
        number1.addRight(9);
        number1.addRight(0);
        number1.addRight(1);

        // Insert the decimal point
        number1.addDecimal();

        // Build the "12345" part , adding in reverse
        // order (5, 4, 3, 2, 1) so that they end up correct
        number1.addLeft(5);
        number1.addLeft(4);
        number1.addLeft(3);
        number1.addLeft(2);
        number1.addLeft(1);

        System.out.println("Test 1 - toString():  " + number1);
        System.out.print("Test 1 - iterator:    ");
        printDigitByDigit(number1);

        // ===============================================================
        // Test 2: another decimal point in the middle, using the same
        // method as Test 1.
        //
        // Expected result: 3.14159265358
        // ===============================================================
        BigNumber<Integer> number2 = new BigNumber<>();

        // Build the "14159265358" part
        number2.addRight(1);
        number2.addRight(4);
        number2.addRight(1);
        number2.addRight(5);
        number2.addRight(9);
        number2.addRight(2);
        number2.addRight(6);
        number2.addRight(5);
        number2.addRight(3);
        number2.addRight(5);
        number2.addRight(8);

        // Insert the decimal point
        number2.addDecimal();

        // Build the "3" part
        number2.addLeft(3);

        System.out.println("\nTest 2 - toString():  " + number2);
        System.out.print("Test 2 - iterator:    ");
        printDigitByDigit(number2);

        // ===============================================================
        // Test 3: a plain whole number, no decimal point. With no decimal
        // point to worry about, the digits can simply be appended left to
        // right using addRight.
        //
        // Expected result: 1234567890
        // ===============================================================
        BigNumber<Integer> number3 = new BigNumber<>();

        number3.addRight(1);
        number3.addRight(2);
        number3.addRight(3);
        number3.addRight(4);
        number3.addRight(5);
        number3.addRight(6);
        number3.addRight(7);
        number3.addRight(8);
        number3.addRight(9);
        number3.addRight(0);

        System.out.println("\nTest 3 - toString():  " + number3);
        System.out.print("Test 3 - iterator:    ");
        printDigitByDigit(number3);

        // ===============================================================
        // Demonstrate the error checking built into addRight, addLeft,
        // and addDecimal with calls that should change the number.
        // ===============================================================
        System.out.println("\nDemonstrating error handling:");
        BigNumber<Integer> errorDemo = new BigNumber<>();
        errorDemo.addRight(15);       // invalid digit -- out of range
        errorDemo.addLeft(-3);              // invalid digit  -- out of range
        errorDemo.addDecimal();             // valid          -- number's first decimal point
        errorDemo.addDecimal();             // invalid        -- already has a decimal point
        System.out.println("Number after error demo (should just be \".\"): " + errorDemo);
    }

    private static void printDigitByDigit(BigNumber<Integer> number) {
        BigNumber<Integer>.ListIterator it = number.iterator();
        while (it.hasNext()) {
            int digit = it.next();
            if (digit == -1) {
                System.out.print(".");
            } else {
                System.out.print(digit);
            }
        }
        System.out.println();
    }
}