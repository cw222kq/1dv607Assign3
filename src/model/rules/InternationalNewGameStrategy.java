package model.rules;

import model.Dealer;
import model.Player; 

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) { //Removed the Deck argument
    
	// Added by me (code duplication, point 5 in changes.txt)
	a_dealer.getCardAndGiveToPlayer(a_player, true);
		
	a_dealer.getCardAndGiveToPlayer(a_dealer, true);
		
	a_dealer.getCardAndGiveToPlayer(a_player, true);
		 
	// Removed from origin code  
	/*Card c;
    
    c = a_deck.GetCard(); 
    c.Show(true);			
    a_player.DealCard(c);	
  
    c = a_deck.GetCard(); 
    c.Show(true);			
    a_dealer.DealCard(c);	
  
    c = a_deck.GetCard();	
    c.Show(true);			
    a_player.DealCard(c);*/
  
    return true;
  }
}