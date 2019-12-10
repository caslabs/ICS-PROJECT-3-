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
	
	static int monsCount;
	static Monsters bob;
	static Monsters steve;
	static Characters logan;
	static int score;
	static int gameRunning;
	static int windowIndex =1;
	static int currMap = 0;
	static EZImage BG;
	static boolean startUPRunning = true;
	static Screen testScreen;
	static EZSound song1 = EZ.addSound("SP.wav"); 

	//Array lists keys
	static ArrayList<key> keys = new ArrayList<key>();

	//start up
	static void startUp(int map) throws java.io.IOException {
		song1.play();
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
		else {
			lose();	
		}
		
		gameRunning = 0;
		Screen screen = new Screen(500,281);
		EZ.setBackgroundColor(new Color(0, 0, 0));

		BG = EZ.addImage(filename,250, 140);
		
		logan = new Characters("logan_walk1.png",10, 230);
		
		steve = new Monsters("monster_2.png",300,230);
		bob = new Monsters("monster_1.png",100,230);
		bob.upDown();
		steve.upDown();
		
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
	
	static void lose() {
		EZ.closeWindowWithIndex(windowIndex);
		gameRunning = 3;   
	}
	//Function that runs when player completes a level
	static void Escape()  throws java.io.IOException{
		if (score == 3) {
			gameRunning = 1;
			BG.hide();
			logan.hideCharacter();
			EZ.refreshScreen();
		}
		
		//moves on to the next level space is pressed
		while(gameRunning == 1) {
			if(EZInteraction.wasKeyReleased(KeyEvent.VK_SPACE)) {
				EZ.closeWindowWithIndex(windowIndex);
				gameRunning = 0;
				windowIndex++;
				currMap++;
				score = 0;
				startUp(currMap);
			}
		}
		
		
	}

	public static void main(String[] args) throws java.io.IOException{
		testScreen = new Screen(600,600);
		while(startUPRunning) {
			Scenes.StartUPMenu(currMap);
		}
		while(gameRunning == 0){
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
				if (bob.isInside(logan.getX() - logan.getWidth() / 2, logan.getY() - logan.getHeight() / 2)
							|| bob.isInside(logan.getX() + logan.getWidth() / 2,
									logan.getY() + logan.getHeight() / 2)
							|| bob.isInside(logan.getX() + logan.getWidth() / 2,
								logan.getY() - logan.getHeight() / 2)
							|| bob.isInside(logan.getX() - logan.getWidth() / 2,
									logan.getY() + logan.getHeight() / 2)) {
						System.out.println("ungood");
						logan.die();
						if (logan.die()) {
							song1.stop();
							System.out.println("dead");
							lose();
						}
					}
				if (steve.isInside(logan.getX() - logan.getWidth() / 2, logan.getY() - logan.getHeight() / 2)
							|| steve.isInside(logan.getX() + logan.getWidth() / 2,
									logan.getY() + logan.getHeight() / 2)
							|| steve.isInside(logan.getX() + logan.getWidth() / 2,
								logan.getY() - logan.getHeight() / 2)
							|| steve.isInside(logan.getX() - logan.getWidth() / 2,
									logan.getY() + logan.getHeight() / 2)) {
						System.out.println("ungood");
						logan.die();
						if (logan.die()) {
							song1.stop();
							System.out.println("dead");
							lose();
						}
					}
				
			Escape();
			logan.move();
			EZ.refreshScreen();
		}
		}
	}
}
