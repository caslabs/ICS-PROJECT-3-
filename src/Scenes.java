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
public class Scenes {

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
}
