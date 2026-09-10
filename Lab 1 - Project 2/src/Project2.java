import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 {
   public static void main(String[] args) {
      Player[] players = new Player[20];
      int playerCount = 0;

      try {
         Scanner fileScanner = new Scanner(new File("C:\\users\\ohama\\Desktop\\Palomar\\5) Fall 2026\\CSCI 210\\Lab 1 - Project 2\\src\\Players.txt"));

         while (fileScanner.hasNext() && playerCount < players.length) {
            String firstName = fileScanner.next();
            String lastName = fileScanner.next();
            int goals = fileScanner.nextInt();
            int assists = fileScanner.nextInt();

            players[playerCount] = new Player(firstName + " " + lastName, goals, assists);
            playerCount++;
         }

         fileScanner.close();
      } catch (FileNotFoundException exception) {
         System.out.println("Unable to open Players.txt: " + exception.getMessage());
         return;
      }

      for (Player player : players) {
         if (player != null) {
            System.out.println(player.toString());
         }
      }
   }

}
