package model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }
// return typen �ndras beroende p� vilken game strategy typ man k�r
  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}