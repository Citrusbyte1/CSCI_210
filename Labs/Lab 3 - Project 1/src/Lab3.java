/**
 * <h2>Lab3.java - Add methods to make our LinkedList look more like a List.</h2>
 * <p><b>Problem Statement:</b> Add the add(E), add(int, E), remove(int), and remove(Object).  Also
 *    change a few methods to use iterators.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol style="margin-left: 40px;">
 *   <li>Start with the final version of the LinkedList class from the last exercise.</li>
 *   <li>Add "add(E)" and "add(int, E) methods.</li>
 *   <li>Add "remove(Object)" and remove(int) methods using an iterator.</li>
 *   <li>Add a "set(E)" method using an iterator.</li>
 *   <li>Change the "size" and "indexOf" methods to use iterators.</li>
 *   <li>Add and remove words to make a famous quote by Thomas Edison:
 *       "I failed my way to success."</li>
 * </ol>
 * @author Brian Nguyen
 * @version Module 3, Lab
 */

public class Lab3 {

    public static void main(String[] args) {

        // Create a linked list of Strings.  Add a few words, remove some of them,
        // then print the final message.
        LinkedList<String> message = new LinkedList<>();
        message.add("failure");
        message.add("your");
        message.add("electricity");
        message.add("to");
        message.set(5, "generics");
        message.remove(1);
        message.add(0, "failed");
        message.add("- Thomas");
        message.add(4, "success.");
        message.add(0, "light");
        message.remove("electricity");
        message.add(-1, "light");
        message.set(0, "I");
        message.set(2, "my");
        message.add(3, "way");
        message.remove("failure");
        message.add("Edison");

        // Print the message using an iterator
        printMessage("Final Message:", message);
    }

    // Show what the prior statement did and print the resulting message
    private static <E> void printMessage(String heading, LinkedList<E> list) {
        System.out.printf("%-30s: ", heading);
        LinkedList<E>.ListIterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}