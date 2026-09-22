/**
 * </h2>Tester.java - Test the methods of MyArrayList</h2>
 * <p><b>Problem statement: Create several tests for the new MyArrayList class.</b></p>
 * <p><b>Algorithm:</b></p>
 * <ul>
 *   <li>Create a new arraylist using the default constructor.  Add two Strings and show results.</li>
 *   <li>Create a new arraylist with a capacity of 10.   Add more than 10 Strings and show results.</li>
 *
 *   <li>size (int) the number of elements in the arraylist</li>
 *   <li>capacity (int) the size of the underlying array elements[].</li>
 * </ul>
 * @author Brian Nguyen
 * @version Module 2, Homework 1
 */

public class Tester {

    public static void main(String[] args) {

        //*********************************** Constructor Test **********************************/

        // Create new arraylist using default constructor and using the one-parameter constructor.
        System.out.println("Create an empty arraylist using the default constructor");
        MyArrayList list1 = new MyArrayList();
        list1.show(false);

        System.out.println("\nCreate an empty arraylist using a constructor with capacity of 100");
        MyArrayList list2 = new MyArrayList(100);
        list2.show(false);

        // Release memory
        list1 = list2 = null;
        //********************** Test getters, add, set, and at methods **********************/
        
        // Create an arraylist with default constructor, then fill with 1,000 lines.
        System.out.println("\nCreate an arraylist and fill with 1,000 Strings.");
        list1 = new MyArrayList();
        for (int i = 0; i < 1000; i++) {
            list1.add("String at " + i);
        }
        list1.show(false);
        System.out.println("The value returned by getSize() is:     " + list1.getSize());
        System.out.println("The value returned by getCapacity() is: " + list1.getCapacity() + "\n");

        // Get the value at index 429, print old value, change to "New string"), and use the at
        // method to show old and new values.
        System.out.println("Old element at index 429: " + list1.at(429));
        list1.set(429, "A new string " + 429);
        System.out.println("New element at index 429: " + list1.at(429) + "\n");

        // Try to access an element outside the valid range (valid range should be
        // from 0 to (size - 1)
        System.out.println("Test range checks for \"at\" and \"set\" methods.");
        int index = list1.getSize();
        System.out.println("Trying to access an element at a negative index");
        list1.at(-1);
        System.out.println("Try to access an element at position: " + index);
        list1.at(index);
        System.out.println("Trying to set an element at a negative index");
        list1.set(-1, "Bad value");
        System.out.println("Try to set an element at position: " + index);
        list1.set(index, "Another bad value");
        

        //********************* Test the second add and the remove ******************/
        
        // Try to insert a new line before each existing line, working backwards in the arraylist
        for (int i = 999; i >= 0; i--) {
            list1.add(i, "A new line " + i);
        }
        System.out.println("After inserting a new line before each line, elements 0 - 10 are:");
        for (int i = 0; i <= 10; i++) {
            System.out.println("Element " + i + ": " + list1.at(i));
        }
        System.out.println("And here are the new stats:");
        list1.show(false);

        // Remove all but 20 elements
        while (list1.getSize() > 20) {
            list1.remove(20);
        }
        System.out.println("\nAfter removing all but 20 elements from the arraylist, the stats:");
        list1.show(false);

        // Run the trimToSize method and show the results.
        System.out.println("\nAfter running the \"trimToSize\" method:");
        list1.trimToSize();
        list1.show(false);
        
    }
}
