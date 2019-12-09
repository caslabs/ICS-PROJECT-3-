/**
 * ICS111 Project 3-Design Your Own
 * Welcome Code Reviewers!
 * For our project 3, we decided to design our own game. This game is called Good Night Logan.
 * A horror, roguelike game produced by no-u team / ICS111 Fall 2019
 *
 * Instructions To Run:
 * Step 1. Read README.md for more information
 * Step 2. Make sure main.java is the main run / should be set by default
 * Step 2. Enjoy the game
 *
 *
 * @author Jeraldy Cascayan / TA: Nima Azbijari
 * @author Logan Moniz / TA: Ritika Sharma
 * @author Chris Dang / TA: Nima Azbijari
 * @version 1.0
 * @since   12/04/2019
 *
 */

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
		Screen screen = new Screen(600, 281);
		EZ.setBackgroundColor(new Color(255, 255, 255));
	}


	
	// win function
	static void win() {
		if (score == 3) {
			EZ.closeWindowWithIndex(0);
		}
	}
	
	//key collection function
	static void collectKey(int i) {
		keys.remove(i);
	}
	
	public static void main(String[] args) throws java.io.IOException {
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
		Characters logan = new Characters("logan_walk1.png",100, 230);

		while(gameRunning) 
		{
			
			logan.move();
			EZ.refreshScreen();
			//not working check if the player has touched the keys
			System.out.println((logan.getX() - logan.getWidth() / 2));
			System.out.println((logan.getY() - logan.getHeight() / 2));
			//System.out.println(logan.getWidth());
			//System.out.println(logan.getY());
			//System.out.println(logan.getHeight());
			//System.out.println(keys.get(0).isInside((logan.getX() - logan.getWidth() / 2), (logan.getY() - logan.getHeight() / 2)));
			System.out.println(keys.get(0));
			System.out.println(keys.get(0).isInside(logan.getX() - (logan.getWidth() / 2), logan.getY() - (logan.getHeight() / 2)));

			for (int i = 0; i < 2; i++) {
				System.out.println(keys.get(i));
				if (keys.get(i).isInside(logan.getX() - logan.getWidth() / 2, logan.getY() - logan.getHeight() / 2)
						|| keys.get(i).isInside(logan.getX() + logan.getWidth() / 2,
								logan.getY() + logan.getHeight() / 2)
						|| keys.get(i).isInside(logan.getX() + logan.getWidth() / 2,
							logan.getY() - logan.getHeight() / 2)
						|| keys.get(i).isInside(logan.getX() - logan.getWidth() / 2,
								logan.getY() + logan.getHeight() / 2)) {

					score++;
					collectKey(i);
				}
				}
			win();

		}
	}
}
