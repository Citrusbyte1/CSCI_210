import java.util.LinkedList;        // Used as a stack
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * <h2>InfixToPostfixWithParens.java - Converts an infix string to a postfix string</h2>
 * <p><b>Description:</b> Asks the user to enter a string of operands and operators
 *    in infix notation, then converts that string to another in postfix notation</p>
 * <p>Notes on usage:</p>
 * <ul style="margin-left: 25px;">
 *   <li>Operators are + - * / % ( and )</li>
 *   <li>Operands must start with a number</li>
 *   <li>Operands and operators must be separated by a space</li>
 * </ul>
 * <p style="margin-left: 25px;">Note:  Uses an inner exception class SyntaxErrorException</p>
 * <p style="margin-left: 25px;">Note:  Instead of Java's Stack, use a LinkedList as a stack</p>
 * @author Koffman & Wolfgang w/changes by Chris Merrill
 * @version textbook: 2E, Class Module 5, Demonstration
 */

public class InfixToPostfixWithParens {

    // Data variables and constant
    private LinkedList<Character> operatorStack;                      // stack of operators in decreasing precedence
    private static final String OPERATORS = "+-*%/()";                // valid operators
    private static final int[] PRECEDENCE = {1, 1, 2, 2, 2, -1, -1};  // precedence of operators in OPERATORS
    private StringBuilder postfix;                                    // the resulting postfix string

    void main() {

        InfixToPostfixWithParens inToPost = new InfixToPostfixWithParens();
        String infix = "";
        Scanner keyboard = new Scanner(System.in);

        // Print instructions on the console
        System.out.println("Valid operators are +, -, *, /, and %");
        System.out.println("Operands should be whole numbers");
        System.out.println("Use parenthesis to override operator precedence");
        System.out.println("Separate operators, operands, and parenthesis by spaces");
        System.out.println("    Example: ( ( 1 + 2 ) * 3 / ( 6 - 5 ) ) \n");

        while (true) {
            System.out.print("Enter an infix expression: ");
            infix = keyboard.nextLine();

            // If no entry, then stop
            if (infix.isEmpty())
                System.exit(0);

            try {
                IO.println("Infix expression " + infix + " converts to: " + inToPost.convert(infix));
             } catch (SyntaxErrorException e) {
                 IO.println("  Error: " + e.getMessage());
             }

             System.out.println();
        }
    }

    public String convert(String infix) throws SyntaxErrorException {

        operatorStack = new LinkedList<>();
        postfix = new StringBuilder();

        String[] tokens = infix.split("\\s+");         // split infix string into individual tokens
        try {
            for (String nextToken : tokens) {                // next operator or operand in infix string

                char firstChar = nextToken.charAt(0);
                IO.println("Next token is: " + firstChar);

                // Is it an operand?  If so, just add it to the postfix string
                try {
                    Integer.parseInt(nextToken);
                    postfix.append(nextToken);
                    postfix.append(' ');
                    showResults("Appending: " + nextToken);
                    continue;
                }
                catch (NumberFormatException e) {
                    if (firstChar >= '0' && firstChar <= '9') {
                        throw new SyntaxErrorException("Invalid number: " + nextToken);
                    }
                }

                // Is it an operator.  If so it must be 1 character.
                if (nextToken.length() != 1) {
                    throw new SyntaxErrorException("Invalid operand or operator: " + nextToken);
                }

                // Is it a valid operator?
                if (!isOperator(firstChar)) {
                    throw new SyntaxErrorException("Unexpected operator encountered: " + firstChar);
                }

                // Add operator onto stack or process if same priority as current top of stack
                processOperator(firstChar);

            } // end of "for" loop

            // Pop any remaining operators and append then to the postfix String
            while (!operatorStack.isEmpty()) {
                char op = operatorStack.pop();
                showResults("Popping: " + op);

                // Any '(' on the stack doesn't have an opening parenthesis
                if (op == '(')
                    throw new SyntaxErrorException("Unmatched opening parenthesis");
                postfix.append(op);
                postfix.append(' ');
                showResults("Appending: " + op);
            }

            // operator stack should be empty and infix string has been processed, so return the result
            return postfix.toString();

        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    // Method to process the operators
    private void processOperator(char op) {

        if (operatorStack.isEmpty() || op == '('){
            operatorStack.push(op);
            showResults("Pushing: " + op);
        } else {

            // Peek at the operator stack and let topOp be the top operator
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
                showResults("Pushing: " + op);
            }
            else {

                // Pop all stacked operators with equal or higher precedence than op
                // If closing paren, then process all operators until reaching
                // the opening paren.)
                while (!operatorStack.isEmpty() && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();

                    // If processing '(', then remove from operator stack and stop
                    if (topOp == '(') {
                        // Found a matching "(", so exit this while loop
                        showResults("Reached ), popped: " + "(");
                        break;
                    }

                    // Otherwise push this operator onto the stack and process next item
                    postfix.append(topOp);
                    postfix.append(' ');
                    showResults("Popping and Appending " + topOp);
                    if (!operatorStack.isEmpty()) {
                        // Reset topOp
                        topOp = operatorStack.peek();
                    }
                }

                // Either the stack is empty or the current operator precedence is greater
                // than the top of the stack operator precedence.
                if (op != ')') {
                    operatorStack.push(op);
                    showResults("Pushing: " + op);
                }
            }
        }
    }

    // Determine whether the character is an operator
    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    // Determine the precedence of an operator
    private int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    // Inner exception class thrown when invalid infix string is entered
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    // Display action, current postfix message, and stack
    public void showResults(String action) {
        IO.println(action);
        IO.print("   Postfix: " + postfix + "   Operators: ");
        operatorStack.forEach(c -> IO.print(c.toString() + " "));
        IO.println("\n");
    }
}