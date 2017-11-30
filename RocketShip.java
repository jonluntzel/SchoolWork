// Jon Luntzel
// 4/11/17
// CSE 142
// TA: Isidora Vukosav
// Assignment #2
// This class creates a scalable rocket.

public class RocketShip {
   // Allows for flexible size adjustment to the rocket
   public static final int SCALE = 3;
   public static void main(String[] args) {
      exhaustNose();
      body();
      body();
      segment();
      exhaustNose();
   }
   
   // Constructs the triangle for the nose and exhaust
   public static void exhaustNose() {
      for (int line = 1; line <= 2 * SCALE - 1; line++) {
         for (int space = 0; space < 2 * SCALE - line; space++) {
            System.out.print(" ");
         }
         for (int slash = 0; slash < line; slash++) {
            System.out.print("/");
         }
         System.out.print("**");
         for (int backSlash = 0; backSlash < line; backSlash++) {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   
   // Creates the horizontal line that appears multiple times
   public static void segment() {
      System.out.print("+");
      for (int i = 0; i < 2 * SCALE; i++) {
         System.out.print("=");
         System.out.print("*");
      }
      System.out.println("+");
   }
   
   // Makes the upward-facing triangular section of the rocket body 
   public static void midUp() {
      for (int line = 1; line <= SCALE; line++) {
         System.out.print("|");
         for (int fill = 0; fill < SCALE - line; fill++) {
            System.out.print(".");
         }
         
         for (int tri = 0; tri < line; tri++) {
            System.out.print("/\\");
         }
        
         for (int fill = 0; fill < 2 * (SCALE - line); fill++) {
            System.out.print(".");
         }
         
         for (int tri = 0; tri < line; tri++) {
            System.out.print("/\\");
         }
         
         for (int fill = 0; fill < SCALE - line; fill++) {
            System.out.print(".");
         }
         
         System.out.println("|");
      }
   }
   
   // Makes the downward-facing triangular section of the rocket body 
   public static void midDown() {
      for (int line = 1; line <= SCALE; line++) {
         System.out.print("|");
         for (int fill = 0; fill < line - 1; fill++) {
            System.out.print(".");
         }
         
         for (int v = 0; v < SCALE + 1 - line; v++) {
            System.out.print("\\/");
         }
         
         for (int fill = 0; fill < 2 * (line - 1); fill++) {
            System.out.print(".");
         }
         
         for (int v = 0; v < SCALE + 1 - line; v++) {
            System.out.print("\\/");
         }
         
         for (int fill = 0; fill < line - 1; fill++) {
            System.out.print(".");
         }
         
         System.out.println("|");
      }
   }
   public static void body() {
      segment();
      midUp();
      midDown();
   }
}

      