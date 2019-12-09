import java.awt.event.KeyEvent;

public class Characters {
	
	//variables for character 
	EZImage name;
	int x,y;
	int health;
	
	
	//basic Constructor
	public Characters(String filename, int posx, int posy) {
		name = EZ.addImage(filename, posx, posy);
		x = posx;
		y = posy;
	}
	
	// gets the character dimensions
	public int getWidth() {
		return name.getWidth();
	}

	public int getHeight() {
		return name.getHeight();
	}

	// gets the character position
	public int getX() {
		return name.getXCenter();
	}

	public int getY() {
		return name.getYCenter();
	}

	// function to move the the character
	void move() {
		if (EZInteraction.isKeyDown(KeyEvent.VK_D)) {
			name.moveForward(2);
		}
		if (EZInteraction.isKeyDown(KeyEvent.VK_A)) {
			name.moveForward(-2);
		}
	}
	
	
}
