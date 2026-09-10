/**
 * <h2>Player - a class for representing a girls' soccer player in Project2.java</h2>
 * <p>Represents a single player on a girls' soccer team, tracking her
 * full name along with the number of goals she has scored and the
 * number of assists she has been awarded.</p>
 *
 * <p><b>Instance Variables:</b></p>
 * <ul>
 *   <li>{@string name} - the player's full name (first and last)</li>
 *   <li>{@int goals} - the number of goals the player has scored</li>
 *   <li>{@int assists} - the number of assists the player has been
 *       awarded</li>
 * </ul>
 *
 * @author Brian Nguyen
 * @version Project 2 - Girls Soccer Team
 */

public class Player {
    private String name;
    private int goals;
    private int assists;

    public Player() {
        //Creates a default player with no name, 0 goals, and 0 assists
        name = "none";
        goals = 0;
        assists = 0;
    }

    public Player(String name, int goals, int assists) {
        //Creates a player with the given name, goals, and assists
        this.name = name;
        this.goals = goals;
        this.assists = assists;
    }

    public String getName() {
        //returns the player's name
        return name;
    }

    public void setName(String name) {
        //sets the player's name to the given value
        this.name = name;
    }

    public int getGoals() {
        //returns the player's number of goals
        return goals;
    }

    public void setGoals(int goals) {
        //sets the player's number of goals to the given value
        this.goals = goals;
    }

    public int getAssists() {
        //returns the player's number of assists
        return assists;
    }

    public void setAssists(int assists) {
        //sets the player's number of assists to the given value
        this.assists = assists;
    }

    @Override
    public String toString() {
        //returns a formatted String describing the player, including
        //their name, goals scored, and assists.
        return "Name: " + name + ", Goals: " + goals + ", Assists: " + assists;
    }
}
