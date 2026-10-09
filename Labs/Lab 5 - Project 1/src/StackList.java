/**
 * <h2>MyStack.java - A stack built on an ArrayList.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   MyStack&lt;E&gt; doesn't implement a stack from nothing,
 *   it pushed the work off to the matching methods of an
 *   ArrayList. The end of the ArrayList acts as the top of the
 *   stack.</p>
 * @author Brian Nguyen
 * @version Module 5, Lab 5
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackList<E> {
    
    // Underlying structure for the stack.
    private ArrayList<E> list;

    // A new empty stack.
    public StackList() {

        list = new ArrayList<E>();
    }

    /**
     * Pushes an item onto the top of this stack.
     * @param item will be pushed onto this stack.
     */
    public void push(E item) {

        // Add the item to the top of the stack.
        list.add(item);
    }

    /**
     * Removes the object at the top of this stack and
     * returns that object as the value of this function.
     * @return The object removed from the stack.
     */
    public E pop() {

        // Empty stack check.
        if (list.isEmpty()) {

            throw new EmptyStackException();
        }

        // Remove and return the item at the top of the stack.
        return list.remove(list.size() - 1);
    }

    /**
     * Looks at the object at the top of this stack, doesn't remove it.
     * @return The object at the top of this stack.
     */
    public E peek() {

        // Empty stack check.
        if (list.isEmpty()) {

            throw new EmptyStackException();
        }

        // Return the item at the top of the stack.
        return list.get(list.size() - 1);
    }

    //Check if this stack is empty.
    public boolean isEmpty() {

        return list.isEmpty();
    }

    /**
     * Finds how far an object is from the top. The item at the top is at
     * distance 1, the one below it is at distance 2, etc. If
     * it appears multiple times, the closest to the top is used.
     * @param o the object to look for
     * @return the distance from the top of the stack.  -1 if the
     *         object isn't in the stack
     */

    public int search(Object o) {

        // finds the appearance closest to the top of the stack
        int index = list.lastIndexOf(o);

        if (index == -1) {

            return -1;
        }

        // Convert a position counted from the bottom into a distance
        // counted from the top
        return list.size() - index;
    }

}

// Testing the stack.
// public static void main(String[] args) {
//     StackList<String> stack = new StackList<>();
//     stack.push("Hello");
//     stack.push("World");
//     System.out.println(stack.pop()); // Output: World
//     System.out.println(stack.peek()); // Output: Hello
// }