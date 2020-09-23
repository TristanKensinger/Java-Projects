import java.awt.*;

public class Player extends Obstacle{
    String name = "player";
    int health, immunityFrames = 0;
    public Player(int x, int y, int row, int col, int width, int height, int health){
        super(x, y, row, col, width, height);
        this.health = health;
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getImmunityFrames(){
        return immunityFrames;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setImmunityFrames(int immunityFrames){
        this.immunityFrames = immunityFrames;
    }
}