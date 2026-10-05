/**
 * <h2>CircularTester.java - Demonstrate the new CircularList class</h2>
 * <p><b>Problem Statement:</b> The CircularTester class starts with the IteratorDemo
 *    from the prior module, then makes the list circular, meaning that the last Node
 *    in the list references the first node in the list.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol style="margin-left: 40px;">
 *   <li>Start with the LinkedList from the IteratorDemo program</li>
 *   <li>Make the mods defined in Exercise #1 of this module.</li>
 *   <li>In main, start with the IteratorDemo, changing the LinkedList
 *       to a CircularList.</li>
 *   </li>...</li>
 * </ol>
 * <p><b>Discussion Items:</b></p>
 * <ul style="margin-left: 30px;">
 *    <li>The mods to add a "size" variable weren't that bad.</li>
 *    <li>The mods required to make the list "circular" were extensive.</li>
 * </ul>>
 * @author Chris Merrill
 * @version Module 4, Exercise #1
 */

public class CircularTester {

    void main() {

        // Create a new linked list and an iterator on that list
        CircularList<String> studentList = new CircularList<>();
        CircularList<String>.ListIterator iterator = studentList.iterator();

        // Add several students to the list in random lexicographic order,
        // then print the list
        studentList.addFront("Julia");
        studentList.addFront("Franco");
        studentList.addFront("Harold");
        studentList.addFront("Michelle");
        studentList.addFront("Mei");
        studentList.addFront("Xavier");
        studentList.addFront("Alicia");
        studentList.addFront("Riki");
        System.out.println("Added several students in unsorted order");
        printList(studentList);

        // Move the current position to the third student in the list and remove
        // that student, then reprint the list
        iterator.restart();
        iterator.next();
        iterator.next();
        System.out.println("Will remove the third node for " + iterator.peek());
        iterator.remove();
        printList(studentList);

        // Add the students "Fatima", "Dexter", and a second "Riki"
        studentList.addFront("Fatima");
        studentList.addFront("Dexter");
        studentList.addFront("Riki");
        System.out.println("Added Fatima, Dexter, and a second Riki");
        printList(studentList);

        // Remove all students named "Riki"
        while (studentList.contains("Riki")) {
            iterator.restart();
            for (int i = 0; i < studentList.size(); i++) {
                if (iterator.peek().equals("Riki")) {
                    iterator.remove();
                    break;
                } else {
                    iterator.next();
                }
            }
        }

        // Made it all the way through the list without finding anyone named Riki.
        System.out.println("Removed all students named Riki");
        printList(studentList);

        // Start removing students at random without resetting the iterator
        System.out.println("Removing Michelle");
        iterator.restart();
        while (true) {
            if (iterator.peek().equals("Michelle")) {
                iterator.remove();
                break;
            }
            iterator.next();
        }
        printList(studentList);

        System.out.println("Removing Dexter");
        while (true) {
            if (iterator.peek().equals("Dexter")) {
                iterator.remove();
                break;
            }
            iterator.next();
        }
        printList(studentList);

        System.out.println("Removing Alicia");
        while (true) {
            if (iterator.peek().equals("Alicia")) {
                iterator.remove();
                break;
            }
            iterator.next();
        }
        printList(studentList);

        System.out.println("Removing Julia");
        while (true) {
            if (iterator.peek().equals("Julia")) {
                iterator.remove();
                break;
            }
            iterator.next();
        }
        printList(studentList);

        System.out.println("Removing Harold");
        while (true) {
            if (iterator.peek().equals("Harold")) {
                iterator.remove();
                break;
            }
            iterator.next();
        }
        printList(studentList);

        System.out.println("Removing Fatima");
        while (true) {
            if (iterator.peek().equals("Fatima")) {
                iterator.remove();
                break;
            }
            iterator.next();
        }
        printList(studentList);

    } // end of main

    /**********************************************************************
     * printList() prints the contents of a list passed as a parameter.  It
     * uses its own iterator, so any iterators in the invoking routine
     * will not be affected.
     **********************************************************************/
    private static <E extends Comparable<E>> void printList(CircularList<E> list) {

        System.out.print("The list of students now includes: \n   ");
        CircularList<E>.ListIterator iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
    }
}
