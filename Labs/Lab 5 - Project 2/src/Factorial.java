/**
 * <h2>Factorial.java - Calculates factorials using a stack.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Outputs the factorials of 0 - 20. Each is computed with a
 *   MyStack&lt;Long&gt; instead of a multiplication loop.</p>
 * @author Brian Nguyen
 * @version Lab 5, Project 2
 */

public class Factorial {
    
    public static void main(String[] args) {
        
        // Print the facotorials of 0 - 20
        for (int i = 0; i <= 20; i++) {

            System.out.println(i + " factorial = " + factorial(i));
        }
    }

    /** Calculates the factorial of a given number using a stack.
     * @param n the number who's factorial we're calculating
     * @return the calculated factorial
     */
    public static long factorial(int n) {

        // Check for invalid inputs
        if(n < 0 || n > 20) {

            return -1L;
        }

        if(n == 0) {

            return 1L;
        }

        // Create a stack to hold the to-be factorials
        MyStack<Long> stack = new MyStack<>();

        // Push 1 - n onto the stack
        for (long number = 1; number <= n; number++) {
            stack.push(number);
        }

        // Multiply the top two nums together and push the result
        // back onto the stack until only one remains (the factorial)
        while (true) {

            //Pop the stack's top
            long a = stack.pop();

            // If the stack is empty, return the factorial
            if (stack.isEmpty()) {
                return a;
            }

            // Stakc isn't empty, so pop the next number and multiply
            // it with the first, then push it back
            long b = stack.pop();

            stack.push(a * b);
        }
    }
}
