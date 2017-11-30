// Jon Luntzel
// CSE142
// Isidora Vukosav
// 5/16/17
// when given a name and gender by the user, this program produces a graph that shows the
// popularity over time as well as its meaning

import java.awt.*;
import java.io.*;
import java.util.*;

public class BabyNames {
   
   // Global variables for the width between bars, the legend height, and initial year
   public static final int X_WIDTH = 60;
   public static final int Y_HEIGHT = 30;
   public static final int YEAR_INITIAL = 1890;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      Scanner nameFile = new Scanner(new File("names.txt"));
      Scanner meaningFile = new Scanner(new File("meanings.txt"));
      // Introduces the user
      intro();
      // Stores useful information into strings
      String name = name(console);
      String gender = gender(console);
      String data = data(nameFile, name, gender);
      String meaning = data(meaningFile, name, gender );
      // Gives user feedback on what the database found
      if (!data.equals("")) {
         System.out.println(data);
         System.out.println(meaning);
         DrawingPanel p = new DrawingPanel(780, 500 + 2 * Y_HEIGHT);
         Graphics g = p.getGraphics();
         drawGraph(g, data, meaning);
         drawBars(g, data);
      } else {
         System.out.println("\"" + name + "\" not found.");
      }
   }
   
   // Prints a useful introduction for the user to begin as a void return type
   public static void intro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + YEAR_INITIAL + ".");
      System.out.println();
   }
   
   // Takes in a scanner for user input and returns the name of interest
   public static String name(Scanner console)  {
      System.out.print("Name: ");
      return console.next();
   }
   
   // Takes in a scanner for user input and returns the gender of interest
   public static String gender(Scanner console) {
      System.out.print("Gender (M or F): ");
      return console.next().toLowerCase();
   }
   
   // Takes in a scanner for a given file, the name, and gender of interest, and
   // returns a corresponding line with information on the name and gender found in a given file
   public static String data(Scanner file, String name, String gender) {
      while (file.hasNextLine()) {
         String data = file.nextLine();
         Scanner find = new Scanner(data.toLowerCase());
         if (find.next().equals(name.toLowerCase()) && find.next().equals(gender)) {
            return data;
         }
      }
      return "";
   }
   
   // Uses the graphics, data line, and meaning line to produce a graph with legends,
   // dates, and meaning filled in. No return
   public static void drawGraph(Graphics g, String data, String meaning) {
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(0, 0, 780, Y_HEIGHT);
      g.fillRect(0, 500 + Y_HEIGHT, 780, Y_HEIGHT);
      g.setColor(Color.BLACK);
      g.drawLine(0, Y_HEIGHT, 780, Y_HEIGHT);
      g.drawLine(0, 500 + Y_HEIGHT, 780, 500 + Y_HEIGHT);
      g.drawString(meaning, 0, 16);
      int count = -2;
      Scanner find = new Scanner(data);
      while (find.hasNext()) {
         if (count >= 0) {
            g.drawString("" + (YEAR_INITIAL + 10 * count), count * X_WIDTH, 492 + 2 * Y_HEIGHT);
         }
         find.next();
         count++;
      }
   }
   
   // Takes in the graphics object and the data line (popularity) in order to graph bars
   // on the drawing panel that are representative of popularity. No return
   public static void drawBars(Graphics g, String data) {
      Scanner rank = new Scanner(data);
      int level = 0;
      int count = 0;
      int zeroCase = 1;
      rank.next();
      rank.next();
      while (rank.hasNextInt()) {
         level = rank.nextInt();
         if (level == 0) {
            level = 1000;
            zeroCase = 0;
         }
         g.setColor(Color.GREEN);
         g.fillRect(X_WIDTH * count, Y_HEIGHT + level / 2, X_WIDTH / 2, 500 - level / 2);
         g.setColor(Color.BLACK);
         g.drawString("" + zeroCase * level, X_WIDTH * count, Y_HEIGHT + level / 2);
         count++;
         zeroCase = 1;
      }
   }
}