/**
 * ICS111 Project 3-Design Your Own
 * Monsters Class
 * -------------
 * Code for Monster GameObject
 *
 * @author Logan Moniz / TA: Ritika Sharma
 * @version 1.0
 * @since   12/04/2019
 */

import java.util.*;

public class Monsters extends Characters{
	
	// timer for the movement of the item
		int sec = 0;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				sec++;
				if (sec <= 10) {
					name.moveForward(10);
				}
				if (sec > 10) {
					name.moveForward(-10);
				}
				if (sec >= 20) {
					sec = 0;
				}
			}
		};
		
	//constructor for the monsters
	public Monsters(String filename, int posx, int posy) {
		super(filename, posx, posy);
		
	}
	
	public boolean isInside(int posx, int posy) {
		//System.out.println("test");
		return name.isPointInElement(posx,posy);
	}
	
	void upDown() {
		name.turnLeft(90);
		timer.scheduleAtFixedRate(task, 100, 100);
	}
}
