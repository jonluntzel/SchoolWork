// Jon Luntzel
// 5/23/17
// CSE 142
// TA: Isidora Vukosav
// Assignment #7
// Determines personality type from an input file on four dimensions and produces
// an output file logging information

import java.io.*;
import java.util.*;

public class Personality {
   // Convenient global variable for integer that occurs frequently
   public static final int DIMENSIONS = 4;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      introduction();
      System.out.print("input file name? ");
      Scanner input = new Scanner(new File(console.next()));
      System.out.print("output file name? ");
      PrintStream output = new PrintStream(new File(console.next())); 
      // Empties arrays and produces the output file
      while(input.hasNextLine()) {
         int[] bResponse = new int[DIMENSIONS];
         int[] noResponse = new int[DIMENSIONS];
         output.println(lineWriter(input, bResponse, noResponse));
      }
   }
   
   // Introduces the user to the personality program
   public static void introduction() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }

   // Takes in a file scanner and two arrays, for 'B' responses and '-' responses, in order
   // to return a string that is output text 
   public static String lineWriter(Scanner input, int[] bResponse, int[] noResponse) {
      String name = input.nextLine();
      String line = input.nextLine().toUpperCase();
      int indicator = 0;
      for (int i = 0; i < 70; i++) {
         if (line.charAt(i) == 'B') {
            // This formula sorts the questions into their respective dimensions
            bResponse[(i % 7) / 2 + (i % 7) % 2]++;
         } else if (line.charAt(i) == '-') {
            noResponse[(i % 7) / 2 + (i % 7) % 2]++;
         }
      }
      int[] percent = percentCalculator(bResponse, noResponse);
      return name + ": " + Arrays.toString(percent) + " = " + personalityType(percent);
   }

   // By using the 'B' and '-' array count for each dimension, calculates and stores the percent
   // of 'B' responses into an integer array
   public static int[] percentCalculator(int[] bResponse, int[] noResponse) {
      int[] percent = new int[DIMENSIONS];
      percent[0] = (int) Math.round(100 * bResponse[0] / (0.0 + 10 - noResponse[0]));
      for (int i = 1; i < DIMENSIONS; i++) {
         percent[i] = (int) Math.round(100 * bResponse[i] / (0.0 + 20 - noResponse[i]));
      }
      return percent;
   }

   // By taking in an array holding percent values for each dimension as a parameter,
   // determines and returns personality type as a string
   public static String personalityType(int[] percent) {
      String type = "";
      String[] DIMENSION_1 = {"E", "S", "T", "J"};
      String[] DIMENSION_2 = {"I", "N", "F", "P"};
      for (int i = 0; i < DIMENSIONS; i++) {
         if (percent[i] < 50) {
            type += DIMENSION_1[i];
         } else if (percent[i] > 50) {
            type += DIMENSION_2[i];
         } else {
            type += "X";
         }
      }
      return type;
   }
}