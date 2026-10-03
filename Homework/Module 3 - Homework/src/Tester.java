/**
 * <h2>BigNumberTester.java - Tests the BigNumber class.</h2>
 *
 * <p><b>Problem Statement:</b> Demonstrate that a BigNumber can be built
 * one digit at a time (from either end, or with a decimal point inserted
 * partway through), that it correctly rejects invalid input, and that its
 * digits can be read back both as a formatted String and one at a time
 * using an iterator.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Build three BigNumbers, each with 10 or more digits. Two of them
 *       interleave calls to addRight, addDecimal, and addLeft so that the
 *       decimal point ends up in the middle of the number, with digits on
 *       both sides. The third is a plain whole number built with
 *       addRight.</li>
 *   <li>For each BigNumber, display it using toString(), then again by
 *       reading its digits one at a time with an iterator.</li>
 *   <li>Demonstrate that addRight, addLeft, and addDecimal all reject
 *       invalid input (an out-of-range digit, or a second decimal
 *       point) without changing the number.</li>
 * </ol>
 *
 * @author Brian Nguyen
 * @version Module 3, Homework 3, Project 1
 */
public class Tester {

    public static void main(String[] args) {

        // ---------------------------------------------------------------
        // Test 1: a decimal point in the middle of the number.
        //
        // addDecimal() always inserts the decimal marker at the CURRENT
        // front of the list. So to end up with the decimal point in the
        // middle, the fractional digits must be added first (with
        // addRight, in normal left-to-right order), THEN the decimal
        // point, and only THEN the integer-part digits -- added with
        // addLeft in reverse order, since each addLeft call pushes ahead
        // of everything already in the list.
        //
        // Expected result: 12345.678901
        // ---------------------------------------------------------------
        BigNumber<Integer> number1 = new BigNumber<>();

        // Build the fractional part "678901" first, left to right
        number1.addRight(6);
        number1.addRight(7);
        number1.addRight(8);
        number1.addRight(9);
        number1.addRight(0);
        number1.addRight(1);

        // Insert the decimal point immediately before the fractional part
        number1.addDecimal();

        // Build the integer part "12345", adding its digits in reverse
        // order (5, 4, 3, 2, 1) so that they end up reading correctly
        number1.addLeft(5);
        number1.addLeft(4);
        number1.addLeft(3);
        number1.addLeft(2);
        number1.addLeft(1);

        System.out.println("Test 1 - toString():  " + number1);
        System.out.print("Test 1 - iterator:    ");
        printDigitByDigit(number1);

        // ---------------------------------------------------------------
        // Test 2: another decimal point in the middle, using the same
        // technique as Test 1 (fractional part first, then the decimal
        // point, then the integer part added in reverse).
        //
        // Expected result: 3.14159265358
        // ---------------------------------------------------------------
        BigNumber<Integer> number2 = new BigNumber<>();

        // Build the fractional part "14159265358"
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

        // Build the (single-digit) integer part "3"
        number2.addLeft(3);

        System.out.println("\nTest 2 - toString():  " + number2);
        System.out.print("Test 2 - iterator:    ");
        printDigitByDigit(number2);

        // ---------------------------------------------------------------
        // Test 3: a plain whole number, no decimal point. Since there's
        // no decimal point to worry about, the digits can simply be
        // appended left to right using addRight.
        //
        // Expected result: 1234567890
        // ---------------------------------------------------------------
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

        // ---------------------------------------------------------------
        // Demonstrate the error checking built into addRight, addLeft,
        // and addDecimal. None of these calls should change the number.
        // ---------------------------------------------------------------
        System.out.println("\nDemonstrating error handling:");
        BigNumber<Integer> errorDemo = new BigNumber<>();
        errorDemo.addRight(15);     // invalid digit -- out of range
        errorDemo.addLeft(-3);      // invalid digit -- out of range
        errorDemo.addDecimal();     // valid -- the number's first decimal point
        errorDemo.addDecimal();     // invalid -- already has a decimal point
        System.out.println("Number after error demo (should just be \".\"): " + errorDemo);
    }

    /**
     * Uses a BigNumber's iterator to print its digits one at a time,
     * printing a decimal point wherever the -1 sentinel value appears
     * (instead of printing the number -1 itself).
     *
     * @param number the BigNumber whose digits should be printed
     */
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