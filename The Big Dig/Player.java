import java.awt.*;

public class Player extends Collidable{
    public Player(int x, int y, int w, int h){
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setHP(5);
    }

    public void draw(Graphics2D g2, int xoffset, int yoffset){
        g2.setColor(Color.blue);
        g2.fillRect(getX()+xoffset, getY()+yoffset, getW(), getH());
    }
}