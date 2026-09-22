/**
 * <h2>Project2</h2>
 * <p>Tracks and shows the stats for a girls' soccer team from a text file.</p>
 *
 * <p><b>Problem Statement:</b> Given a .txt  containing a player's
 * first name, last name, goals scored, and assists per line, read
 * the data into an array of {Player} objects and display the
 * resulting roster.</p>
 *
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Create an array capable of holding up to 20 {Player}
 *       objects, and a counter to track how many slots are
 *       filled.</li>
 *   <li>Open {Players.txt} with a {Scanner}. While the file has
 *       more data and the array is not full, read one player's
 *       first name, last name, goals, and assists, use them to
 *       create a {Player} object, and store it in the array.</li>
 *   <li>Close the file once all data has been read. Use a for-each
 *       loop to print every non-null player's information using
 *       {toString}, skipping any empty array slots.</li>
 * </ol>
 *
 * @author Brian Nguyen
 * @version Project 2 - Girls Soccer Team
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 {
   public static void main(String[] args) {
      // Array to hold up to 20 players, plus a count of how many
      // slots are currently filled in
      Player[] players = new Player[20];
      int playerCount = 0;

      try {
         // Open the data file for reading; the Scanner(File)
         Scanner fileScanner = new Scanner(new File("C:\\users\\ohama\\Desktop\\Palomar\\5) Fall 2026\\CSCI 210\\Lab 1 - Project 2\\src\\Players.txt"));
         
         // Read one player's data per iteration, stopping when the
         // file runs out of data / the array becomes full
         while (fileScanner.hasNext() && playerCount < players.length) {
            String firstName = fileScanner.next();
            String lastName = fileScanner.next();
            int goals = fileScanner.nextInt();
            int assists = fileScanner.nextInt();
            
            // Combine first and last name, then create and
            // store the Player object
            players[playerCount] = new Player(firstName + " " + lastName, goals, assists);
            playerCount++;
         }

         fileScanner.close();
      } catch (FileNotFoundException exception) {
         // Stop the program if the file can't be opened
         System.out.println("Unable to open Players.txt: " + exception.getMessage());
         return;
      }

      // Print every filled-in player using toString
      // anything empty is skipped
      for (Player player : players) {
         if (player != null) {
            System.out.println(player.toString());
         }
      }
   }

}
