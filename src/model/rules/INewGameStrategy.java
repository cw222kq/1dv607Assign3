package model.rules;

import model.Dealer;
import model.Player;

public interface INewGameStrategy { //samlar det som kan variera mellan klasserna i ett interface
	// ~36:00 i L:09 del 2 
    boolean NewGame(Dealer a_dealer, Player a_player); //Removed the Deck argument
}