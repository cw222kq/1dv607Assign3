/**
 * 
 */
package model.rules;

import model.Player;

/**
 * @author cw222kq
 *
 */
public interface IWinsGameStrategy {
	 public boolean IsDealerWinner(Player a_player, Player a_dealer);
}
