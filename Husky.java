import java.awt.*;
import java.util.*;

public class Husky extends Critter {
private String bitch;

public Color getColor() {
      rColor = r.nextInt(1);
      if (rColor == 0) {
         this.color = Color.GREEN;
      }
      else {
         this.color = Color.PINK;
      }
      return color;
   }
   
   //returns the husky color randomly between three actions
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getDirection() == Direction.NORTH || info.getDirection() == Direction.SOUTH) {
          if (bitch.equals("0")) {
            bitch = "-";
          }
          else {
            bitch = "0";
          }
      }
      else if (info.getDirection() == Direction.EAST || info.getDirection() == Direction.WEST) {
         if (bitch.equals("0")) {
            bitch = "|";
          }
          else {
            bitch = "0";
          }         
      }
      return Action.HOP;
      }
   
   //returns the strings randomly as dollar signs
   public String toString() {
      return bitch;
   }
}