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

    private static void main(String[] args) {

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
        
        if (postfix.trim().isEmpty()) {
            IO.println("Empty expression.");
        }

        //splits the expression into tokens at the spaces.
        String[] tokens = postfix.trim().split("\\s+");

        //From Lab 5
        MyStack<Long> stack = new MyStack<>();

        for (String token : tokens) {

            //An int is an operand, just push it to the stack
            Long operand = parseOperand(token);

            if (operand != null) {

                stack.push(operand);

                continue;
            }

            //Anything that isn't an int is an operator
            if (!isOperator(token)) {

                return error("Invalid operator: " + token);
            }

            char operator = token.charAt(0);

            // Pop the right and left operands from the stack
            if (stack.isEmpty()) {

                return error("Too few operands for operator: " + operator);
            }

            long right = stack.pop();

            if (stack.isEmpty()) {

                return error("Too few operands for operator: " + operator);
            }

            long left = stack.pop();

            // Division by 0 is an error
            if ((operator == '/' || operator == '%') && right == 0) {

                return error("Division by 0: " + left + " " + operator + " " + right);
            }

            // Do the operation
            long result;

            try {

                result = switch (operator) {

                    case '+' -> Math.addExact(left, right);
                    case '-' -> Math.subtractExact(left, right);
                    case '*' -> Math.multiplyExact(left, right);
                    case '/' -> Math.divideExact(left, right);
                    default  -> left % right;
                };

            } catch (ArithmeticException e) {

                return error("Result too large: " + left + " " + operator + " " + right);
            }

            //Display it, then push the result back onto the stack
            IO.println(left + " " + operator + " " + right + " = " + result);
            stack.push(result);
        }

        // The last value left on the stack is the answer, but only if it is the
        // only value left. Otherwise there were too many operands.
        long finalValue = stack.pop();
        if (!stack.isEmpty()) {

            return error("Too many operands left on the stack");
        }

        IO.println("Result: " + finalValue);
        return finalValue;
    }

    // Displays an error message and returns null if the expression isn't valid.
    private static Long error(String message) {

        IO.println("Error: " + message);

        return null;
    }

    // Homework 
    private static Long parseOperand(String token) {

        try {

            return Long.parseLong(token);

        } catch (NumberFormatException e) {

            return null;
        }
    }

        private static boolean isOperator(String token) {
        
        return token.length() == 1 && OPERATORS.indexOf(token.charAt(0)) != -1;
    }
}
