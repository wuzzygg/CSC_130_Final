package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import Data.Vector2D;
import Data.spriteInfo;
import FileIO.EZFileRead;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static stopWatchX timer = new stopWatchX(300);
	public static spriteInfo current_sprite = new spriteInfo(new Vector2D(0, 0), "idle");
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static int currentSpriteIndex = 0;
	public static HashMap<String, String> dialog_map = new HashMap<>();
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)

		// Load all dialog from dialog.txt to dialog_map
		EZFileRead fileRead = new EZFileRead("Dialog.txt");
		for (int i = 0; i < fileRead.getNumLines(); i++){
			String raw = fileRead.getLine(i);
			StringTokenizer str = new StringTokenizer(raw, "*");
			dialog_map.put(str.nextToken(), str.nextToken());
		}

		int counter = -1;
		for (int i = 0; i <= 1280; i+=64) {
			if ((i == 0) || (i == (1280-64))) {
				sprites.add(new spriteInfo(new Vector2D(i, 250), "idle"));
				counter = 1;
			}else if (counter == 1) {
				sprites.add(new spriteInfo(new Vector2D(i, 250), "fwd1"));
				counter = 2;
			}else if (counter == 2) {
				sprites.add(new spriteInfo(new Vector2D(i, 250), "fwd2"));
				counter = 3;
			}else if (counter == 3) {
				sprites.add(new spriteInfo(new Vector2D(i, 250), "fwd3"));
				counter = 4;
			}else if (counter == 4) {
				sprites.add(new spriteInfo(new Vector2D(i, 250), "fwd4"));
				counter = 1;
			}
		}
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		ctrl.drawString(100, 250, "" + dialog_map.get("Dialog1"), Color.red);
		ctrl.addSpriteToFrontBuffer(current_sprite.getCoords().getX(), current_sprite.getCoords().getY(), current_sprite.getTag());
		if (currentSpriteIndex != (sprites.size())) {
			if (timer.isTimeUp()) {
				current_sprite = sprites.get(currentSpriteIndex);
				currentSpriteIndex += 1;
				timer.resetWatch();
			}
		}else {
			currentSpriteIndex = 0;
		}
	}
	// Additional Static methods below...(if needed)
}
