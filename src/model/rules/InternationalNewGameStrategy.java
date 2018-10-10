package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;
import model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Card c;
  
    c = a_deck.GetCard(); // dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_player.DealCard(c);	// Spelaren f�r ett kort
  
    c = a_deck.GetCard(); // dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_dealer.DealCard(c);	// Spelaren f�r ett kort
  
    c = a_deck.GetCard();	// dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_player.DealCard(c);	// Spelaren f�r ett kort (i AmericanNewGameStrategy forts�tter detta)
  
    return true;
  }
}