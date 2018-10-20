package controller;

import view.IView;
import model.Game;

public class PlayGame {

  public boolean Play(Game a_game, IView a_view) {
    a_view.DisplayWelcomeMessage();
    
    // GetDealerScore och GetPlayerScore anv�nder sig av CalcScore-metoden i player via anrop till game
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner()); //denna metod anv�nder sig ocks� av CalcScore-metoden i player
    }
    // Removed from origin code
    //int input = a_view.GetInput();
    
    //added by me
    a_view.GetUsersInput();
    
    // alla bokst�ver �r problemet de utg�r ett hidden dependency. Titta p� L04 part 2 ~20:00
    // Removed from origin code
    //if (input == 'p') 
    if(a_view.WantsToStartNewGame())
    {
        a_game.NewGame();
    }
    // Removed from origin code
    //else if (input == 'h') 
    else if (a_view.WantsToHit())
    {
        a_game.Hit();
    }
    // Removed from origin code
    //else if (input == 's')
    else if (a_view.WantsToStand())
    {
        a_game.Stand();
    }
    // Removed from origin code
    //return input != 'q'; 
    return a_view.WantsToPlay();
  }
}