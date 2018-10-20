package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;
import model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {	// dealern och spelaren f�r ett extra kort. sista kortet f�r dealern �r dolt
// g�r att g�ra dealer privat om man k�r player ist�llet f�r dealer h�r (n�r dealer via player)
  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Card c;

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
    a_dealer.DealCard(c);	// spelaren f�r ett kort

    return true;
  }
}