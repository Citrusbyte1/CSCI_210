/**
 * <h2>Decipher.java - Decodes a hidden message from a LinkedList.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Loads a scrambled String, repairs two characters using the iterator's
 *   set() method ( moving forward with next() and backward with previous() ),
 *   then reveals the secret message by printing every third character
 *   starting at a given position.</p>
 * @author Brian Nguyen
 * @version Lab 4, Project 2
 */

import java.util.LinkedList;
import java.util.ListIterator;

public class Decipher {

    public static void main(String[] args) {

        // Create a LinkedList and add the scrambled message, one char at a time.
        LinkedList<Character> message = new LinkedList<>();

        String scrambled = "ZekqmDXJGfaos3MPaCl8o1Lm.9eXEt4ss=C#D";

        for (int i = 0; i < scrambled.length(); i++) {

            message.add(scrambled.charAt(i));
        }

        // ListIterator for the list.
        ListIterator<Character> iter = message.listIterator();

        // Move forward with next() until the '#'
        char current = ' ';

        while (current != '#') {

            current = iter.next();
        }

        // Replace '#' with '!'
        iter.set('!');

        // Go backwards with previous() until 'M'
        current = ' ';

        while (current != 'M') {

            current = iter.previous();
        }

        // Replace the 'M' with blank
        iter.set(' ');

        IO.println("List after both changes: " + message);

        // Re-initialize the iterator starting at index 6
        iter = message.listIterator(6);

        // Print every third character until the end of the list
        IO.print("Decoded message: ");

        int count = 0;

        while (iter.hasNext()) {

            char c = iter.next();

            count++;

            if (count % 3 == 0) {

                IO.print(c);
            }
        }
        
        IO.println();
    }
}
