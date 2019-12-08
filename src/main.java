import java.awt.Color;
import java.io.*;
import java.util.*;

public class main {
	
	static int score;
	static boolean gameRunning = true;
	
	//Array lists keys
	static ArrayList<key> keys = new ArrayList<key>();
	
	//start up 
	static void startUp() {
		Screen screen = new Screen(500,281);
		EZ.setBackgroundColor(new Color(0, 0, 0));
		EZ.addImage("background.png",250, 140);
	}
	
	//Function that runs when player completes a level
	static void Escape() {		
	}
	
	// win function
	static void win() {
		if (score == 3) {
			
		}
	}
	
	public static void main(String[] args) throws java.io.IOException{
		startUp();
		
		// file reading for the positions of the keys
		FileReader keyRead = new FileReader("key_pos.txt");
		Scanner keyPos = new Scanner(keyRead);
		int posx, posy;
				
		for(int i =0; i < 3; i++) {
			posx = keyPos.nextInt();
			posy = keyPos.nextInt();
			keys.add(new key("key.png",posx,posy));
		}
		keyPos.close();
		
		//create Player
		Characters logan = new Characters("logan_walk1.png",10, 230);
		
		while(gameRunning) {
			logan.move();
			EZ.refreshScreen();
			
		}
	}

}
