// Jon Luntzel
// 4/30/17
// CSE142
// TA: Isidora Vukosav
// Assignment #5
// This program produces an interactive guessing game that can be played multiple times and
// gives the user his or her statistics.

import java.util.*;

public class Guess {
   // The upper bound global variable sets the top inclusive limit
   public static final int UPPERBOUND = 100;
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      boolean playMore = true;
      int bestGuess = Integer.MAX_VALUE;
      int totalCount = 0;
      int totalGames = 0;
      String yesOrNo = "";
      gameIntro();
      // Allows the user to continue or quit
      while (playMore == true) {
         int guesses = game(console);
         totalCount += guesses;
         bestGuess = Math.min(bestGuess, guesses);
         totalGames++;
         System.out.print("Do you want to play again? ");
         yesOrNo = console.next();
         System.out.println();
         if (yesOrNo.toLowerCase().startsWith("y")) {
            playMore = true;
         }else {
            playMore = false;
         }
      }
      results(bestGuess, totalGames, totalCount);
   }
   
   // Introduces the user to the guessing game with text
   public static void gameIntro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(UPPERBOUND + " and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   // Randomly generates the number to guess and, with the Scanner console, allows the user to 
   // guess. Returns the number of guesses for that game
   public static int game(Scanner console) {
      Random r = new Random();
      int guess = 0;
      int guesses = 0;
      int number = r.nextInt(UPPERBOUND) + 1;
      System.out.println("I'm thinking of a number between 1 and " + UPPERBOUND + "...");
      while (guess != number) {
         System.out.print("Your guess? ");
         guess = console.nextInt();
         if (guess < number) {
            System.out.println("It's higher.");
         }else if (guess > number) {
            System.out.println("It's lower.");
         }
         guesses++;
      }
      System.out.print("You got it right in " + guesses + " guess");
      if (guesses != 1) {
         System.out.println("es");
      }else
         System.out.println();
      return guesses;
   }
   
   // Rounds and returns a double to one decimal place
   public static double round(double number) {
      return (Math.round(number * 10.0)) / 10.0;
   }
   
   // Takes the best guess, total number of games, and total number of guesses to print
   // various statistics such as their best guess
   public static void results(int bestGuess, int totalGames, int totalCount) {
      System.out.println("Overall results:");
      System.out.println("    total games   = " + totalGames);
      System.out.println("    total guesses = " + totalCount);
      System.out.println("    guesses/game  = " + round((1.0 * totalCount)/totalGames));
      System.out.println("    best game     = " + bestGuess);
   }
}
