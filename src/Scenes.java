/**
 * ICS111 Project 3-Design Your Own
 * Scenes Class
 * -------------
 * This is a simple class that contains all the game scenes required for the game.
 * Splash Screen
 * Game Over Scene
 *
 * @author Jeraldy Cascayan / TA: Nima Azbijari
 * @version 1.0
 * @since   12/04/2019
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Scenes {
    Screen screenMain;
    public Scenes() {
        screenMain = new Screen(600,281);
    }

    //Splash Scene;
    static void splashScreen() {
        Screen screen = new Screen(600,281);
        EZ.setBackgroundColor(new Color(0, 0, 0));
    }

    //Game Over Scene
    static void gameOverScreen() {
        Screen screen = new Screen(600, 281);
        EZ.setBackgroundColor(new Color(255, 255, 255));
    }

    //You Win Scene
    static void WinScreen() {
        EZ.setBackgroundColor(new Color(0, 0, 255));
    }

    //Startup Menu
    static void StartUPMenu(int thisMap) throws IOException {
        EZ.addImage("assets/backgrounds/logan_gn.jpg",800/2, 600/2 );
        if (EZInteraction.isKeyDown(KeyEvent.VK_SPACE)) {
            System.out.println("pressed");
            main.testScreen.close();
            main.startUp(thisMap);
            main.startUPRunning = false;
        }
    }
}
