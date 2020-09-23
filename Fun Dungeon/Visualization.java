import java.applet.Applet;
import java.awt.*;

public class Visualization extends Applet{
    int grid[][] = new int[15][15];	
    public void init(){
        this.resize(600,600);
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(r == 0 || c == 0 || r == grid.length-1 || c  == grid[0].length-1) 
                    grid[r][c] = 1;
                else
                    grid[r][c] = 0;
            }
        }
        int rowMid = grid.length/2, colMid = grid[0].length/2;
        grid[0][colMid] = 0;
        grid[grid.length-1][colMid] = 0;
        grid[rowMid][0] = 0;
        grid[rowMid][grid[0].length-1] = 0;
        //gavin's code
        grid[4][3] = 1;
        grid[4][4] = 1;
        grid[4][5] = 1;
        grid[9][5] = 1;
        grid[9][6] = 1;
        grid[9][7] = 1;
        grid[9][8] = 1;
        grid[2][11] = 1;
        grid[2][12] = 1;
        grid[12][11] = 1;
        grid[12][12] = 1;
        grid[12][2] = 1;
        grid[12][3] = 1;
        grid[12][4] = 1;
        grid[6][9] = 1;
        grid[6][10] = 1;
        grid[6][11] = 1;
    }

    public void paint(Graphics g){
        for(int r = 0; r < 15; r++){
            for(int c = 0; c < 15; c++){
                if(grid[r][c] == 0)
                    g.setColor(Color.white);
                if(grid[r][c] == 1)
                    g.setColor(Color.darkGray);
                g.fillRect(c*40,r*40,40,40);
            }
        }
    }
}