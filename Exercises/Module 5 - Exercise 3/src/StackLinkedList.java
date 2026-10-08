/**
 * <h2>StackLinkedList.java - Generic stack implemented using a LinkedList</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 25px;">Use a LinkedList to implement a stack</p>
 * <p style="margin-left: 25px;">An inner class defining a node in the LinkedList</p>
 * <ul style="margin-left: 50px;">
 *   <li>A data section E (generic)</li>
 *   <li>A link to the next node in the list</li>
 * </ul>
 * <p style="margin-left: 25px;">Also uses an external UnderflowException class thrown when
 *    trying to pop or peek on an empty stack.</p>
 * <p style="margin-left: 25px;">Unlike the StackArray demo, this class cannot throw an
 *    OverflowException when full, and there is no "isFull" method.</li>
 * <p style="margin-left: 25px;">Taken from LinkedList demo in Module 3 with modifications.</p>
 * <ul style="margin-left: 50px;">
 *   <li>"tail" node reference is not needed, since stacks just work only at one end</li>
 *   <li>Removed iterator logic -- not needed</li>
 *   <li>Removed "equals" method -- not needed</li>
 *   <li>Removed "contains" method -- not needed</li>
 *   <li>Renamed "first" node in list to "top"</li>
 *   <li>Renamed "addFront" method to "push"</li>
 *   <li>Renamed "removeFront" to "pop", changed to throw an UnderflowException
 *       if stack is empty</li>
 *   <li>Added "peek" method, which can throw an UnderflowException if
 *       stack is empty</li>
 *   <li>Kept the "indexOf" method, but is often called "search" in stack lingo</li>
 *   <li>Copied UnderflowException class from StackArray demo</li>
 * </ul>
 * @author Chris Merrill
 * @version Module 5, Demonstration
 */

public class StackLinkedList<E> {

    private Node<E> top;            // the top of the stack

    /**
     * No-argument constructor sets the "top" variable to null.
     */
    public StackLinkedList() {
        top = null;
    }

    /***************************************************************
     * Adds a node to the start of the list with the specified data
     * object.  (Was named "addFront" in LinkedList, now is "push").
     * @param newObject the object to be added to the data portion
     * of the new front of the list.
     ***************************************************************/
    public void push(E newObject) {
        top = new Node<>(newObject, top);
    }

    /**********************************************************************
     * Removes the first node and returns the data element that was
     * in that node.  Throws UnderflowException if list is empty.  (Was
     * removeFront in original LinkedList, now is pop.)
     * @return the data element of the node removed from the list
     **********************************************************************/
    public E pop() throws UnderflowException {
        if (top == null) {
            throw new UnderflowException();
        } else {
            Node<E> nodeToRemove = top;        // node to remove
            top = top.link;
            return nodeToRemove.data;
        }
    }

     /**********************************************************************
     * Returns the data element in first node (top of the stack).  Throws an
     * UnderflowException if list is empty.  New for the stack class.
     * @return the data element of the first node in the list
     **********************************************************************/
    public E peek() throws UnderflowException {
        if (top == null) {
            throw new UnderflowException();
        } else {
            return top.data;
        }
    }

    /**
     * Returns true if the list is empty, false if at least one node is present
     * @return "true" if list is empty
     */
    public boolean isEmpty() {
        return (top == null);
    }

    /**
     * Empties the LinkedList.  Garbage collection will reclaim the space.
     */
    public void clear() { top = null; }

    /**
     * Returns the number of nodes in the list
     * @return a count of the number of nodes in the list
     */
    public int size() {

        int count = 0;
        Node<E> position = top;

        // Traverse the list counting nodes
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    /**
     * Returns the index of the object passed as a parameter, or -1 if not found
     * @return the index of the t object, or -1 if not found
     */
    public int indexOf(Object anObject) {

        // Start at the beginning of the list (index 0)
        Node<E> position = top;
        int index = 0;

        // Traverse the list looking for the first occurrence of the data item
        while (position != null) {
            if (anObject.equals(position.data)) {
                return index;
            }
            position = position.link;
            index++;
        }
        return -1;                      // not found
    }

    /**
     * Returns a String with the list of the items in the list
     * @return a String with the list (using toString) of all items in the list
     */
    public String toString() {

        StringBuilder returnString = new StringBuilder("Items in list: ");

        // Add each node
        if (top == null) {
            returnString.append("(none)");
        } else {
            Node<E> position = top;
            while (position != null) {
                returnString.append(position.data).append(" ");
                position = position.link;
            }
        }

        return returnString.toString();
    }

    /** <h2>Node.java - A node of a linked list containing the data element and a link</h2>
     * <p>Instance Variables:<p>
     * <ul>
     *    <li>E data</li>
     *    <li>Node link - link to next Node in linked list</li>
     * </ul>
     * @author Chris Merrill (based on version from textbook)
     * @version Module 3, Demonstration
     */

    private static class Node<E> {

        // Instance variables
        private E data;                // data portion of the node
        private Node<E> link;         // link to next node in the list (or null for end-of-list)

        /**
         * No-argument constructor (sets data and link variables to null)
         */
        public Node() {
            data = null;
            link = null;
        }

        /**
         * Full constructor for this node
         * @param data the object to be saved in the node
         * @param link a reference to the next node in the list (or null for end-of-list)
         */
        public Node(E data, Node<E> link) {
            this.data = data;
            this.link = link;
        }
    }
}