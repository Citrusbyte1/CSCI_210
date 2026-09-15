/**
 * </h2>MyArrayList.java - Implementation of Java's ArrayList</h2>
 * <p><b>Problem statement: Create a class which mimics several capabilities of Java's
 *    ArrayList class</p>
 * <p><b>Instance Variables:</b></p>
 * <ul>
 *   <li>elements[] String[] an array of Strings in the ArrayList</li>
 *   <li>size (int) the number of elements in the ArrayList</li>
 * </ul>
 * @author Brian Nguyen
 * @version Module 2, Homework 1
 */

public class MyArrayList {

    // Named constants
    /** Capacity when no-argument constructor is used */
    public static final int DEFAULT_CAPACITY = 10;

    // Instance variables
    private String[] elements = null;                  // the underlying array of this arraylist
    private int size = 0;                              // the number of elements in the arraylist

   /**
    * No-argument constructor creates a default underlying array of length 10.
    */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

   /**
    * Full constructor will set all the capacity to the lone parameter (must be non-negative)
    * @param capacity the initial capacity of the arraylist (length of underlying array)
    */
    public MyArrayList(int capacity) {
        elements = new String[Math.max(0, capacity)];
        size = 0;
    }

   /**
    * Show the size and capacity (the length of the underlying array) of the arraylist,
    * followed (optionally) by the list of Strings in the arraylist.
    * @param showDetail "true" if the list of Strings should be displayed
    */
     public void show(boolean showDetail) {
         System.out.println("The size is " + size + " and the capacity is " + elements.length);
         if (showDetail) {
             System.out.println("\nHere are the Strings in arraylist");
             for (int i = 0; i < size; i++) {
                 System.out.println((i + 1) + ": " + elements[i]);
             }
         }
     }

   /**
    * Change the capacity of the array to the new capacity (a parameter)
    * @param capacity the new length of the underlying array
    */
     private void resize(int capacity) {

         // Ensure that the new capacity isn't negative
         if (capacity < 0) {
             System.out.println("Internal error - negative capacity request: " + capacity);
             return;
         }

         // If the requested capacity is the same as the current capacity, then just return
         if (capacity == elements.length) {
             return;
         }

         // System.out.println("Resizing from " + elements.length + " to " + capacity);

         // Create a new array of the requested length
         String[] newElements = new String[capacity];

         // Copy the elements from the old array into the new array
         size = Math.min(size, capacity);       // Size can never exceed capacity
         if (size >= 0) {
             System.arraycopy(elements, 0, newElements, 0, size);
         }

         // Start using the new array
         // Print message if decreasing the capacity of the array
         if (elements.length > capacity) {
             System.out.println("Resizing array down from " + elements.length + " to " + capacity);
         }
         elements = newElements;        // Old array is reclaimed by the heap automatically
    }

   //*************************** Code to be added in this assignment *****************************/

}

