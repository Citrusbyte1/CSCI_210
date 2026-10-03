import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * <h2>LinkedList.java - LinkedList used to start Homework assignments for Module 3.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *     Contains a LinkedList<E> class with inner classes Node<E> and ListIterator.</p>
 * @author Brian Nguyen
 * @version Module 3, Homework 1 and 2
 */

public class BigNumber<E> {

    private Node<E> head;

    /**
     * Add a method to create an iterator
     */
    public ListIterator iterator() {
        return new ListIterator();
    }

    /**
     * No-argument constructor sets the "head" variable to null.
     */
    public BigNumber() {
        // Initialize the linked list of digits
        head = null;
    }

    /**
     * Return the data element of the first node in the list
     * @return the object in the first node of the list (or null if empty)
     */
    public E getFront() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /***************************************************************
     * Adds a node at the start of the list with the specified data.
     * The added node will be the first node in the list.
     * @param newObject the object to be added to the data portion
     * of the new front of the list.
     ***************************************************************/
    public void addFront(E newObject) {
        head = new Node<E>(newObject, head);
    }

    /**********************************************************************
     * Removes the first node and returns the data element that was
     * removed from the list.  Returns null if the list is empty.
     * @return the data element of the node removed from the list
     **********************************************************************/
    public E removeFront() {
        if (head == null) {
            return null;
        } else {
            Node<E> nodeToRemove = head;
            head = head.link;
            return nodeToRemove.data;
        }
    }

    /**
     * Returns true if the list is empty, false if at least one node is present
     * @return "true" if list is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Empties the linked list.  Garbage collection will reclaim the space.
     */
    public void clear() { head = null; }

