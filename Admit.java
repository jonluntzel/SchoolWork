// Jon Luntzel
// 4/25/17
// CSE 142
// TA: Isidora Vukosav
// Assignment #4
// This program will create an admisssions comparison between two students to decide which
// application is stronger.

import java.util.*;

public class Admit {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      prompt();
      double app1 = processApplicant(1, console);
      double app2 = processApplicant(2, console);
      applicants(app1, app2);
   }
   
   //initiates the first statement before asking for user input
   public static void prompt() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   //asks the user what type of test is being sent
   public static double testScores(int applicant, Scanner console) {
      System.out.println("Information for applicant #" + applicant + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int testType = console.nextInt();
      double testScore = 0;
      if (testType == 1) {
         testScore = SAT(console);
      }
      else {
         testScore = ACT(console);
      }
      return testScore;
   }
   
   //asks the user for ACT scores and converts to general exam score
   public static double ACT(Scanner console) {
      System.out.print("    ACT English? ");
      double english = console.nextInt();
      System.out.print("    ACT math? ");
      double math = 2 * console.nextInt();
      System.out.print("    ACT reading? ");
      double reading = console.nextInt();
      System.out.print("    ACT science? ");
      double science = console.nextInt();
      return (english + math + reading + science) / 1.8;
   }
   
   //asks the user for SAT scores and converts to general exam score
   public static double SAT(Scanner console) {
      System.out.print("    SAT math? ");
      double math = 2 * console.nextInt();
      System.out.print("    SAT critical reading? ");
      double reading = console.nextInt();
      System.out.print("    SAT writing? ");
      double writing = console.nextInt();
      return (math + reading + writing) / 32;
   }
   
   //asks the user for GPA information and converts to general GPA score
   public static double scoreGPA(Scanner console) {
      System.out.print("    overall GPA? ");
      double GPA = console.nextDouble();
      System.out.print("    max GPA? ");
      double max = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double score = (GPA / max) * 100 * console.nextDouble();
      System.out.println("    GPA score = " + round(score));
      System.out.println();
      return score;
   }
   
   //rounds 
   public static double round(double a) {
      return (Math.round(a * 10.0)) / 10.0;
   }
   
   //processes the applicant by calculating the sum of exam and gpa scores
   public static double processApplicant(int applicant, Scanner console) {
      double exam = testScores(applicant, console);
      System.out.println("    exam score = " + round(exam));
      double gpa = scoreGPA(console);
      return exam + gpa;
   }
      
   //compares the applicants scores based on the processed sum
   public static void applicants(double app1, double app2) {
      System.out.println("First applicant overall score  = " + round(app1));
      System.out.println("Second applicant overall score = " + round(app2));
      if (app2 == app1) {
         System.out.print("The two applicants seem to be equal");
      }
      else if (app2 < app1) {
         System.out.print("The first applicant seems to be better");
      }
      else {
         System.out.print("The second applicant seems to be better");
      }
   }
}




