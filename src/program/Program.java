package program;

import model.Game;
import view.*;
import controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game g = new Game();
    IView v = new SimpleView(); //new SwedishView(); Kolla L:10 del 1 ~21:23
    //PlayGame ctrl = new PlayGame();
    PlayGame ctrl = new PlayGame(v,g);
    
    //while (ctrl.Play(g, v));
    while (ctrl.Play());
  }
}