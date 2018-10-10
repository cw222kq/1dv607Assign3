package view;

public class SwedishView implements IView 
    {
        public void DisplayWelcomeMessage()
        {
         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};

            System.out.println("Hej Black Jack V√§rlden");
            System.out.println("----------------------");
            System.out.println("Skriv 'p' f√∂r att Spela, 'h' f√∂r nytt kort, 's' f√∂r att stanna 'q' f√∂r att avsluta\n");
        }
        
        public int GetInput()
        {
          try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
              c = System.in.read();
            }
            return c;
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
          }
        }
        
        public void DisplayCard(model.Card a_card) // denna metod ‰r den enda som skiljer sig i mer ‰n sprÂket pga att vi skapar tvÂ arrayer h‰r i simpleview anv‰nder vi oss av dem skapade korten i cardklassen
        {
            if (a_card.GetColor() == model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = // skapar en array  med f‰rger
                    { "Hj√§rter", "Spader", "Ruter", "Kl√∂ver" }; 
                String values[] =  // skapar en array med v‰rden
                    { "tv√•", "tre", "fyra", "fem", "sex", "sju", "√•tta", "nio", "tio", "knekt", "dam", "kung", "ess" }; 
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Po√§ng: " + a_score);
            System.out.println("");
        }
    }
