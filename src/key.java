/**
 * ICS111 Project 3-Design Your Own
 * Key Class
 * -------------
 * Object Class for Key GameItem
 *
 * @author
 * @version 1.0
 * @since   12/04/2019
 */

public class key {
	
	//variables for key 
	int x,y;
	EZImage key;
	
	//basic Constructor
	public key(String filename, int posx, int posy) {
		EZ.addImage(filename, posx, posy);
		x = posx;
		y = posy;
	}
	
	void hide() {
		key.hide();
	}
	
	void collected() {
		key.moveForward(1000);
	}
	
}
