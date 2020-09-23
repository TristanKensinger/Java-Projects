import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public abstract class Collidable{
    private int x, y, w, h, hp, id;

    public boolean collides(Collidable c, int xoffset, int yoffset){
        if(
        getX()+getW()+xoffset > c.getX() && getX()+xoffset < c.getX()+c.getW() && 
        getY()+getH()+yoffset > c.getY() && getY()+yoffset < c.getY()+c.getH()
        )
            return true;
        return false;	
    }

    public boolean collides(ArrayList<Collidable> list, int xoffset, int yoffset){
        for(Collidable c : list){
            if(
            getX()+getW()+xoffset > c.getX() && getX()+xoffset < c.getX()+c.getW() && 
            getY()+getH()+yoffset > c.getY() && getY()+yoffset < c.getY()+c.getH()
            )
                return true;
        }
        return false;	
    }

    public boolean collides(Collidable grid[][], int xoffset, int yoffset){
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] != null)
                    if( 
                    getX()+getW()+xoffset > grid[r][c].getX() && getX()+xoffset < grid[r][c].getX()+grid[r][c].getW() && 
                    getY()+getH()+yoffset > grid[r][c].getY() && getY()+yoffset < grid[r][c].getY()+grid[r][c].getH()
                    )
                        return true;
            }
        }
        return false;	
    }

    public abstract void draw(Graphics2D g2, int xoffset, int yoffset);

    //getters
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }

    public int getHP(){
        return hp;
    }

    public int getId(){
        return id;
    }

    //setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setW(int w){
        this.w = w;
    }

    public void setH(int h){
        this.h = h;
    } 

    public void setHP(int hp){
        this.hp = hp;
    } 

    public void setId(int id){
        this.id = id;
    }
}