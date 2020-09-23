import java.awt.*;

public class Door extends Obstacle{
    String name = "door";
    public Door(int x, int y, int row, int col, int width, int height){
        super(x, y, row, col, width, height);
    }

    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

    public String getName(){
        return name;
    }
}

