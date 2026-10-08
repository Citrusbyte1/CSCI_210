/**
 * <h2>UnderflowException.java - Thrown when a stack or queue remove operation is performed on an empty queue.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 25">constructors in this class set the exception
 *     message used by getMessage() for array underflow.</code></p>
 * @author Chris Merrill
 * @version Modules 5 & 6, Demonstration
 */

public class UnderflowException extends RuntimeException {

    /**
     * Sets the default exception message for getMessage()
     */
    UnderflowException() {
        super("No items in queue or stack to remove.");
    }

    /**
     * Sets the specified exception message for getMessage()
     */
    UnderflowException(String message) {
        super(message);
    }
}