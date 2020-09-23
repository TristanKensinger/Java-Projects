import java.awt.*;

public class Wall extends Obstacle{
    String name = "wall";
    public Wall(int x, int y, int row, int col, int width, int height){
        super(x, y, row, col, width, height);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

    public String getName(){
        return name;
    }
}