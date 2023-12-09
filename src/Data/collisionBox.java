package Data;

public class collisionBox {
    private int x1, x2, y1, y2;
    private Boolean canCollide, isInteractable;
    private String dialog;

    public collisionBox(int _x1, int _y1, int _x2, int _y2, Boolean _canCollide, Boolean _isInteractable, String _dialog){
        this.x1 = _x1; this.x2 = _x2; this.y1 = _y1; this.y2 = _y2;
        this.canCollide = _canCollide; this.isInteractable = _isInteractable;
        this.dialog = _dialog;
    }
    public collisionBox(spriteInfo sprite, Boolean _canCollide, Boolean _isInteractable, String _dialog){
        this.x1 = sprite.getCoords().getX();
        this.y1 = sprite.getCoords().getY();
        this.x2 = sprite.getCoords().getX() + sprite.getSize().getX();
        this.y2 = sprite.getCoords().getY() + sprite.getSize().getY();
        this.canCollide = _canCollide; this.isInteractable = _isInteractable;
        this.dialog = _dialog;
    }
    public void setX1(int _x1){
        this.x1 = _x1;
    }
    public void setX2(int _x2){
        this.x2 = _x2;
    }
    public void setY1(int _y1){
        this.y1 = _y1;
    }
    public void setY2(int _y2){
        this.y2 = _y2;
    }
    public void setCanCollide(Boolean _canCollide){
        this.canCollide = _canCollide;
    }
    public void setIsInteractable(Boolean _isInteractable){
        this.isInteractable = _isInteractable;
    }
    public void setDialog(String _dialog){
        this.dialog = _dialog;
    }
    public int getX1(){
        return this.x1;
    }
    public int getX2(){
        return this.x2;
    }
    public int getY1(){
        return this.y1;
    }
    public int getY2(){
        return this.y2;
    }
    public Boolean getCanCollide(){
        return this.canCollide;
    }
    public Boolean isInteractable(){
        return this.isInteractable;
    }
    public String getDialog(){
        return this.dialog;
    }
    public String getCoords(){
        return ("x1: " + this.x1 + " y1: " + this.y1 + " x2: " + this.x2 + " y2: " + this.y2);
    }
}
