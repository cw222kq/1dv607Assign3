package model;

public class Game { 

  private Dealer m_dealer;
  private Player m_player;

  public Game()
  {
    m_dealer = new Dealer(new model.rules.RulesFactory()); 
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
 
  // Method added by me (interpretation of the sequence diagram, point 1 in changes.txt)
  public boolean Stand()
  {
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
  
  // Method added by me (Observer-pattern, point 6 in changes.txt)
  public void AddSubscriber(IGetCardsObserver a_sub){
	  m_player.AddSubscriber(a_sub);
	  m_dealer.AddSubscriber(a_sub);
  }
    
  
}