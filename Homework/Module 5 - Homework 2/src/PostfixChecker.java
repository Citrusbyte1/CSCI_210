/**
 * <h2>PostfixChecker.java - Checks if expressions are valid in postfix notation.</h2>
 *
 * <p><b>Problem Statement:</b> Check if integer expressions written in postfix
 *    notation are valid. Display a clear message instead of a result when it
 *    isn't valid.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Split expression into tokens, separated by spaces.</li>
 *   <li>Process from left to right, using a MyStack&lt;Long&gt;:
 *     <ul>
 *       <li>If the token is an integer, push it onto the stack.</li>
 *       <li>If the token is one of the operators, + - * / %, pop the right
 *           then the left, apply and display the operation, and push the
 *           result back onto the stack.</li>
 *       <li>Anything else is an invalid operator or operand.</li>
 *     </ul>
 *   </li>
 *   <li>After the last token, pop the final value. It is the result, as long
 *       as nothing else is left on the stack.</li>
 *   <li>Report an error, instead of a result, if an operator has too few
 *       operands, if operands are left over, if a token is invalid, or if
 *       the divisor of a division or modulo is 0.</li>
 * </ol>
 *
 * @author Brian Nguyen
 * @version Module 5, Homework 1
 */

public class PostfixChecker {

    // Allowed operators in postfix
    private static final String OPERATORS = "+-*%/";

    private static void main(String[] arge) {

        // Expression to check
        String[] expressions = {

            "100 10 / 3 /",
            "4 81 9 / *",
            "1 2 3 4 5 * * * *",
            "3 43 36 2 / * 18 3 / + -",
            "2 3 8 * + 4 48 4 2 + / 6 * + -",
            "1 2 3 4 + +",
            "1 2 + 3 ? 4",
            "1 2 A",
            "3 4 ( 8 4 /"
        };

        for (String expression : expressions) {

            evaluate(expression);

            IO.println();
        }

    }

    /**
     * Evaluates a postfix expression, displaying each operation as performed,
     * followed by either the result or an error message.
     *
     * @param postfix the postfix expression, with its operands and
     *                operators separated by spaces
     * @return the value of the expression, or null if the expression
     *         isn't valid
     */

    public static Long evaluate(String postfix) {

        IO.println("Postfix: " + postfix.trim());
        return null;
    }
}
