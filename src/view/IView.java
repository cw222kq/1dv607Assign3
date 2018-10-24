package view;

public interface IView //samlar det som kan variera mellan klasserna i ett interface
{
  void DisplayWelcomeMessage();
  //Removed from origin code
  //int GetInput();
  void DisplayCard(model.Card a_card);
  void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
  
  //Methods added by me (remove hidden dependency, point 2 in changes.txt)
  void GetUsersInput();
  boolean WantsToPlay();
  boolean WantsToStartNewGame();	
  boolean WantsToHit();
  boolean WantsToStand();
  
  // Method added by me (Observer-pattern, point 6 in changes.txt)
  void DisplayNewView();
}