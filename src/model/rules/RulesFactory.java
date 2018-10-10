package model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }
// return typen ändras beroende på vilken game strategy typ man kör
  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}