package Tower_Defense;
import java.awt.*;
import javax.swing.*;

public class Sniper implements Tower{
    int row, col, delay;
    ImageIcon sniper;
    Image sniperPic;
    Color c;

    public Sniper(int row, int col){
        this.row = row;
        this.col = col;
        delay = 0;
        sniper = new ImageIcon(this.getClass().getResource("sniper.png"));
        sniperPic = sniper.getImage();
    }

    public void update(Balloon[][] grid, Money money){
        // 9 by 9 radius first balloon method
        delay++;
        Balloon b = null;
        if(delay == 2){
            delay = 0;
            for(int r=row-9; r<=row+9; r++){
                for(int c=col-9; c<=col+9; c++){
                    if(r >= 0 && r <= 29 && c >= 0 && c <= 29 && grid[r][c] != null){    
                        if(b == null || grid[r][c].getMovesMade() > b.getMovesMade()){
                            b = grid[r][c];
                        }
                    }
                }
            }
            if(b != null && b.getCamo() == true){
                b.setHp(b.getHp()-1);
                //money.setMoney(money.getMoney()+1);
            }
        }
    }

    public void draw(Graphics g, JPanel panel){
        //image tile
        g.drawImage(sniperPic, col*20, row*20, 20, 20, panel);
        //         //drawn tile
        //         c = new Color(0, 0, 255);
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