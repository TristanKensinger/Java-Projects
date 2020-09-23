import java.awt.*;

public class Dirt extends Collidable{
    public Dirt(int x, int y, int w, int h){
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setHP(20);
        setId(4);
    }

    public void draw(Graphics2D g2, int xoffset, int yoffset){
        Color c = new Color(139,69,19);
        g2.setColor(c);
        g2.fillRect(getX()+xoffset, getY()+yoffset, getW(), getH());
    }
}