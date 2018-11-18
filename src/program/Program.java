package program;

import model.Game;
import view.*;
import controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game g = new Game();
    IView v = new SimpleView(); //new SwedishView(); 
    
    //Removed from origin code
    //PlayGame ctrl = new PlayGame();
    
    //Added by me (Observer-pattern, point 6 in changes.txt)
    PlayGame ctrl = new PlayGame(v,g);
    
    //Removed from origin code
    //while (ctrl.Play(g, v));
    
    //Added by me (Observer-pattern, point 6 in changes.txt)
    while (ctrl.Play());
  }
}