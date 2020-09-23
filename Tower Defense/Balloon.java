package Tower_Defense;
import java.awt.*;

public class Balloon{
    int row, col, hp, movesMade;
    int prevRow, prevCol;
    boolean camo;
    Color c;

    public Balloon(int row, int col, int hp, boolean camo){
        this.row = row;
        this.col = col;
        prevRow = -1;
        prevCol = -1;
        this.hp = hp;
        movesMade = 0;
        this.camo = camo;
    }

    public void update(int[][] grid){
        //up
        if(row != 0 && grid[row-1][col] == 1 && row-1 != prevRow){
            prevRow = row;
            prevCol = col;
            row--;
            movesMade++;
        }
        //right
        else if(col != 29 && grid[row][col+1] == 1 && col+1 != prevCol){
            prevCol = col;
            prevRow = row;
            col++;
            movesMade++;
        }
        //down
        else if(row != 29 && grid[row+1][col] == 1 && row+1 != prevRow){
            prevRow = row;
            prevCol = col;
            row++;
            movesMade++;
        }
        //left
        else if(col != 0 && grid[row][col-1] == 1 && col-1 != prevCol){
            prevCol = col;
            prevRow = row;
            col--;
            movesMade++;
        }
    }

    public void draw(Graphics g){
        if(hp == 1){
            c = new Color(255, 0, 0);
            g.setColor(c);
            if(!camo)
                g.fillOval(col*20+5, row*20+5, 10, 10);
            else
                g.fillRect(col*20+5, row*20+5, 10, 10);
        }
        if(hp == 2){
            c = new Color(0, 0, 255);
            g.setColor(c);
            if(!camo)
                g.fillOval(col*20+5, row*20+5, 10, 10);
            else
                g.fillRect(col*20+5, row*20+5, 10, 10);
        }
        if(hp == 3){
            c = new Color(0, 255, 0);
            g.setColor(c);
            if(!camo)
                g.fillOval(col*20+5, row*20+5, 10, 10);
            else
                g.fillRect(col*20+5, row*20+5, 10, 10);
        }
        if(hp == 4){
            c = new Color(244, 244, 66);
            g.setColor(c);
            if(!camo)
                g.fillOval(col*20+5, row*20+5, 10, 10);
            else
                g.fillRect(col*20+5, row*20+5, 10, 10);
        }
        if(hp == 5){
            c = new Color(241, 65, 244);
            g.setColor(c);
            if(!camo)
                g.fillOval(col*20+5, row*20+5, 10, 10);
            else
                g.fillRect(col*20+5, row*20+5, 10, 10);
        }
        if(hp == 6){
            c = new Color(0, 0, 0);
            g.setColor(c);
            if(!camo)
                g.fillOval(col*20+5, row*20+5, 10, 10);
            else
                g.fillRect(col*20+5, row*20+5, 10, 10);
        }
        if(hp == 7){
            c = new Color(255, 255, 255);
            g.setColor(c);
            if(!camo)
                g.fillOval(col*20+5, row*20+5, 10, 10);
            else
                g.fillRect(col*20+5, row*20+5, 10, 10);
        }
    }

    //getters
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int getHp(){
        return hp;
    }

    public int getMovesMade(){
        return movesMade;
    }

    public boolean getCamo(){
        return camo;
    }

    //setters
    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void setMovesMade(int movesMade){
        this.movesMade = movesMade;
    }

    public void setCamo(boolean camo){
        this.camo = camo;
    }
}