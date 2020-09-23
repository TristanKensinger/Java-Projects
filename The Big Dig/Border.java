import java.awt.*;

public class Border extends Collidable{
    public Border(int x, int y, int w, int h){
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setHP(2147483647);
        setId(2);
    }

    public void draw(Graphics2D g2, int xoffset, int yoffset){
        g2.setColor(Color.black);
        g2.fillRect(getX()+xoffset, getY()+yoffset, getW(), getH());
    }
}