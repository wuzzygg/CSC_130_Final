package Main;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import Data.Vector2D;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static Queue<Vector2D>vecs1 = new LinkedList<>();
	public static Queue<Vector2D>vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(-100, 100);
	public static stopWatchX timer = new stopWatchX(300);
	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		for (int i = 1; i <= 1280; i+=64) {
			Vector2D newVec = new Vector2D(i, 250);
			vecs1.add(newVec);
		}
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		ctrl.drawString(100, 500, "" + vecs1.size(), Color.red);
		ctrl.drawString(100, 550, "" + vecs2.size(), Color.red);

		if (!vecs1.isEmpty()) {
			ctrl.drawString(100, 600, "going in vecs1", Color.red);
			ctrl.addSpriteToFrontBuffer(currentVec.getX(), currentVec.getY(), "idle");
			if (timer.isTimeUp()) {
				currentVec = vecs1.peek();
				vecs1.remove();
				vecs2.add(currentVec);
				timer.resetWatch();
			}
		} 
		if (vecs1.isEmpty()) {
			ctrl.drawString(100, 650, "going in vecs2", Color.red);
			vecs1 = new LinkedList<>(vecs2);
			vecs2.clear();
		}
	}
	// Additional Static methods below...(if needed)
}
