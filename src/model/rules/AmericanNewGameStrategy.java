package model.rules;

import model.Dealer;
import model.Player;
 
class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) { //Removed the Deck argument	
    
	// Added by me (code duplication, point 5 in changes.txt)
	a_dealer.getCardAndGiveToPlayer(a_player, true);
	
	a_dealer.getCardAndGiveToPlayer(a_dealer, true);
	
	a_dealer.getCardAndGiveToPlayer(a_player, true);
	
	a_dealer.getCardAndGiveToPlayer(a_dealer, false);
	
    
    
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
    a_player.DealCard(c);	

    c = a_deck.GetCard();	
    c.Show(false);			
    a_dealer.DealCard(c);*/

    return true;
  }
}