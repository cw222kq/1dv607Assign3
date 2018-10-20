package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;

public interface INewGameStrategy { //samlar det som kan variera mellan klasserna i ett interface
	// ~36:00 i L:09 del 2 
    boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
}