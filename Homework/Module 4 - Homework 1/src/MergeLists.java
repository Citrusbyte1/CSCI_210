/**
 * <h2>MergeLists.java - Merge two sorted lists into one.</h2>
 * <p><b>Problem Statement:</b> Create two sorted lists with an unknown size,
 *    then merge them into a single sorted list.</p>
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Create 3 empty LinkedLists for Ints. 2 for holds sorted lists,
 *       and the last to hold the merged result.</li>
 *   <li>Use the populate method to fill the first 2 lists with random,
 *       increasing integers, of different lengths.</li>
 *   <li>Use the merge method to combine the first 2 lists into the
 *       third. Repeatedly compare the front values of each list
 *       and append the smaller one to the merged list, until one of the
 *       two lists runs out, then append whatever remains.</li>
 *   <li>Use the display method to print the contents and size of all
 *       three lists.</li>
 * </ol>
 * @author Brian Nguyen
 * @version Module 4, Homework 1
 */

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class  MergeLists {

    void main() {

        // Create three LinkedLists.  The first and second will hold sorted
        // lists of Integer objects.  The third will be the merged list.

        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> second = new LinkedList<>();
        LinkedList<Integer> sorted = new LinkedList<>();

        // Populate the first and second lists with a sorted list of integers
        populate(first);
        populate(second);

        // Merge the two lists and print display the results
        merge(first, second, sorted);

        System.out.println("The first list's contents:");
        display(first);
        System.out.println("\nThe second list's contents:");
        display(second);
        System.out.println("\nThe merged list's contents:");
        display(sorted);
    }

    // Populate a list with a random number of Integer objects in increasing order
    private static void populate(LinkedList<Integer> list) {
 
        Random random = new Random();
 
        // Add a starting number, 1-10, to the front of the currently empy list
        int firstNumber = random.nextInt(10) + 1;

        list.addFirst(firstNumber);
 
        // Add somewhere between 5 and 15 more numbers, each one is equal to the
        // current last number in the list plus a new random amount, 1-10. Added
        // amount is alwasy pos, therefore it should be increasing.
        int additionalNumbers = random.nextInt(11) + 5;

        for (int i = 0; i < additionalNumbers; i++) {

            int increment = random.nextInt(10) + 1;
            
            int newNumber = list.getLast() + increment;
            
            list.addLast(newNumber);
        }
    }

    // Merge the contents of two lists a third list with a sorted order result.
    private static void merge(LinkedList<Integer> firstList, LinkedList<Integer> secondList,
                              LinkedList<Integer> sortedList) {

        ListIterator<Integer> firstIter = firstList.listIterator();

        ListIterator<Integer> secondIter = secondList.listIterator();
 
        // Grab the first object from each list
        Integer firstValue = firstIter.hasNext() ? firstIter.next() : null;

        Integer secondValue = secondIter.hasNext() ? secondIter.next() : null;
 
        // Take whichever of the two current values is smaller and append it
        // to the merged list, moving only that list's iterator. Stop when
        // at least one list is empty.
        while (firstValue != null && secondValue != null) {

            if (firstValue < secondValue) {

                sortedList.addLast(firstValue);
                
                firstValue = firstIter.hasNext() ? firstIter.next() : null;

            } else {

                sortedList.addLast(secondValue);
                
                secondValue = secondIter.hasNext() ? secondIter.next() : null;
            }
        }
 
        // Since one list in now empty, add back values that were fetched
        // but not yet merged, then append the rest of that list's iterator
        // directly.
        if (firstValue != null) {

            
            sortedList.addLast(firstValue);
            
            while (firstIter.hasNext()) {
            
                sortedList.addLast(firstIter.next());
            }

        } else if (secondValue != null) {
            
            sortedList.addLast(secondValue);
            
            while (secondIter.hasNext()) {
            
                sortedList.addLast(secondIter.next());
            }
        }
    }

    // Display the contents of a linked list
    private static void display(LinkedList<Integer> list) {

        ListIterator<Integer> iter = list.listIterator();
 
        // Print every number on one line, spacced by blanks
        while (iter.hasNext()) {

            IO.print(iter.next() + " ");
        }

        IO.println();
 
        // Print the size of the list, followed by a new line
        IO.println("Size: " + list.size());

        IO.println();
    }
}
