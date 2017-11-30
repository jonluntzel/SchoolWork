// Jon Luntzel
// 4/18/17
// CSE142
// TA: Isidora Vukosav
// Assignment #3
// This program produces the Cafe Wall illusion.
import java.awt.*;

public class CafeWall {
   //Allows for flexible distance between rows
   public static final int MORTAR = 2;
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      rowMaker(g, 0, 0, 4, 20);
      rowMaker(g, 50, 70, 5, 30);
      gridMaker(g, 4, 35, 400, 20, 2, 35);
      gridMaker(g, 6, 10, 250, 200, 3, 25);
      gridMaker(g, 8, 0, 10, 150, 4, 25);
      gridMaker(g, 10, 10, 425, 180, 5, 20);
   }
   
   // Draws a row of squares with identical number of black and white squares
   public static void rowMaker(Graphics g, int x, int y, int pair, int size) {
      for (int i = 0; i < pair; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(i * 2 * size + x, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(i * 2 * size + x, size + y, i * 2 * size + x + size, y);
         g.drawLine(i * 2 * size + x, y, i * 2 * size + x + size, size + y);
         g.setColor(Color.WHITE);
         g.fillRect(i * 2 * size + x + size, y, size, size);
      }
   }
   
   // Produces a grid of rows with a certain mortar and offset
   public static void gridMaker(Graphics g, int row, int offset, int x, int y, int pair, int size) {
      for (int i = 0; i < row; i++) {
         rowMaker(g, x + offset * (i % 2), y + (MORTAR + size) * i, pair, size);
      }
   }
}