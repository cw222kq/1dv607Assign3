package model.rules;

public class RulesFactory { // pratar om detta L:10 Part 1 ~19:30

  public IHitStrategy GetHitRule() {
    //return new BasicHitStrategy();
    return new Soft17HitStrategy();
  }
// return typen ändras beroende på vilken game strategy typ man kör
  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
    //return new InternationalNewGameStrategy();
  }
  public IWinsGameStrategy GetWinsGameRule() {
	//return new PlayerWinsGameStrategy();
	return new DealerWinsGameStrategy();
  }
}