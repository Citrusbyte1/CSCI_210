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
    
        /** Below this capacity, automatic trimming in remove() will not occur */
    public static final int AUTO_TRIM_MINIMUM = 100;
 
    /** Automatic trimming occurs when (size / capacity) falls below this ratio */
    public static final double AUTO_TRIM_THRESHOLD = 0.5;
 
    /** When automatic trimming occurs, capacity is multiplied by this amount */
    public static final double AUTO_TRIM_AMOUNT = 0.6;

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
 
    /**
     * <p>Getter for the number of elements in the Arraylist.</p>
     * @return the number of elements in the Arraylist
     */
    public int getSize() {
        return size;
    }
 
    /**
     * <p>Getter for the capacity of the Arraylist (the length of the
     * underlying array).</p>
     * @return the capacity of the Arraylist
     */
    public int getCapacity() {
        return elements.length;
    }
 
    /**
     * <p>Add a String to the end of the Arraylist. If the capacity
     * must be increased, it will be doubled automatically.</p>
     * @param newElement the String to be added to the list's end
     */
    public void add(String newElement) {
        if (size == elements.length) {
            resize(Math.max(1, 2 * size));
        }
        elements[size] = newElement;
        size++;
    }
 
    /**
     * <p>Set the value of an element at position "index" to a String.
     * (Note: index must be between 0 and (size - 1).</p>
     * @param index the position in the Arraylist to be updated
     * @param newElement the new String for element at position index
     * @return true if the element was updated, false otherwise
     */
    public boolean set(int index, String newElement) {
        if (index < 0 || index > size - 1) {
            System.out.println("Error: element at index " + index + " is not available");
            return false;
        }
        elements[index] = newElement;
        return true;
    }
 
    /**
     * <p>Return the String element at a specific index in the list.</p>
     * @param index the position of the String to be returned in the list
     * @return the String at the given index, or null if index is out of range
     */
    public String at(int index) {
        if (index < 0 || index > size - 1) {
            System.out.println("Error: element at index " + index + " is not available");
            return null;
        }
        return elements[index];
    }
 
    /**
     * <p>Insert a String anywhere in the Arraylist. If the capacity
     * must be increased, it will be doubled automatically via
     * this method. (Note: index must be between 0 and size).</p>
     * @param index the position in the Arraylist of the new String
     * @param newElement the String to be added to end of the list
     * @return true if the element was added, false otherwise
     */
    public boolean add(int index, String newElement) {
        if (index < 0 || index > size) {
            System.out.println("Error: cannot add element at index " + index);
            return false;
        }
 
        if (size == elements.length) {
            resize(Math.max(1, 2 * size));
        }
 
        // Shift elements up one position, starting from the end and working
        // backward -- otherwise each value would be overwritten before it
        // had a chance to be copied into its new position
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
 
        elements[index] = newElement;
        size++;
 
        return true;
    }
 
    /**
     * <p>Remove the element at position "index" from the Arraylist.
     * (Note: index must be between 0 and (size - 1).</p>
     * @param index position in the list whose element is be removed
     * @return true if the element was removed, false otherwise
     */
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: element at index " + index + " is not available");
            return false;
        }
 
        // Shift all elements after index down one position
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
 
        // Automatic trimming: shrink the array once it becomes too sparse
        if (elements.length < AUTO_TRIM_MINIMUM) {
            return true;
        }
        if ((double) size / elements.length >= AUTO_TRIM_THRESHOLD) {
            return true;
        }
        int newCapacity = (int) (elements.length * AUTO_TRIM_AMOUNT);
        resize(newCapacity);
 
        return true;
    }
 
    /**
     * <p>Reduces the capacity of the Arraylist to its size,
     * eliminating unused space.</p>
     */
    public void trimToSize() {
        if (size == elements.length) {
            return;
        }
        resize(size);
    }
 
}
