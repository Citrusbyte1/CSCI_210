/**
 * <h2>Palindrome.java - Determine if a String is a palindrome.</h2>
 *
 * <p><b>Problem Statement:</b> A palindrome is a word or phrase that
 * reads the same forward and backward.  Only letters and numbers
 * are checked, spaces and punctuation are skipped.
 * Case also is ignored.</p>
 *
 * <p style="margin-left: 25px;">Examples:  Noon, Madam, 12321, and
 * "Never odd or even!" are all palindromes.</p>
 *
 * <p style="margin-left: 25px;">Write a method with the heading:</p>
 *
 * <div style="text-align: center;"><code><b>
 * public static boolean isPalindrome(String check) ;
 * </b></code></div>
 *
 * <p style="margin-left: 25px;">which determines if a String entered by the
 * user is a palindrome.</p>
 *
 * <p><b>Algorithm:</b></p>
 *
 * <p style="margin-left: 25px;">In <code><b>main</b></code>:</p>
 *
 * <ol style="margin-left: 25px;">
 *   <li>Prompt for a String to test.  (If empty then quit.)</li>
 *   <li>Call isPalindrome method using the String entered by the
 *       user as a parameter.
 *       <ul>
 *         <li>If isPalindrome returns "true" then tell the user
 *             the String is a palindrome.</li>
 *         <li>Otherwise tell the user it isn't a palindrome.</li>
 *       </ul>
 *   </li>
 *   <li>Go back to step 1.</li>
 * </ol>
 *
 * <p style="margin-left: 25px;">In the <code><b>isPalindrome</b></code> method:</p>
 *
 * <p style="margin-left: 25px;">Start a continuous loop:</p>
 *
 * <ol style="margin-left: 25px;">
 *   <li>If the length of the String is less than 2, then return "true".</li>
 *   <li>Extract first and last characters from the String, converting
 *       both to uppercase.</li>
 *   <li>Look at the first and last characters:
 *       <ol type="a">
 *         <li>If the first character isn't a number or letter, then
 *             remove it from the String and restart the loop.</li>
 *         <li>If the last character isn't a number or letter, then
 *             remove it from the String and restart the loop.</li>
 *         <li>If the first and last characters are different, then
 *             return "false".</li>
 *       </ol>
 *   </li>
 *   <li>Remove the first and last characters from the String and
 *       restart the loop.</li>
 * </ol>
 *
 * @author Brian Nguyen
 * @version Module 2, Lab 1
 */

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        // Open a Scanner object for the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Loop until the user enters an empty string.
        while (true) {

            // Prompt for a String to test
            System.out.print("Enter a String to test (or press \"Enter\" to quit): ");
            String stringToTest = keyboard.nextLine();

            // If the String is empty, then stop
            if (stringToTest.isEmpty()) {
                System.exit(0);
            }

            // Determine whether that String is a palindrome and tell the user.
            boolean result = isPalindrome(stringToTest);
            System.out.println("\"" + stringToTest + "\" is" + (result ? "" : " not ") + " a palindrome.");
        } // end of loop
    } // end main

    // Return "true" if a String is a palindrome, otherwise return false.
    private static boolean isPalindrome(String testString) {

        // Create one big loop:
        while (true) {

            // If the length of the testString is less than 2, then it's a palindrome
            if (testString.length() < 2) {
                return true;
            }

            // Get first and last character of the String and convert them to uppercase.
            char firstChar = Character.toUpperCase( testString.charAt(0) );
            char lastChar = Character.toUpperCase( testString.charAt(testString.length() - 1));

            // If the first character isn't alphanumeric, then remove it and restart loop
            if (! Character.isLetterOrDigit( firstChar )) {
                testString = testString.substring(1);
                continue;
            }

            // If the last character isn't alphanumeric, then remove it and restart loop
            if (! Character.isLetterOrDigit( lastChar )) {
                testString = testString.substring(0, testString.length() - 1);
                continue;
            }

            // If the first and last characters are different, then it's not a palindrome
            if (firstChar != lastChar) {
                return false;
            }

            // Remove first and last characters and restart loop
            testString = testString.substring(1, testString.length() - 1);
        }
    }
}
