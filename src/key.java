/**
 * ICS111 Project 3-Design Your Own
 * Key Class
 * -------------
 * Object Class for Key GameItem
 *
 * @author Chris Dang / TA: Nima Azbijari
 * @version 1.0
 * @since   12/04/2019
 */

public class key {
	
	//variables for key 
	int x,y;
	EZImage keyObject;
	
	//basic Constructor
	public key(String filename, int posx, int posy) {
		keyObject = EZ.addImage(filename, posx, posy);
		x = posx;
		y = posy;
	}
	
	//check if key collided with player
	public boolean isInside(int posx, int posy) {
		//System.out.println("test");
		return keyObject.isPointInElement(posx,posy);
	}
	//"removes" the key from the screen
	public void remove() {
		keyObject.hide();
		keyObject.moveForward(900);
	}
	

}
