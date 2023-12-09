/* This will handle the "Hot Key" system. */

package Main;

import Data.Vector2D;
import Data.spriteInfo;
import Data.collisionBox;
import logic.Control;
import timer.stopWatchX;
import java.awt.Color;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(50);
	private static stopWatchX timer = new stopWatchX(50);
	private static stopWatchX interactTimer = new stopWatchX(200);
	private static int currentSpriteIndex = 1;
	private static Integer playerSpeed = 5;
	
	// Static Method(s)
	public static void processKey(char key){
		// return;
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;
		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;

		case 'w':
			if (timer.isTimeUp()) {
				// Main.trigger = "w is triggered";
				Main.playerSprite.setPlayerDirection("Up");				
				Main.playerSprite.getCoords().adjustY(-playerSpeed);
				Main.checkCollision();
				Main.playerSprite.setTag("UpWalking" + currentSpriteIndex);
				currentSpriteIndex += 1;
				if (currentSpriteIndex == 19) {
					currentSpriteIndex = 1;
				}
				Main.interact(false);
				timer.resetWatch();
			}
			break;

		case 'a':
			if (timer.isTimeUp()) {
				// Main.trigger = "a is triggered";
				Main.playerSprite.setPlayerDirection("Left");
				Main.playerSprite.getCoords().adjustX(-playerSpeed);
				Main.checkCollision();
				Main.playerSprite.setTag("LeftWalking" + currentSpriteIndex);
				currentSpriteIndex += 1;
				if (currentSpriteIndex == 19) {
					currentSpriteIndex = 1;
				}
				Main.interact(false);
				timer.resetWatch();
			}
			break;

		case 's':
			if (timer.isTimeUp()) {
				// Main.trigger = "s is triggered";
				Main.playerSprite.setPlayerDirection("Down");
				Main.playerSprite.getCoords().adjustY(playerSpeed);
				Main.checkCollision();
				Main.playerSprite.setTag("DownWalking" + currentSpriteIndex);
				currentSpriteIndex += 1;
				if (currentSpriteIndex == 19) {
					currentSpriteIndex = 1;
				}
				Main.interact(false);
				timer.resetWatch();
			}
			break;

		case 'd':
			if (timer.isTimeUp()) {
				// Main.trigger = "d is triggered";
				Main.playerSprite.setPlayerDirection("Right");
				Main.playerSprite.getCoords().adjustX(playerSpeed);
				Main.checkCollision();
				Main.playerSprite.setTag("RightWalking" + currentSpriteIndex);
				currentSpriteIndex += 1;
				if (currentSpriteIndex == 19) {
					currentSpriteIndex = 1;
				}
				Main.interact(false);
				timer.resetWatch();
			}
			break;

		case '$':
			
				// Main.trigger = "spacebar is triggered";
				if (interactTimer.isTimeUp()) {

					if (!Main.checkCollision()){
						Main.isDialogBoxOpen = false;
						Main.trigger = "";
						return;
					}
					Main.interact(true);
					// if (Main.isDialogBoxOpen){
					// 	Main.isDialogBoxOpen = false;
					// 	Main.dialogBoxSprite.setCoords(-1000, -1000);
					// 	Main.trigger = "";
					// } else {
					// 	Main.isDialogBoxOpen = true;
					// 	Main.dialogBoxSprite.setCoords(400, 250);
					// }
					interactTimer.resetWatch();
				}
				
			
			break;
			
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;

		case ' ':
			// Main.current_sprite.setTag("Right_Idle");
			switch(Main.playerSprite.getPlayerDirection()){
				case "Right":
					Main.playerSprite.setTag("Right_Idle");
					break;
				case "Left":
					Main.playerSprite.setTag("Left_Idle");
					break;
				case "Up":
					Main.playerSprite.setTag("Up_Idle");
					break;
				case "Down":
					Main.playerSprite.setTag("Down_Idle");
					break;
			}
			break;
		}
	}
}