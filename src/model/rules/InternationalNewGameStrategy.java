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
    
    c = a_deck.GetCard(); // dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_player.DealCard(c);	// Spelaren får ett kort
  
    c = a_deck.GetCard(); // dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_dealer.DealCard(c);	// Spelaren får ett kort
  
    c = a_deck.GetCard();	// dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_player.DealCard(c);	// Spelaren får ett kort (i AmericanNewGameStrategy fortsätter detta)*/
  
    return true;
  }
}