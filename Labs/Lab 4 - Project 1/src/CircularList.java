import java.util.NoSuchElementException;

/**
 * <h2>CircularList.java - Circular Linked List with additional methods.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Contains a CircularList&lt;E&gt; class with inner classes Node&lt;E&gt; and
 *   ListIterator. The last node's link points back to the first node
 *   (head) instead of to null, and a tail reference and size variable
 *   are maintained since there is no null link to mark the end of the
 *   list.</p>
 * @author Brian Nguyen
 * @version Module 4, Exercise #1
 */

public class CircularList<E> {

    private Node<E> head;

    // ADDED (Exercise #1, step 8): a tail reference and a size counter,
    // since a circular list has no null link to mark the end.
    private Node<E> tail = null;
    private int size = 0;

    /**
     * Add a method to create an iterator
     */
    public ListIterator iterator() {
        return new ListIterator();
    }

    /**
     * No-argument constructor sets the "head" variable to null.
     */
    // CHANGED (Exercise #1, step 9): also initializes tail and size.
    public CircularList() {
        head = tail = null;
        size = 0;
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

    /**
     * Adds a node at the start of the list with the specified data.
     * The added node will be the first node in the list.
     * @param newItem the object to be added to the data portion
     * of the new front of the list.
     */
    // CHANGED (Exercise #1, step 10): rewritten entirely to keep the list
    // circular (tail always links to the new head) and to maintain size.
    public void addFront(E newItem) {
        Node<E> oldHead = head;
        head = new Node<>(newItem, head);
        if (head.link == null) {
            head.link = head; // only Node links back to itself
        }
        if (tail == null) {
            tail = head; // only one Node in the list
        } else {
            tail.link = head; // link in last node
        }
        size++;
    }

    /**
     * Removes the first node and returns the data element that was
     * removed from the list.  Returns null if the list is empty.
     * @return the data element of the node removed from the list
     */
    // CHANGED (Exercise #1, step 11): rewritten to keep the list circular
    // and to maintain size.
    public E removeFront() {
        if (head == null) {
            return null;
        } else {
            Node<E> nodeToRemove = head;
            if (size == 1) {
                tail = head = null; // list is now empty
            } else {
                tail.link = head = head.link; // update head and last Node
            }
            size--;
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
    // CHANGED (Exercise #1, step 12): also resets tail and size.
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Returns the number of nodes in the list
     * @return a count of the number of nodes in the list
     */
    // CHANGED (Exercise #1, step 13): just returns the size variable
    // instead of counting nodes (a circular list has no null link to
    // stop at).
    public int size() {
        return size;
    }

    /**
     * Returns the index of the object passed as a parameter, or -1 if not found
     * @return the index of the object, or -1 if not found
     */
    // CHANGED (Exercise #1, step 14): uses a for loop bounded by size
    // instead of a while loop bounded by a null link.
    public int indexOf(Object lookupData) {

        Node<E> position = head;
        int index = 0;

        for (index = 0; index < size; index++) {
            if (lookupData.equals(position.data)) {
                return index;
            }
            position = position.link;
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
     * Returns a String with the list of all the items in the list
     * @return a String with the list (using toString) of all items in the list
     */
    // CHANGED (Exercise #1, step 15): uses a for loop bounded by size
    // instead of a while loop bounded by a null link.
    public String toString() {

        StringBuilder returnString = new StringBuilder("Items in list: ");
        Node<E> position = head;

        if (head == null) {
            returnString.append("(none)");
        } else {
            for (int i = 0; i < size; i++) {
                returnString.append(position.data).append(" ");
                position = position.link;
            }
        }

        return returnString.toString();
    }

    /**
     * Compares the sizes of another list, and verifies that the object in this
     * list are the same as in the other list
     * @return true if the two lists contain the same objects
     */
    // CHANGED (Exercise #1, step 5 and 16): "LinkedList" renamed to
    // "CircularList", and the while loop replaced with a for loop bounded
    // by size.
    public boolean equals(Object anObject) {
        if (anObject == null || getClass() != anObject.getClass()) {
            return false;
        }

        @SuppressWarnings("unchecked")
        CircularList<E> anotherList = (CircularList<E>) anObject;

        // Both lists should be the same size
        if (size() != anotherList.size()) {
            return false;
        }

        // Start at the front of the 'this' list
        Node<E> position = head;
        Node<E> anotherPosition = anotherList.head;

        // Make sure every name in this list is also in the other list
        for (int i = 0; i < size; i++) {
            if (!position.data.equals(anotherPosition.data)) {
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
     * <h2>ListIterator.java -- an (inner) iterator class</h2>
     *
     * <p>Instance variables:</p>
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
         * Constructor sets current position to the beginning of the list
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
         */
        public E peek() {
            if (!hasNext())
                throw new IllegalStateException();
            return position.data;
        }

        /**
         * add inserts a node before the node at location position.  previous
         * is placed at the new node. If hasNext() is false, then the node
         * is added to the end of the list.  If the list is empty, inserts
         * node as the only node.
         */
        // CHANGED (Exercise #1, step 18): rewritten entirely to keep the
        // list circular and to maintain tail/size.
        public void add(E newData) {

            if (size == 0) {
                CircularList.this.addFront(newData);
            } else {
                Node<E> temp = new Node<>(newData, position);
                if (previous != null) {
                    previous.link = temp;
                    previous = temp;
                } else {
                    head = temp;
                    previous = temp;
                }
                size++;
                if (position == head) {
                    tail = temp;
                }
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
        // CHANGED (Exercise #1, step 19): rewritten entirely to keep the
        // list circular and to maintain tail/size.
        public void remove() {

            if (position == null)
                throw new IllegalStateException();

            if (position == head) {
                removeFront();
                position = head;
            } else {
                if (position == tail) {
                    tail = previous;
                }
                previous.link = position.link;
                position = position.link;
                size--;
            }
        }
    } // end of ListIterator inner class
}
