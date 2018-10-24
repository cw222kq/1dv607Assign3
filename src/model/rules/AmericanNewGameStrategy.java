package model.rules;

import model.Dealer;
import model.Player;
 
class AmericanNewGameStrategy implements INewGameStrategy {	// dealern och spelaren f�r ett extra kort. sista kortet f�r dealern �r dolt

  public boolean NewGame(Dealer a_dealer, Player a_player) { //Removed the Deck argument	
    
	// Added by me (code duplication, point 5 in changes.txt)
	a_dealer.getCardAndGiveToPlayer(a_player, true);
	
	a_dealer.getCardAndGiveToPlayer(a_dealer, true);
	
	a_dealer.getCardAndGiveToPlayer(a_player, true);
	
	a_dealer.getCardAndGiveToPlayer(a_dealer, false);
	
    
    
    // Removed from origin code
	/*Card c;
	  
    c = a_deck.GetCard(); // dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_player.DealCard(c);	// spelaren f�r ett kort

    c = a_deck.GetCard();	// dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_dealer.DealCard(c);	//spelaren f�r ett kort

    c = a_deck.GetCard();	// dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_player.DealCard(c);	// spelaren f�r ett kort

    c = a_deck.GetCard();	// dealern tar ett kort
    c.Show(false);			// dealern visar INTE sitt kort
    a_dealer.DealCard(c);	// spelaren f�r ett kort */

    return true;
  }
}