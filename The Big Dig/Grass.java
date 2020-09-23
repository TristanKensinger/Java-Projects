import java.awt.*;

public class Grass extends Collidable{
    public Grass(int x, int y, int w, int h){
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setHP(40);
        setId(0);
    }

    public void draw(Graphics2D g2, int xoffset, int yoffset){
        g2.setColor(Color.green);
        g2.fillRect(getX()+xoffset, getY()+yoffset, getW(), getH());
    }
}