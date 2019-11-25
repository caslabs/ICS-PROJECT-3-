import java.awt.Color;
import java.util.*;

public class main {
	
	//A Stack that will hold all the maps
//	static Stack<Integer> maps =new Stack<Integer>();
//	static int currMap = maps.peek();
	
	
	/*need a funct 
	 that chooses random numbers 
	 puts said numbers in the stack for the order of the maps
	*/
	
	//start up 
	static void startUp() {
		Screen screen = new Screen(900,900);
		EZ.setBackgroundColor(new Color(0, 0, 0));
	}
	
	//The loading screen 
	static void loadScreen() {
		EZ.setBackgroundColor(new Color(0, 0, 0));
		EZ.refreshScreen();
	}
	
	//sets the map
	static void mapSet(int i) {
		EZ.setBackgroundColor(new Color(0, 0, 0));
		EZ.refreshScreen();
	}
	
	//Function that runs when player completes a level
	static void Escape() {
		maps.pop();
		loadScreen();
		currMap = maps.peek();
		mapSet(currMap);				
	}
	public static void main(String[] args) {
		
		startUp();
	}

}
