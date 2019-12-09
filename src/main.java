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
import java.awt.event.KeyEvent;

public class main {
	
	static Characters logan;
	static int score;
	static boolean gameRunning;
	static int windowIndex;
	static int currMap = 0;
	
	
	//Array lists keys
	static ArrayList<key> keys = new ArrayList<key>();

	//start up
	static void startUp(int map) throws java.io.IOException {
		String filename = "no"; 
		if(map == 0) {
			filename = "background.png";
		}
		else if(map ==1) {
			filename = "Background_2.png";
		}
		else if(map == 2) {
			filename = "Background_3.png";
		}
		else if(map == 3){
		}
		
		gameRunning = true;
		Screen screen = new Screen(500,281);
		EZ.setBackgroundColor(new Color(0, 0, 0));
		EZ.addImage(filename,250, 140);
		
		logan = new Characters("logan_walk1.png",10, 230);
		
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
	}
	
	//Function that runs when player completes a level
	static void Escape()  throws java.io.IOException{
		if (score == 3) {
			gameRunning = false;
			EZ.refreshScreen();
			EZ.addImage("Background_2.png",250, 140);
			
		}
		//Restarts the game when space is pressed
		while(!gameRunning) {
			if(EZInteraction.wasKeyReleased(KeyEvent.VK_SPACE)) {
				EZ.closeWindowWithIndex(windowIndex);
				gameRunning = true;
				windowIndex++;
				currMap++;
				score = 0;
				startUp(currMap);
			}
		}
		
		
	}

	public static void main(String[] args) throws java.io.IOException{
		startUp(currMap);
		while(gameRunning){
			
			for (int i = 0; i < keys.size(); i++) {
				if (keys.get(i).isInside(logan.getX() - logan.getWidth() / 2, logan.getY() - logan.getHeight() / 2)
						|| keys.get(i).isInside(logan.getX() + logan.getWidth() / 2,
								logan.getY() + logan.getHeight() / 2)
						|| keys.get(i).isInside(logan.getX() + logan.getWidth() / 2,
							logan.getY() - logan.getHeight() / 2)
						|| keys.get(i).isInside(logan.getX() - logan.getWidth() / 2,
								logan.getY() + logan.getHeight() / 2)) {
					score++;
					keys.get(i).remove();
					System.out.println("good");
				}
				
			Escape();
			logan.move();
			EZ.refreshScreen();
		}
		}
	}
}
