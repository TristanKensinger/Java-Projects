import java.awt.*;

public class Bullet extends Obstacle{
    String name = "bullet";
    private int xv, yv;
    public Bullet(int x, int y, int row, int col, int width, int height, int xv, int yv){
        super(x, y, row, col, width, height);
        this.xv = xv;
        this.yv = yv;
    }

    public void update(){
        setX(getX() + xv);
        setY(getY() + yv);
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public String getName(){
        return name;
    }

    //getters
    public int getXV(){
        return xv;
    }

    public int getYV(){
        return yv;
    }

    //setters
    public void setXV(int xv){
        this.xv = xv;
    }

    public void setYV(int yv){
        this.yv = yv;
    }
}