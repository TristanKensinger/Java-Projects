import java.awt.*;

public class Diorite extends Collidable{
    int r[][] = new int[20][20];
    public Diorite(int x, int y, int w, int h){
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setHP(160);
        setId(9);
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                double n = Math.random();
                if(n < .9)
                    r[i][j] = 0;
                else
                    r[i][j] = 1;
            }
        }
    }

    public void draw(Graphics2D g2, int xoffset, int yoffset){
       for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                if(r[i][j] == 0)
                    g2.setColor(Color.white);
                else{
                    g2.setColor(Color.gray);
                }
                g2.fillRect((getX()+xoffset)+(i*1), (getY()+yoffset)+(j*1), 1, 1);
            }
        }
    }
}