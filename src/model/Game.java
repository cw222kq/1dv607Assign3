package model;

public class Game { // jag tror att den här klassen fungerar som en facade för player och dealer för att controllern ska 
	// slippa ha två beroenden (en till player och en till dealer) Därför kapslar denna facade in player och dealer mer

  private Dealer m_dealer;
  private Player m_player;

  public Game()
  {
    m_dealer = new Dealer(new model.rules.RulesFactory()); //skapar upp en ny instans av rulesfactory
    m_player = new Player();
  }
    
    
  public boolean IsGameOver()
  {
    return m_dealer.IsGameOver();
  }
  
  public boolean IsDealerWinner()
  {
    return m_dealer.IsDealerWinner(m_player);
  }
  
  public boolean NewGame()
  {
    return m_dealer.NewGame(m_player);
  }
  
  public boolean Hit()
  {
    return m_dealer.Hit(m_player);
  }
  // fanns från början
 /* public boolean Stand()
  {
    // TODO: Implement this according to Game_Stand.sequencediagram
    return true;
  }*/
  // det jag försökt lägga till ingen aning om detta är rätt eftersom jag inte förstår sekvensdiagrammet helt ut
  public boolean Stand()
  {
    // TODO: Implement this according to Game_Stand.sequencediagram
    return m_dealer.Stand();
  }
  
  public Iterable<Card> GetDealerHand()
  {
    return m_dealer.GetHand();
  }
  
  public Iterable<Card> GetPlayerHand()
  {
    return m_player.GetHand();
  }
  
  public int GetDealerScore()
  {
    return m_dealer.CalcScore();
  }
  
  public int GetPlayerScore()
  {
    return m_player.CalcScore();
  }
    
  
}