package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;
import model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {	// dealern och spelaren får ett extra kort. sista kortet för dealern är dolt
// går att göra dealer privat om man kör player istället för dealer här (når dealer via player)
  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Card c;

    c = a_deck.GetCard(); // dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_player.DealCard(c);	// spelaren får ett kort

    c = a_deck.GetCard();	// dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_dealer.DealCard(c);	//spelaren får ett kort

    c = a_deck.GetCard();	// dealern tar ett kort
    c.Show(true);			// dealern visar sitt kort
    a_player.DealCard(c);	// spelaren får ett kort

    c = a_deck.GetCard();	// dealern tar ett kort
    c.Show(false);			// dealern visar INTE sitt kort
    a_dealer.DealCard(c);	// spelaren får ett kort

    return true;
  }
}