import java.awt.*;

public class Rock extends Collidable{
    public Rock(int x, int y, int w, int h){
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setHP(80);
        setId(1);
    }

    public void draw(Graphics2D g2, int xoffset, int yoffset){
        g2.setColor(Color.gray);
        g2.fillRect(getX()+xoffset, getY()+yoffset, getW(), getH());
    }
}