import java.awt.*;

public class main {

	public static void main(String[] args) {
		/*
		TODO : create auto window mode, custom resolution, boot menu?
		 */

		//Testing width and height for Jeraldy's computer. You can change it for yours.
		int width = 1080;
		int height = 720;
		EZ.initialize(width, height);

		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("Logan was here");
		System.out.println("logan was not here");
		//Jeraldy
		System.out.println("Hello World");
		
		//Chris 
		System.out.println("I like die");


		while(true) {
			EZ.setBackgroundColor(new Color(0, 0, 0));
			EZImage i = EZ.addImage("assets/TeamLOGO.png",width/2, height/2, true, 100);
			EZ.refreshScreen();
		}
	}

}
