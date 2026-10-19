import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * <h2>CarShow.java - Manages a line of cars waiting for the show.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Each car in line is a letter in a Deque of Chars. A random number
 *   of cars is put in line, then the one in the middle of the line is
 *   removed. The cars in front are moved onto a stack to get them out of
 *   the way, then put back into the original order.</p>
 * @author Brian Nguyen
 * @version Lab 6, Project 1
 */

public class CarShow {
    public static void main(String[] args) {
    
        // Line of cars from front to back
        Deque<Character> carLine = new LinkedList<>();
        
        Random random = new Random();
        int numberOfCars = random.nextInt(11) + 10;

        // Add the letters to the back of the line in order
        for (int i = 0; i < numberOfCars; i++) {
            carLine.addLast((char) ('A' + i));
        }

        showLine(carLine);

        removeTargetCar(carLine);

        showLine(carLine);
    }

    // Removes the car in the middle of the line, keeping all of the others in order.
    // The cars in front of it are moved onto a stack while it is removed, then put
    // back on the front of the line.
    static void removeTargetCar(Deque<Character> carLine) {

        // ArrayList used as a stack, the end of the list is the top.
        ArrayList<Character> stack = new ArrayList<>();

        // The position of the target car in line , from 1
        int targetCar = carLine.size() / 2;

        // Move every car in front of the target car off the line and onto the stack
        for (int i = 1; i < targetCar; i++) {
            stack.add(carLine.poll());
        }

        // The target car is now at the front of the line, remove it
        char removedCar = carLine.poll();
        IO.println("Car " + targetCar + " (letter " + removedCar + ") is being sent home.");

        // Pop the cars off the stack, one at a time, putting each back on the
        // front.
        while (!stack.isEmpty()) {
            carLine.offerFirst(stack.removeLast());
        }
    }

    // Displays the number of cars in line, then the letter for each car
    private static void showLine(Deque<Character> carLine) {
        IO.print("There are " + carLine.size() + " cars in line:");
        for (char car : carLine) {
            IO.print(" " + car);
        }
        IO.println();
    }
}
