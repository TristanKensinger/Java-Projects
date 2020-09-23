import java.awt.*;

public abstract class Obstacle{
    private int x, y;
    private int width, height;
    public Obstacle(int x, int y, int row, int col, int width, int height){
        if(x == -1 || y == -1){
            this.x = col*40;
            this.y = row*40;
        }
        else{
            this.x = x;
            this.y = y;
        }
        this.width = width;
        this.height = height;
    }

    public boolean collides(Obstacle obs, int xOffset, int yOffset){
        if(
        x+width+xOffset >= obs.getX() &&
        x+xOffset <= obs.getX()+obs.getWidth() &&
        y+height+yOffset >= obs.getY() &&
        y+yOffset <= obs.getY()+obs.getHeight()
        )
            return true;
        return false;
    }

    public abstract void draw(Graphics g);
    
    public abstract String getName();
        
    //getters
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
    
    //setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }
}