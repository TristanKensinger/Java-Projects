import java.awt.*;

public class Emerald extends Collidable{
    int r[][] = new int[10][10];
    public Emerald(int x, int y, int w, int h){
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setHP(2000);
        setId(8);
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                double n = Math.random();
                if(n < .5)
                    r[i][j] = 0;
                else
                    r[i][j] = 1;
            }
        }
    }

    public void draw(Graphics2D g2, int xoffset, int yoffset){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(r[i][j] == 0)
                    g2.setColor(Color.gray);
                else{
                    Color c = new Color(0,255,0);
                    g2.setColor(c);
                }
                g2.fillRect((getX()+xoffset)+(i*2), (getY()+yoffset)+(j*2), 2, 2);
            }
        }
    }
}