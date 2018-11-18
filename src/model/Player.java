package model;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Player { 

  private List<Card> m_hand;
  protected final int g_maxScore = 21;
  private ArrayList<IGetCardsObserver> m_subscribers;

  public Player()
  {
  
    m_hand = new LinkedList<Card>();
    
    // Added by me (Observer-pattern, point 6 in changes.txt)
    m_subscribers = new ArrayList<IGetCardsObserver>();
 
  }
  
  public void DealCard(Card a_addToHand)
  {
    m_hand.add(a_addToHand); 
    
    // Added by me (Observer-pattern, point 6 in changes.txt)
    NotifyObserversOnEvent(); 
    paus();
  }
  
  protected Iterable<Card> GetHand() 
  {
    return m_hand;
  }
  
  protected void ClearHand()
  {
    m_hand.clear(); 
  }
  
  protected void ShowHand()
  {
    for(Card c : m_hand) 
    {
      c.Show(true);
    }
    
  }
  
  public int CalcScore()
  {
    // the number of scores is dependent on the number of scorable values 
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int cardScores[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
    };
    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
  
    int score = 0;

    for(Card c : GetHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
            score += cardScores[c.GetValue().ordinal()];
            
        }
    }

    if (score > g_maxScore)
    {
        for(Card c : GetHand())
        {
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
            {
                score -= 10;
            }
        }
    }

    return score;
  }
  
  // Method added by me (point 3 in changes.txt)
  public boolean hasAce(){
	  for(Card c : GetHand()) {
	        if (c.GetValue() == Card.Value.Ace)
	        {
	           return true;
	        }
	  }
	  return false;
  }
  
  //Method added by me (Observer-pattern, point 6 in changes.txt)
  public void AddSubscriber(IGetCardsObserver a_sub){
	  m_subscribers.add(a_sub);
  }
 
  // Method added by me (Observer-pattern, point 6 in changes.txt)
  private void NotifyObserversOnEvent(){
	 for(IGetCardsObserver obs : m_subscribers){
	   	obs.GetCards();
	 }  
  }
 
  // Method added by me (Observer-pattern, point 6 in changes.txt)
  private void paus(){
	 try {					
		Thread.sleep(2000);
	 } catch (InterruptedException e) {
		e.printStackTrace();
	 }
  }
  
}