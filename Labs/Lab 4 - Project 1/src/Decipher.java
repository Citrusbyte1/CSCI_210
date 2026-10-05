import java.util.LinkedList;
import java.util.ListIterator;

/**
 * <h2>Decipher.java - Decodes a hidden message from a LinkedList of characters.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Loads a scrambled String into a java.util.LinkedList of Characters,
 *   repairs two characters using the iterator's set() method (moving
 *   forward with next() and backward with previous()), then reveals a
 *   hidden message by printing every third character starting at a
 *   given position.</p>
 * @author Brian Nguyen
 * @version Module 4, Lab 4, Part 2
 */
public class Decipher {

    public static void main(String[] args) {

        // 1. Create a LinkedList of Characters and add every character of
        // the scrambled String to the end of the list
        LinkedList<Character> message = new LinkedList<>();
        String scrambled = "ZekqmDXJGfaos3MPaCl8o1Lm.9eXEt4ss=C#D";
        for (int i = 0; i < scrambled.length(); i++) {
            message.add(scrambled.charAt(i));
        }

        // 3. Create a ListIterator over the list
        ListIterator<Character> iter = message.listIterator();

        // 4. Move forward with next() until the '#' is reached
        char current = ' ';
        while (current != '#') {
            current = iter.next();
        }

        // 5. Replace the '#' with '!'
        iter.set('!');

        // 6. Move backward with previous() until the capital 'M' is reached
        current = ' ';
        while (current != 'M') {
            current = iter.previous();
        }

        // 7. Replace the 'M' with a blank
        iter.set(' ');

        System.out.println("List after both repairs: " + message);

        // 8. Re-initialize the iterator, starting at position (index) 6
        iter = message.listIterator(6);

        // 9. From that position, print every third character returned by
        // the iterator until the end of the list is reached
        System.out.print("Decoded message: ");
        int count = 0;
        while (iter.hasNext()) {
            char c = iter.next();
            count++;
            if (count % 3 == 0) {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}