    /**
     * Returns the number of nodes in the list
     * @return a count of the number of nodes in the list
     */
    public int size() {

        int count = 0;
        Node<E> position = head;

        // Traverse the list counting nodes
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    /**
     * Returns the index of the object passed as a parameter, or -1 if not found
     * @return the index of the object, or -1 if not found
     */
    public int indexOf(Object lookupData) {

        // Start at the beginning
        Node<E> position = head;
        int count = 0;

        // Traverse the list looking for the first occurrence of the data item
        while (position != null) {
            if (lookupData.equals(position.data)) {
                return count;
            }
            position = position.link;
            count++;
        }
        return -1;
    }

    /**
     * Returns true if the list contains the data object passed as a parameter
     * @return true if the object passed as a parameter is somewhere in the list
     */
    public boolean contains(Object lookupData) {
        return (indexOf(lookupData) >= 0);
    }

    /**
     * Returns a String with the list of all items in the list
     * @return a String with the list (using toString) of all items in the list
     */
    
    public String toString() {
 
        StringBuilder returnString = new StringBuilder();
        Node<E> position = head;
 
        // Add each digit (or a decimal point in place of -1)
        while (position != null) {
            if (position.data.equals(-1)) {
                returnString.append(".");
            } else {
                returnString.append(position.data);
            }
            position = position.link;
        }
 
        return returnString.toString();
    }

    /**
     * Compares the sizes of another list, and verifies that the object in this
     * list are the same as in the other list
     * @return true if the two lists contain the same objects
     */

    public boolean equals(Object anObject) {
        if (anObject == null || getClass() != anObject.getClass()) {
            return false;
        }

        @SuppressWarnings("unchecked")
        BigNumber<E> anotherList = (BigNumber<E>) anObject;

        // Both lists should be the same size
        if (size() != anotherList.size()) {
            return false;
        }

        // Start at the front of the list
        Node<E> position = head;
        Node<E> anotherPosition = anotherList.head;

        // Make sure every name in this list is also in the other list
        while (position != null) {
            if (! position.data.equals(anotherPosition.data)) {
                return false;
            }
            position = position.link;
            anotherPosition = anotherPosition.link;
        }
        return true;
    }

    /* *********************************************************************
     *                                                                     *
     *                    Add your methods below here                      *
     *                                                                     *
     ***********************************************************************/

    public void addLast(E value) {
    
        Node<E> newNode = new Node<>(value, null);

        if (head == null) {
            head = newNode;
            return;
        }
 
        Node<E> current = head;

        while (current.link != null) {
            current = current.link;
        }
 
        current.link = newNode;
    }
 
 
    public void addRight(int digit) {
 
        if (digit < 0 || digit > 9) {
            System.out.println("Error: Digit must be between 0 and 9");
            return;
        }

        E digitAsElement = (E) Integer.valueOf(digit);

        addLast(digitAsElement);
    }
 
    //a method that adds a digit to the beginning of a list.
    public void addFirst(E value) {
 
        Node<E> newNode = new Node<>(value, head);
        head = newNode;
    }
 
 
    public void addLeft(int digit) {
 
        if (digit < 0 || digit > 9) {
            System.out.println("Error: Digit must be between 0 and 9");
            return;
        }

        E digitAsElement = (E) Integer.valueOf(digit);

        addFirst(digitAsElement);
    }
 
    //a method that adds a decimal point to the end of a list.
    // More digits can be added after the decimal point using addLeft.
    public void addDecimal() {
 
        if (contains(-1)) {
            System.out.println("Error: A decimal point has already been added");
            return;
        }

        E decimalMarker = (E) Integer.valueOf(-1);

        addFirst(decimalMarker);
    }

    /* *********************************************************************
     *                                                                     *
     *                   Add your methods above here                       *
     *                                                                     *
     ***********************************************************************/

    // Make this class static, since it doesn't need to access non-static
    // members of the outer class.
    private static class Node<E> {

        private E data;
        private Node<E> link;

        public Node() {
            data = null;
            link = null;
        }

        public Node(E data, Node<E> link) {
            this.data = data;
            this.link = link;
        }
    } // end of Node inner class

    /**
     * <h2>ListIterator.java -- an (inner) iterator class<h2>
     *
     * <p>Instance variables:</h2>
     * <ul>
     *    <li>Node position - current position of iterator</li>
     *    <li>Node previous - node prior to node at position</li>
     * </ul>
     * <p>Methods (all are public)</p>
     * <ul>
     *    <li>Full constructor</li>
     *    <li>restart</li>
     *    <li>next</li>
     *    <li>hasNext</li>
     *    <li>peek</li>
     *    <li>add</li>
     *    <li>set</li>
     *    <li>remove</li>
     *    <li>note:  equals and toString() are not implemented</li>
     * </ul>
     *
     * <p>Can throw a NoSuchElementException if trying to set or remove an
     *    element at a non-existent position</p>
     *
     * <p>Can thrown an IllegalStateException if trying to peek at the next
     *     element in the list if none exists</p>
     *
     * <p>Note: If any changes are made to a list, then the calling program should
     *          restart any iterators on that list</p>
     */
    public class ListIterator {

        private Node<E> position;
        private Node<E> previous;

        /**
         * Constructors sets current position to the beginning of the list
         * and previous to nothing.
         */
        public ListIterator() {
            position = head;           //Instance variable head of outer class.
            previous = null;
        }

        // Java's iterators are unstable after making changes to the list,
        // so they recommend simply creating a new iterator
        //
        // We'll just reset some variables.
        public void restart() {
            position = head;            //Instance variable head of outer class.
            previous = null;
        }

        /*
         * Returns the data element at the current position of the iterator
         * and moves ahead one element
         * @return the data element at the current position of the iterator
         */
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            E toReturn = position.data;
            previous = position;
            position = position.link;
            return toReturn;
        }

        /**
         * Returns true if there is a next element in the iterator
         * @return true if the iterator is currently pointing to another node
         * in the linked list
         */
        public boolean hasNext() {
            return (position != null);
        }

        /**
         * Returns the next value to be returned by next() -- if there is one.
         * Will throw an IllegalStateExpression if hasNext() is false.
         * @return the element to be returned by next()
         **********************************************************************/
        public E peek() {
            if (!hasNext())
                throw new IllegalStateException();
            return position.data;
        }

        /*********************************************************************
         * add inserts a node before the node at location position.  previous
         * is placed at the new node. If hasNext() is false, then the node
         * is added to the end of the list.  If the list is empty, inserts
         * node as the only node.
         *********************************************************************/
        public void add(E newData) {

            // If at the end of the list, then just add to the previous reference
            if (position == null && previous != null) {
                previous.link = new Node<E>(newData, null);

                // If the list is empty, then invoke the iterator's add method
            } else if (position == null || previous == null) {
                BigNumber.this.addFront(newData);

                // Otherwise insert this new node between previous and position
            } else {
                Node<E> temp = new Node<E>(newData, position);
                previous.link = temp;
                previous = temp;
            }
        }

        /**
         * Changes the object in the node at location position.
         * Throws an IllegalStateException if position is not at a node,
         * @param newData the object to replace the data section at the
         * current node
         */
        public void set(E newData) {

            // If there is nothing in the list, then throw an exception
            if (position == null)
                throw new IllegalStateException();

            // Update the item at the current position
            position.data = newData;
        }

        /**
         * Removes the node at location position and
         * moves position to the "next" node.
         * Throws an IllegalStateException if the list is empty.
         */
        public void remove() {

            // If the is empty, then thrown an exception
            if (position == null)
                throw new IllegalStateException();

            // If at the front of the list, then just move position and head
            // references to the second item in the list (or null)
            if (previous == null) {
                head = head.link;
                position = head;

                // Otherwise remove the link at position
            } else {
                previous.link = position.link;
                position = position.link;
            }
        }
    } // end of ListIterator inner class
}

