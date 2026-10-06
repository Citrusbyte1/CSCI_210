/**
 * <h2>EvesSuitors.java - Simulates Princess Eve's suitor-elimination game.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Suitors numbered 1 through n stand in a circle. Starting from suitor
 *   1, every third suitor (counting around the circle, wrapping as
 *   needed) is eliminated, until only one suitor remains.</p>
 * @author Brian Nguyen
 * @version Module 4, Lab 4, Project 1
 */
public class EvesSuitors {

    public static void main(String[] args) {

        runSimulation(4);
        IO.println();
        runSimulation(6);
        IO.println();
        runSimulation(10);
    }

    /**
     * Runs the full elimination simulation for a given number of suitors
     * and prints the result after every elimination.
     */
    private static void runSimulation(int numberOfSuitors) {

        IO.println("Simulation with " + numberOfSuitors + " suitors:");

        // Build the initial circle of suitors, numbered 1 through n
        CircularList<Integer> suitors = new CircularList<>();
        for (int i = 1; i <= numberOfSuitors; i++) {
            suitors.add(i);
        }
        IO.println("Initial list of suitors: " + listToString(suitors));

        // Create a single iterator and keep reusing it -- no restarts and
        // no hasNext() checks are needed, since the list is circular
        CircularList<Integer>.ListIterator iter = suitors.iterator();

        // Eliminate every 3rd suitor until only one remains
        while (suitors.size() > 1) {

            // The suitor currently at the iterator's position counts as
            // "1", so advance two more positions to reach the count of 3
            iter.next();
            iter.next();

            int eliminated = iter.peek();
            iter.remove();

            IO.println("Deleting suitor " + eliminated + ": " + listToString(suitors));
        }

        IO.println("Suitor " + suitors.getFront() + " wins the hand of the princess!");
    }

    /**
     * Builds a plain space-separated String of the suitors in a
     * CircularList, without the "Items in list:" prefix that toString()
     * adds, to match the example format in the assignment.
     */
    private static String listToString(CircularList<Integer> list) {
        StringBuilder result = new StringBuilder();
        CircularList<Integer>.ListIterator iter = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            result.append(iter.next()).append(" ");
        }
        return result.toString().trim();
    }
}
