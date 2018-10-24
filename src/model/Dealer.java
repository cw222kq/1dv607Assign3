package model;

import model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinsGameStrategy m_winsGameRule;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winsGameRule = a_rulesFactory.GetWinsGameRule();
    
    /*for(Card c : m_deck.GetCards()) { BORT KOMMENTERAT AV DEM I ORGINALVERSIONEN
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  protected boolean NewGame(Player a_player) { //NÄR MAN VÄLJER NY GAME SÅ SKA PLAYER FÅ SITT FÖRSTA KORT FÖRST
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);   
    }
    return false;
  }

  protected boolean Hit(Player a_player) {
	  // dealer ska hit om deck inte är null och handpoängen är under maxscore och inte gameover
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
    		
    //Removed from origin code 
      /*Card c;
      c = m_deck.GetCard();
      c.Show(true);
      a_player.DealCard(c);*/  
    	
    // Added by me (duplicated code, point 5 in changes.txt)
      getCardAndGiveToPlayer(a_player, true);
      return true;
    }
    return false;
  }
  
  // Method added by me (interpretation of the sequence diagram, point 1 in changes.txt)
  protected boolean Stand(){
	  if(m_deck != null){
		  ShowHand();
		  for(Card c : GetHand()){
			  c.Show(true);
		  }
		  while(m_hitRule.DoHit(this)){
			  m_hitRule.DoHit(this);
			  
			  //Removed from code
			  /*Card c = m_deck.GetCard();
			  c.Show(true);
			  DealCard(c);*/
			  
			  // Added by me (duplicated code, point 5 in changes.txt)
			  getCardAndGiveToPlayer(this, true);
		  }
		  return true;  
	  }
	  return false;
  }

  protected boolean IsDealerWinner(Player a_player) {
	//om player får över 21 (maxscore) så vinner dealer
    if (a_player.CalcScore() > g_maxScore) {
      return true;
    // om dealer får över 21 (maxscore) så förlorar dealar 
    } else if (CalcScore() > g_maxScore) {
      return false;
    }
    // dealer vinner om han får över eller lika med player
    
    // Removed from origin code
    //return CalcScore() >= a_player.CalcScore();
    
    // Added by me (variable rule, point 4 in changes.txt)
    return m_winsGameRule.IsDealerWinner(a_player, this);
  }

  protected boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
  //Method added by me (duplicated code, point 5 in changes.txt)
  public void getCardAndGiveToPlayer(Player playerOrDealer, boolean visable){
	  Card c = m_deck.GetCard();
	  c.Show(visable);
	  playerOrDealer.DealCard(c);
	 
  }
  
}