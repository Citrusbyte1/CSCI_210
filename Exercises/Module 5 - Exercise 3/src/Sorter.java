import java.util.Random;
import java.util.Scanner;

/**
 * <h2>Sorter.java - Use two stacks to sort an array</h2>
 * <p><b>Description:</b> Demonstrate using LinkedLists as stacks to sort
 *       elements in a (generic) array</p>
 * <p><b>Algorithm:</b> In <code>main</code> create arrays of Integer objects in
         different sequences and sizes</p>
 * <p>Prompt for the sequence the original array should be in (random, ascending,
 *    or descending) order.</p>
 * <p>Prompt for the size of the original array - should be between 10 and 1,000</p>
 * <p>Build an array of Integer objects in the specified sequence and of the
 *    specified size</p>
 * <p>Call the "sorter" method which takes any array of objects which implement the
 *    Comparable<E> interface, then use two generic LinkedLists to return the array
 *    in ascending order</p>
 * <ol style="margin-left: 40px;">
 *    <li>Use two LinkedLists to be used as stacks (push, pop, and peek)
 *    <li>Create a counter for the number of times a "push" is used on either stack</li>
 *    <li>Load the array into one of the LinkedLists, then use as stack #1</li>
 *    <li>While stack #1 is not empty:
 *        <ol style="margin-left: 40px;" type="a">
 *            <li>Pop the top element of that stack into a temporary variable</li>
 *            <li>Pop all elements from stack #2 that are less than or equal to the
 *                temporary variable back onto stack #1</li>
 *            </li>Push the element in the temporary variable onto stack #2</li>
 *            <li>Remember to increment the counter for the total number of pushes used
 *        </ol>
 *    </li>
 *    <li>When the loop finishes, load stack #2 back into the original array</li>
 *    <li>Return the count of pushes</li>
 * </ol>
 * <p><b>Discussion Items:</b></p>
 * <ul style="margin-left: 40px;">
 *     <li>Note that only the push, pop, and peek methods are used on the LinkedLists</li>
 *     <li>Time Efficiency for random or descending order is O(n^2)</li>
 *     <li>Best case efficiency is O(n) (ascending order)</li>
 *     <li>Space Efficiency is 2n (two LinkedLists)</li>
 * </ul>
 * @author Chris Merrill
 * @version Module 5, Exercise #3
 */
public class Sorter {

    void main() {

        // Ask user to determine the initial sequence of the array to be sorted and
        // size of the array
        Scanner keyboard = new Scanner(System.in);
        int sequence = 0;
        do {
            System.out.print("Which original order (1-random, 2-ascending, 3-descending): ");
            String response = keyboard.next();
            try {
                sequence = Integer.parseInt(response);
            } catch (NumberFormatException e) {
                System.out.println("  That's not a number -- retry");
                continue;
            }
            if (sequence < 1 || sequence > 3) {
                System.out.println("   Please enter a number between 1 and 3");
            }
        } while (sequence < 1 || sequence > 3);

        int size = 0;
        do {
            System.out.print("How big to make the array (10 - 1,000): ");
            String response = keyboard.next();
            try {
                size = Integer.parseInt(response);
            } catch (NumberFormatException e) {
                System.out.println("   That's not a number -- retry");
                continue;
            }
            if (size < 10 || size > 1000) {
                System.out.println("  Please enter a number between 10 and 1,000");
            }
        } while (size < 10 || size > 1000);

        // Create an array of random numbers, an array of increasing number, or an array
        // of decreasing numbers
        Random random = new Random();
        Integer[] array = new Integer[size];
        String description = "";                     // random, ascending, or descending

        // Determine the original sequence of the elements in the array
        switch (sequence) {
            case 1 -> description = "random";
            case 2 -> description = "ascending";
            case 3 -> description = "descending";
        }

        // Initialize the array based on the original sequence
        for (int i = 0; i < size; i++) {

            switch(sequence) {
                case 1 -> array[i] = random.nextInt(size) + 1;      // random order
                case 2 -> array[i] = i + 1;                         // ascending order
                case 3 -> array[i] = size - i;                      // descending order
            }
        }

        // Print the array before sorting
        // Print the total number of "pushes" used and the sorted array
        System.out.println("\nThe array before sorting:");
        for (int i = 0; i < size; i++) {
            System.out.printf("%4d", array[i]);
            if ((i + 1) % 25 == 0) {
                System.out.println();          // Put 25 numbers on a line
            }
        }

        // Call the method to use two stacks to sort
        int pushes = sorter(array);

        // Print the total number of "pushes" used and the sorted array
        System.out.printf("%nTotal of %,d pushes for %,d %s numbers%n",
                           pushes, size, description);
        for (int i = 0; i < size; i++) {
            System.out.printf("%4d", array[i]);
            if ((i + 1) % 25 == 0) {
                System.out.println();
            }
        }
    }

    // Use 2 stacks (implemented using LinkedLists) to sort the array and return the total number of pushes
    // used in the sort

    public static <E extends Comparable<E>> int sorter(E[] arr) {

        int count = 0;                     // number of pushes used during the sorting

        // ******************************* START ADDING CODE HERE *****************************/

        // ****************************************************************************/

        return count;                          // total number of pushes used
    }
}
