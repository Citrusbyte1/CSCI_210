/**
 * <h2>EvesSuitors.java - Th eEve's suitor elimination game.</h2>
 * <p><b>Description:</b></p>
 * <p style="margin-left: 30px;">
 *   Suitors 1 through 'n' stand in a circle. Starting from suitor
 *   1, every 3rd suitor, wrapping around the circle, is eliminated,
 *   until only one remains.</p>
 * @author Brian Nguyen
 * @version Lab 4, Project 1
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
     * Runs the full elimination for a given number of suitors
     * and prints the result after every elimination.
     */
    private static void runSimulation(int numberOfSuitors) {

        IO.println("Simulation with " + numberOfSuitors + " suitors:");

        // Build the starting circle of suitors, 1 through n
        CircularList<Integer> suitors = new CircularList<>();
        for (int i = 1; i <= numberOfSuitors; i++) {
            suitors.add(i);
        }
        IO.println("Initial list of suitors: " + listToString(suitors));

        // Create a single iterator and keep reusing it
        CircularList<Integer>.ListIterator iter = suitors.iterator();

        // Eliminate every 3rd suitor until only one remains
        while (suitors.size() > 1) {

            // The suitor currently at the iterator's position counts as "1",
            // so move two more positions to get to 3
            iter.next();
            iter.next();

            int eliminated = iter.peek();
            iter.remove();

            IO.println("Deleting suitor " + eliminated + ": " + listToString(suitors));
        }

        IO.println("Suitor " + suitors.getFront() + " wins the hand of the princess!");
    }

    /**
     * Builds a String of the suitors in a CircularList,
     * without the "Items in list:" prefix that added by
     * the toString().
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
