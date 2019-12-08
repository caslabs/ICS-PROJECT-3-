

public class Screen {
	
	//Constructor for any screen
	public Screen(int x, int y) {
		EZ.initialize(x,y);
	}
	
		void close() {
		EZ.closeWindowWithIndex(0);
	}
}
