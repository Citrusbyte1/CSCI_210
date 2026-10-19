/**
 * <h2>DequeArray.java Generic deque implemented using a circular array</h2>
 * <p><b>Description:</b>Definition for a generic,  deque class
 *    implemented using a circular array.</p>
 * <p><b>Instance variables:</b></p>
 * <ul style="margin-left: 25px;">
 *   <li>dequeArray - the array of Objects to hold items in the deque</li>
 *   <li>capacity - size of underlying array, from constructor</li>
 *   <li>front - index of the next position to remove an item from the deque</li>
 *   <li>rear - index of the last item to be placed in the deque (-1 = empty)</li>
 * </ul>
 * @author Brian Nguyen
 * @version Lab 6, Project 6
 */

public class DequeArray<E> {

    /**
     * 1. For the array
     * 2. Size of the array
     * 3. Index of the first item in the deque (-1 if empty)
     * 4. Index of the last item in the deque (-1 if empty)
     * 5. Count of items in the deque
     */
    private E[] dequeArray;
    private int capacity, front = -1, rear = -1, size = 0;

    /**
     * Create an empty queue given the size of the underlying array
     * @param newCapacity length of the underlying circular array
     */
    @SuppressWarnings("unchecked")
    public DequeArray(int newCapacity) {
        this.capacity = newCapacity;
        this.dequeArray = (E[]) new Object[capacity];
    }
}
