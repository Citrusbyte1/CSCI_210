/**
 * <h1>Astronomer.java - Represents a famous astronomer known throughout history.</h2>
 * <p><b>Description:</b> Each astronomer is identified by their
 *    name, where born, the most famous theory associated with them, and the
 *    estimated year of their birth.</p>
 * <p><b>Instance variables:</b></p>
 * <ul style="margin-left; 50px;">
 *   <li>name (String) - name of the astronomer</li>
 *   <li>country (String) - country of birth</li>
 *   <li>theory (String) - description of famous theory</li>
 *   <li>born (int) - year born (CE)</li>
 * </ul>
 * @author Chris Merrill
 * @version Module 2, Lab 2
 */

public class Astronomer {

    // Instance variables
    private String name = "";
    private String country = "";
    private String theory = "";
    private int born = 1900;

    // Full constructor
     public Astronomer(String name, String country, String theory, int born) {
        this.name = name;
        this.country = country;
        this.theory = theory;
        this.born = born;
    }

   /**
    * Getter for the name of the astronomer.
    * @return the name of the astronomer.
    */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the astronomer.
     * @param newName the new name to be assigned to the astronomer.
     */
     public void setName(String newName) {
         name = newName;
     }

    /**
     * Getter for th name of the astronomer's country of origin.
     * @return the country of origin
     */
     public String getCountry() {
         return country;
     }

    /**
     * Setter for the country where they were born.
     * @param newCountry the name of the country in which the astronomer was born
     */public void setCountry(String newCountry) {
        country = newCountry;
    }

   /**
    * Getter for the most famous theory the astronomer is most known for developing
    * @return the most famous theory associated with this astronomer
    */
    public String getTheory() {
        return theory;
    }

   /**
    * Setter for the theory most commonly associated with this astronomer
    * @param newTheory name of the theory
    */
    public void setTheory(String newTheory) {
        theory = newTheory;
    }

   /**
    * Getter for the (estimated) year the astronomer was born (CE)
    * @return the year the astronomer was born
    */
    public int getBorn() {
        return born;
    }

   /**
    * Setter for the year the astronomer was born (CE)
    * @param newBorn the birth year of the astronomer
    */
    public void setBorn(int newBorn) {
        born = newBorn;
    }

   /**
    * Takes any Java object, verifies that it is another object of this
    * class, and returns true if all instance variables are the same
    * @return "true" if all instance of parameter as the same as this astronomer.
    */
    @Override
    public boolean equals(Object anObject) {
      if (anObject == this) {
         return true;
      }
        if ((anObject == null) || (getClass() != anObject.getClass())) {
            return false;
        }
        Astronomer anotherAstronomer = (Astronomer) anObject;
        return ((name.equals(anotherAstronomer.name)) &&
                (country.equals(anotherAstronomer.country)) &&
                (theory.equals(anotherAstronomer.theory)) &&
                (born == anotherAstronomer.born));
    }

   /**
    * Returns a string with the astronomer's name, country of origin, most famous
    * theory associated with this astronomer, and year of birth
    * @return a String with all instance variables listed
    */
    public String toString() {
        return "Name: " + name + "  Country: " + country + "  Theory: " + theory + "  Born: " + born;
    }
}