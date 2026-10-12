/**
 * <h2>PostfixEval.java - Evaluates expressions written in postfix notation.</h2>
 *
 * <p><b>Problem Statement:</b> Evaluate integer expressions written in postfix
 *    notation using a stack. Display each operation as it is performed, and
 *    display a clear message instead of a result when an expression isn't
 *    valid.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Split the expression into tokens, which are separated by spaces.</li>
 *   <li>Process the tokens from left to right, using a MyStack&lt;Long&gt;:
 *     <ul>
 *       <li>If the token is an integer, push it onto the stack.</li>
 *       <li>If the token is one of the operators + - * / %, pop the right
 *           operand, then the left operand, apply the operator, display the
 *           operation, and push the result back onto the stack.</li>
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
 * @version Module 5, Homework 5
 */
public class PostfixEval {

    // The operators which are allowed in a postfix expression
    private static final String OPERATORS = "+-*/%";

    public static void main(String[] args) {

        // The expressions to evaluate. The last four are not valid.
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
     * Evaluates a postfix expression, displaying each operation as it is
     * performed, followed by either the result or an error message.
     *
     * @param postfix the postfix expression, with its operands and
     *                operators separated by spaces
     * @return the value of the expression, or null if the expression
     *         isn't valid
     */
    public static Long evaluate(String postfix) {

        IO.println("Postfix: " + postfix.trim());

        if (postfix.trim().isEmpty()) {
            return error("The expression is empty");
        }

        // ADAPTED from InfixToPostfixWithParens.java (convert method): splits the
        // expression into tokens at the spaces. trim() was added so that leading
        // spaces don't create an empty first token.
        String[] tokens = postfix.trim().split("\\s+");

        // The stack of operands (and results) waiting for an operator
        MyStack<Long> stack = new MyStack<>();      // MyStack is the unchanged class from Lab 5

        for (String token : tokens) {

            // An integer is an operand, so just push it onto the stack
            Long operand = parseOperand(token);
            if (operand != null) {
                stack.push(operand);
                continue;
            }

            // Anything which isn't an integer must be an operator
            if (!isOperator(token)) {
                return error("Invalid operator or operand: " + token);
            }
            char operator = token.charAt(0);

            // Pop the right operand (the top of the stack) first, then the left one
            if (stack.isEmpty()) {
                return error("Not enough operands for the operator " + operator);
            }
            long right = stack.pop();

            if (stack.isEmpty()) {
                return error("Not enough operands for the operator " + operator);
            }
            long left = stack.pop();

            // Dividing by zero (or taking a remainder by zero) isn't allowed
            if ((operator == '/' || operator == '%') && right == 0) {
                return error("Division or modulo by zero: " + left + " " + operator + " " + right);
            }

            // Perform the operation. The "exact" methods throw an exception
            // instead of silently wrapping around if the result is too big.
            long result;
            try {
                result = switch (operator) {
                    case '+' -> Math.addExact(left, right);
                    case '-' -> Math.subtractExact(left, right);
                    case '*' -> Math.multiplyExact(left, right);
                    case '/' -> Math.divideExact(left, right);
                    default  -> left % right;                  // '%'
                };
            } catch (ArithmeticException e) {
                return error("Result too large: " + left + " " + operator + " " + right);
            }

            // Display the operation, then push its result back onto the stack
            IO.println(left + " " + operator + " " + right + " => " + result);
            stack.push(result);
        }

        // The last value left on the stack is the answer, but only if it is the
        // only value left. Otherwise there were too many operands.
        long finalValue = stack.pop();
        if (!stack.isEmpty()) {
            return error("Too many operands left on the stack");
        }

        IO.println("Result is " + finalValue);
        return finalValue;
    }

    // Displays an error message and returns null, so that evaluate() can
    // display the error and give up in a single "return" statement
    private static Long error(String message) {
        IO.println("Error: " + message);
        return null;
    }

    // Converts a token to a number, or returns null if it isn't an integer.
    // ADAPTED from InfixToPostfixWithParens.java (convert method), which also
    // uses a try/catch of NumberFormatException to decide whether a token is
    // an operand.
    private static Long parseOperand(String token) {
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Determines whether a token is one of the valid operators.
    // ADAPTED from the isOperator method of InfixToPostfixWithParens.java
    // (it checks a single character against a String of valid operators).
    private static boolean isOperator(String token) {
        return token.length() == 1 && OPERATORS.indexOf(token.charAt(0)) != -1;
    }
}