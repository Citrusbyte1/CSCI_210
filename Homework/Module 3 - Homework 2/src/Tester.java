/**
 * <h2>LinkedListTester.java - Tests the addOrdered method from LinkedList.</h2>
 *
 * <p><b>Problem Statement:</b> Show that addOrdered() builds a sorted LinkedList
 * one item at a time no matter the order of added  items, for both Integer and
 * String elements.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Build a LinkedList&lt;Integer&gt; by calling addOrdered() with 8
 *       unsorted values, then display both the original order they were
 *       added in and the sorted order in the list.</li>
 *   <li>Repeat the same process for a LinkedList&lt;String&gt;.</li>
 * </ol>
 *
 * @author Brian Nguyen
 * @version Homework 3, Project 2
 */

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
 
        // ===========================================================
        // Test 1: a LinkedList of 8 out of order Integer objects.
        // ==========================================================
        Integer[] unsortedNumbers = {42, 7, 99, 3, 56, 18, 71, 24};
 
        LinkedList<Integer> numberList = new LinkedList<>();
        for (Integer value : unsortedNumbers) {
            numberList.addOrdered(value);
        }
 
        IO.println("Test 1: ints");
        IO.println("  Added in this order:    " + Arrays.toString(unsortedNumbers));
        IO.println("  in sorted order:  " + numberList);
 
        // ===========================================================
        // Test 2: a LinkedList of 8 out of order String objects
        // ===========================================================
        String[] unsortedNames = {"Zoe", "Amy", "Mia", "Jon", "Eve", "Tom", "Ben", "Sam"};
 
        LinkedList<String> nameList = new LinkedList<>();
        for (String value : unsortedNames) {
            nameList.addOrdered(value);
        }
 
        IO.println("\nTest 2: Strings");
        IO.println("  Added in this order:    " + Arrays.toString(unsortedNames));
        IO.println("  in sorted order:  " + nameList);
    }
}
