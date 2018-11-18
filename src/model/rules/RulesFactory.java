package model.rules;

public class RulesFactory { 

  public IHitStrategy GetHitRule() {
    //return new BasicHitStrategy();
    return new Soft17HitStrategy();
  }
  
  public INewGameStrategy GetNewGameRule() {
    //return new AmericanNewGameStrategy();
    return new InternationalNewGameStrategy();
  }
  
  // Method added by me (variable rule, point 4 in changes.txt)
  public IWinsGameStrategy GetWinsGameRule() {
	//return new PlayerWinsGameStrategy();
	return new DealerWinsGameStrategy();
  }
}