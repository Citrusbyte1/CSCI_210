import java.util.ArrayList;

/**
 * AstronomerDemo.java - Demonstrates using an ArrayList of Astronomer objects,
 * including adding, inserting, searching, replacing, removing, and clearing
 * elements.
 *
 * @author Brian Nguyen
 * @version Module 2, Lab 2
 */

public class AstronomerDisplay {

    public static void main(String[] args) {
        // Create ArrayList w/ capacity of 3
        ArrayList<Astronomer> astronomerList = new ArrayList<>(3);

        // create the 6 Astronomer objects
        Astronomer aristotle  = new Astronomer("Aristotle",  "Greece",  "Geocentrism",      -384);
        Astronomer copernicus = new Astronomer("Copernicus", "Poland",  "Heliocentrism",    1473);
        Astronomer kepler     = new Astronomer("Kepler",     "Germany", "Planetary Motion", 1571);
        Astronomer newton     = new Astronomer("Newton",     "England", "Gravity",          1643);
        Astronomer einstein   = new Astronomer("Einstein",   "Germany", "Relativity",       1879);
        Astronomer hawking    = new Astronomer("Hawking",    "England", "Black Holes",      1942);

        // add the first three astronomers to the list
        astronomerList.add(aristotle);
        astronomerList.add(copernicus);
        astronomerList.add(kepler);

        // insert Newton at index 1
        astronomerList.add(1, newton);
        
        showAstronomers(astronomerList);

        // Find Kepler's index and set it to an int
        int index = astronomerList.indexOf(kepler);
        IO.println("\nIndex of Kepler: " + index);

        // replace the astronomer at index 2 with Hawking
        astronomerList.set(2, hawking);

        // remove Copernicus and Newton
        astronomerList.remove(copernicus);
        astronomerList.remove(newton);

        showAstronomers(astronomerList);

        System.out.println(astronomerList);

        // clear the list
        astronomerList.clear();

        // trim the list to size 0
        astronomerList.trimToSize();

        System.out.println(astronomerList); 
    }

    private static void showAstronomers(ArrayList<Astronomer> list) {
        IO.println("Astronomers:");
        for (Astronomer astronomer : list) {
            IO.println(astronomer.getName() + " from " + astronomer.getCountry() +
                    ", known for " + astronomer.getTheory() + ", born in " + astronomer.getBorn());
        }
    }
}
