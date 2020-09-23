package Tower_Defense;
import java.awt.*;
import javax.swing.*;

public class TackShooter implements Tower{
    int row, col, delay;
    ImageIcon tack;
    Image tackPic;
    Color c;

    public TackShooter(int row, int col){
        this.row = row;
        this.col = col;
        delay = 0;
        tack = new ImageIcon(this.getClass().getResource("Tack Shooter.png"));
        tackPic = tack.getImage();
    }

    public void update(Balloon[][] grid, Money money){
        // 3 by 3 radius method
        delay++;
        if(delay == 25){
            delay = 0;
            for(int r=row-1; r<=row+1; r++){
                for(int c=col-1; c<=col+1; c++){
                    if(r >= 0 && r <= 29 && c >= 0 && c <= 29 && grid[r][c] != null && grid[r][c].getCamo() == false){
                        //                         if(grid[r][c].getHp() <= 3)
                        //                             money.setMoney(money.getMoney()+grid[r][c].getHp());
                        //                         else
                        //                             money.setMoney(money.getMoney()+3);
                        grid[r][c].setHp(grid[r][c].getHp()-3);
                    }
                }
            }
            //4 tiles method
            //             //up
            //             if(row-1 >= 0 && grid[row-1][col] != null){
            //                 grid[row-1][col].setHp(grid[row-1][col].getHp()-3);
            //                 money.setMoney(money.getMoney()+1);
            //             }
            //             //right
            //             if(col+1 <= 29 && grid[row][col+1] != null){
            //                 grid[row][col+1].setHp(grid[row][col+1].getHp()-3);
            //                 money.setMoney(money.getMoney()+1);
            //             }
            //             //down
            //             if(row+1 <= 29 && grid[row+1][col] != null){
            //                 grid[row+1][col].setHp(grid[row+1][col].getHp()-3);
            //                 money.setMoney(money.getMoney()+1);
            //             }
            //             //left
            //             if(col-1 >= 0 && grid[row][col-1] != null){
            //                 grid[row][col-1].setHp(grid[row][col-1].getHp()-3);
            //                 money.setMoney(money.getMoney()+1);
            //             }
        }
    }

    public void draw(Graphics g, JPanel panel){
        //image tile
        g.drawImage(tackPic, col*20, row*20, 20, 20, panel);
        //         //drawn tile
        //         c = new Color(206, 84, 47);
        //         g.setColor(c);
        //         g.fillRect(col*20+1, row*20+1, 18, 18);
    }

    //getters
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    //setters
    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }
}