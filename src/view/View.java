/**
 * 
 */
package view;

/**
 * @author cw222kq
 *	The common methods for both the views are moved to this abstract super class View
 */
public abstract class View {
	
	private int m_userInput;

	private int GetInput()
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
	public void GetUsersInput(){
		m_userInput = GetInput();
	}
	public boolean WantsToPlay() {
		return m_userInput != 'q';
	}
	public boolean WantsToStartNewGame() {
		return m_userInput == 'p';
	}
	public boolean WantsToHit() {
		return m_userInput == 'h';
	}
	public boolean WantsToStand() {
		return m_userInput == 's';
	}

}
