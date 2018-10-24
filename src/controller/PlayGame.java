package controller;

import view.IView;
import model.Game;

public class PlayGame implements model.IGetCardsObserver {
	
	private IView m_view;
	private Game m_game;
	
	public PlayGame(IView a_view, Game a_game){
		m_view = a_view;
		m_game = a_game;
		
	}

	public boolean Play() {
		
		// Added by me (Observer-pattern, point 6 in changes.txt)
		m_game.AddSubscriber(this);
		
		m_view.DisplayWelcomeMessage();
   
		// GetDealerScore och GetPlayerScore anv�nder sig av CalcScore-metoden i player via anrop till game
		m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
       
		m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
    
		if (m_game.IsGameOver())
		{
			m_view.DisplayGameOver(m_game.IsDealerWinner()); //denna metod anv�nder sig ocks� av CalcScore-metoden i player
		}
		// Removed from origin code
		//int input = a_view.GetInput();
    
		// Added by me (remove hidden dependency, point 2 in changes.txt)
		m_view.GetUsersInput(); 
    
		// alla bokst�ver �r problemet de utg�r ett hidden dependency. Titta p� L04 part 2 ~20:00
		// Removed from origin code (remove hidden dependency, point 2 in changes.txt)
		//if (input == 'p') 
		if(m_view.WantsToStartNewGame())
		{
			m_game.NewGame();
		}
		// Removed from origin code (remove hidden dependency, point 2 in changes.txt)
		//else if (input == 'h') 
		else if (m_view.WantsToHit())
		{
			m_game.Hit();
		}
		// Removed from origin code (remove hidden dependency, point 2 in changes.txt)
		//else if (input == 's')
		else if (m_view.WantsToStand())
		{
			m_game.Stand();
		}
		// Removed from origin code (remove hidden dependency, point 2 in changes.txt)
		//return input != 'q'; 
		return m_view.WantsToPlay();
	}

	// Added by me (Observer-pattern, point 6 in changes.txt)
	@Override
	public void GetCards() {
		
		m_view.DisplayNewView();
		m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
		m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
	}
}