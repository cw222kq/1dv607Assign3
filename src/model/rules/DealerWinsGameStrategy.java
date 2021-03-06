/**
 * 
 */
package model.rules;

import model.Player;

/**
 * @author cw222kq
 *	If equal score, dealer wins
 */
class DealerWinsGameStrategy implements IWinsGameStrategy {

	@Override
	public boolean IsDealerWinner(Player a_player, Player a_dealer) {
		return a_dealer.CalcScore() >= a_player.CalcScore();
	}

}
