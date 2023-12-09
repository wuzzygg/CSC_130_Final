/* This is a way to pass a sprite's key information in one entity. (x, y, tag) */

package Data;

public class spriteInfo {
	// Fields
		// TODO: Add private class fields to store x, y (use Vector2D for this) and tag (String) values given in class constructor
	private Vector2D xy, size;
	private String tag;
	private String playerDirection = "Right";
	// private int width, height;
	
	// Constructor
	public spriteInfo(Vector2D v2d, String tag, Vector2D size){
		// TODO: Save the constructor parameters into class fields
		this.xy = v2d;
		this.tag = tag;
		this.size = size;
	}
	
	// Methods
	public String getTag(){
		// TODO: Remove my placeholder code below (which is there to prevent an error) and replace it with returning the value of your private field tag
		return this.tag;
	}
	
	public Vector2D getCoords(){
		// TODO: Remove my placeholder code below (which is there to prevent an error) and replace it with returning the value of your private field v2d
		return xy;
	}
	
	public void setTag(String newTag){
		// TODO: Update the value of tag to be the value in newTag (Absolute assignment)
		this.tag = newTag;
	}
	
	public void setCoords(Vector2D newV2D){
		// TODO: Update the value of v2d to be the value in newV2D (Absolute assignment)
		this.xy = newV2D;
	}
	
	public void setCoords(int x, int y){
		// TODO: Overload the setCoords method to allow another way to set the coordinates. Place the x, y integers into v2d by changing the values of v2d to hold x and y (Absolute assignment)
		this.xy.setX(x);
		this.xy.setY(y);
	}
	public Vector2D getSize() {
		return this.size;
	}
	public void setWidth(int width) {
		this.size.setX(width);
	}
	public void setHeight(int height) {
		this.size.setY(height);
	}
	public void setPlayerDirection(String direction) {
		this.playerDirection = direction;
	}
	public String getPlayerDirection() {
		return this.playerDirection;
	}
	
	public String toString(){
		// TODO: Create a "toString" method to test. Assume an x, y of 100, 50 and a tag of "star", this should return: [100, 50, star]
			// Remove my placeholder code below (which is there to prevent an error) and replace it with your proper toString method with specifications above
		String tempString = "[" + this.xy.getX() + ", " + this.xy.getY()+ ", " + this.getTag() + "]";
		return (tempString);
	}
}
