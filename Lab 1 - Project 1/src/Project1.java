/**
 * <h2>MessageEditor</h2>
 * <p>Demonstrates using a char array as a message buffer by removing,
 * updating, and displaying characters stored within it.</p>
 *
 * <p><b>Problem Statement:</b> Given a message stored as an array of
 * characters, use a series of remove and update operations to edit
 * the message in place, then display the resulting message.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Create a char array named {@code message} and record its
 *       length in {@code count}.</li>
 *   <li>Display the initial contents of {@code message} using
 *       {@code showArray}.</li>
 *   <li>Remove and update characters at specified positions using the
 *       {@code remove} and {@code update} methods, keeping
 *       {@code count} up to date after every removal.</li>
 *   <li>Display the final contents of {@code message} using
 *       {@code showArray}.</li>
 * </ol>
 *
 * @author Brian Nguyen
 * @version Module 2, Exercise 3
 */

public class Project1 {

    public static void main(String[] args) {
        
        char message[] = {'t', 'Q', 'b', ')', '+', 'v', '5', '('} ;

        int count = message.length ;

        count = remove(message, count, 3) ; // Remove the character at index 3
        showArray(message, count);
        update(message, (short) -7, 1) ; // Update the character at index 1 to -7
        count = remove(message, count, 0) ;
        update(message, (short) 44, 4) ;
        count = remove(message, count, 2) ;
        update(message, (short) -1, 1) ;
        count = remove(message, count, count - 1) ;

        //Print the final message
        showArray(message, count) ;
    }

    private static int remove(char array[], int count, int removeIndex) {

        if (count == 0 || removeIndex < 0 || removeIndex >= count) {
            return count ;
        }

        for (int i = removeIndex ; i < count - 1 ; i++ ) {
            array[i] = array[i + 1] ;
        }

        array[count - 1] = '\0' ;
        return count - 1 ;
    }

    private static void update(char array[], short amount, int index) {
        array[index] = ( char ) ( array[ index ] + amount ) ;
    }

    private static void showArray(char array[], int count) {
        System.out.print( "Message: " );
        for (int i = 0 ; i < count ; i++ ) {
            System.out.print( array[ i ] );
        }
        System.out.println() ;
    }
}
