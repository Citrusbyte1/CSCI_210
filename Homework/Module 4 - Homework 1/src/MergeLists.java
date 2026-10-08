import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

/**
 * <h2>MergeLists.java - Merge two sorted lists into a single sorted list.</h2>
 * <p><b>Problem Statement:</b> Create two sorted lists of unknown size, then merge
 *    them into a single sorted list.</p>
 * <p><b>Algorithm:</b></p>
 *
 *                   <fill in this detail>
 *
 * @author <your name here>
 * @version Module 4, Homework 1
 */

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

                     // complete this method
    }

    // Merge the contents of two lists a third list so that the resulting list is sorted.
    private static void merge(LinkedList<Integer> firstList, LinkedList<Integer> secondList,
                              LinkedList<Integer> sortedList) {

                     // complete this method
    }

    // Display the contents of a linked list
    private static void display(LinkedList<Integer> list) {

                     // complete this method
    }
}