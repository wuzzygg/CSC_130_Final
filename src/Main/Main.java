package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import Data.Vector2D;
import Data.spriteInfo;
import Data.collisionBox;
import FileIO.EZFileRead;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static ArrayList<collisionBox> collisionBoxes = new ArrayList<>();
	public static Boolean isDialogBoxOpen = false;
	public static spriteInfo playerSprite = new spriteInfo(new Vector2D(100, 300), "Right_Idle", new Vector2D(128, 128));
	public static spriteInfo backgroundSprite = new spriteInfo(new Vector2D(0, 0), "Background", new Vector2D(1280, 720));
	public static spriteInfo dialogBoxSprite = new spriteInfo(new Vector2D(-1000, -100), "DialogBox", new Vector2D(1280, 720));
	public static spriteInfo meat001Sprite = new spriteInfo(new Vector2D(455, 200), "Meat001", new Vector2D(64, 64));
	public static spriteInfo meat002Sprite = new spriteInfo(new Vector2D(700, 340), "Meat002", new Vector2D(64, 64));
	public static spriteInfo shoesSprite = new spriteInfo(new Vector2D(455, 340), "Shoes", new Vector2D(64, 64));
	public static HashMap<String, String> dialog_map = new HashMap<>();
	public static String trigger = new String("");
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		sprites.add(backgroundSprite);
		sprites.add(meat001Sprite);
		sprites.add(meat002Sprite);
		sprites.add(shoesSprite);
		sprites.add(playerSprite);
		// sprites.add(dialogBoxSprite);

		// collision for edges of screen and bottom half of screen.
		collisionBoxes.add(new collisionBox(-1, 0, -1, 719, false, false, ""));
		collisionBoxes.add(new collisionBox(0, -1, 1279, -1, false, false, ""));
		collisionBoxes.add(new collisionBox(1280, 0, 1280, 719, false, false, ""));
		collisionBoxes.add(new collisionBox(0, 720, 1279, 720, false, false, ""));
		collisionBoxes.add(new collisionBox(0, 435, 1279, 435, false, false, ""));

		
		collisionBoxes.add(new collisionBox(meat001Sprite, true, true, "This looks yummy!"));
		collisionBoxes.add(new collisionBox(meat002Sprite, true, true, "This looks yummy too!"));
		collisionBoxes.add(new collisionBox(shoesSprite, true, true, "These shoes belong to my human! He must be close by!"));
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		for (spriteInfo sprite : sprites) {
			ctrl.addSpriteToFrontBuffer(sprite.getCoords().getX(), sprite.getCoords().getY(), sprite.getTag());
		}
		ctrl.drawString(dialogBoxSprite.getCoords().getX(), dialogBoxSprite.getCoords().getY(), "" + trigger, Color.blue);
	}

	public static Boolean checkCollision(){
		for (collisionBox box : collisionBoxes) {
			if (playerSprite.getCoords().getX() + playerSprite.getSize().getX() >= box.getX1() && playerSprite.getCoords().getX() <= box.getX2() &&
			playerSprite.getCoords().getY() + playerSprite.getSize().getY() >= box.getY1() && playerSprite.getCoords().getY() <= box.getY2()) {
				if (box.getCanCollide()){
					//  interactable
					if (box.isInteractable()) {
						// System.out.println("interactable");
						trigger = box.getDialog();
						// System.out.println(trigger);
						return true;
					}
				} else {
					// bounce player back
					teleportPlayer();
					return true;
				}
			}
		}
		return false;
	}

	public static void interact(Boolean isInteracting) {
		if (isInteracting){
			if (isDialogBoxOpen) {
				isDialogBoxOpen = false;
				dialogBoxSprite.setCoords(-1000, -1000);
			} else {
				isDialogBoxOpen = true;
				dialogBoxSprite.setCoords(playerSprite.getCoords().getX(), playerSprite.getCoords().getY());
			}
		} else {
			isDialogBoxOpen = false;
			dialogBoxSprite.setCoords(-1000, -1000);
		}
	}

	public static void teleportPlayer(){
		switch (playerSprite.getPlayerDirection()) {
			case "Up":
				playerSprite.getCoords().adjustY(5);
				break;
			case "Down":
				playerSprite.getCoords().adjustY(-5);
				break;
			case "Left":
				playerSprite.getCoords().adjustX(5);
				break;
			case "Right":
				playerSprite.getCoords().adjustX(-5);
				break;
			default:
				break;
		}
	}

	// Additional Static methods below...(if needed)
}
