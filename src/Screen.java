/**
 * ICS111 Project 3-Design Your Own
 * Screen Class
 * -------------
 * Screen Class
 * This code constructs and initialize EZ Windows
 * @author Chris Dang / TA: Nima Azbijari
 * @version 1.0
 * @since   12/04/2019
 */

public class Screen {
	
	//Constructor for any screen
	public Screen(int x, int y) {
		EZ.initialize(x,y);
	}
	//closes the window
		void close() {
		EZ.closeWindowWithIndex(0);
	}
}
