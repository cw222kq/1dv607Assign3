package model;

import java.util.List;
import java.util.LinkedList;

public class Player {

  private List<Card> m_hand; // motsvarar spelarens hand
  protected final int g_maxScore = 21;

  public Player()
  {
  
    m_hand = new LinkedList<Card>();
    System.out.println("Hello List World");
  }
  
  public void DealCard(Card a_addToHand)
  {
    m_hand.add(a_addToHand); //add metoden en färdig metod i listklassen. Lägger till ett kort till spelarens hand
  }
  
  public Iterable<Card> GetHand()
  {
    return m_hand;
  }
  
  public void ClearHand()
  {
    m_hand.clear(); // clear metoden en färdig metod i listklassen
  }
  
  public void ShowHand()
  {
    for(Card c : m_hand) // foreach typ java stylish
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
  
    // ordinal verkar fungera lite som array.length() kollar alltså hur många värden som finns på value ovan
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
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore) // räknar om värdet vid ess och över maxpoäng blir ess värd ett
            {
                score -= 10;
            }
        }
    }

    return score;
  }
}