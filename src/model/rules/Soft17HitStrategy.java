/**
 * 
 */
package model.rules;
import model.Player;

/**
 * @author cw222kq
 *
 */
class Soft17HitStrategy extends BasicHitStrategy {
	
	@Override
	public boolean DoHit(Player a_dealer) {
		if(a_dealer.hasAce()){
			return a_dealer.CalcScore() <= g_hitLimit;	
		}
		return super.DoHit(a_dealer);
	}
}
