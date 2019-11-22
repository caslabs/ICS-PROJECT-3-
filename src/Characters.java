
public class Characters {
	
	//variables for the 
	EZImage name;
	int x,y;
	
	//basic Constructor
	public Characters(String filename, int posx, int posy) {
		x = posx;
		y = posy;
		name = EZ.addImage(filename, posx, posy);
	}
	
	
}
