package Tower_Defense;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Wave{
    ArrayList<Balloon> balloons;
    ArrayList<Tower> towers;
    WaveCreate waveCreate = new WaveCreate();
    int waveNum, balloonsMade, balloonsAlive, hp = 100;
    boolean waveOn, startWaveBtn;
    Color c;
    Font f;

    public Wave(int waveNum, boolean waveOn){
        this.waveNum = waveNum;
        this.waveOn = waveOn;
        balloons = new ArrayList<Balloon>();
        towers = new ArrayList<Tower>();
    }

    public void startNextWave(){
        waveOn = true;
        startWaveBtn = false;
        balloonsMade = -1;
        balloonsAlive = -1;
        waveCreate.updateWaveNum();
        waveNum++;
    }

    public void update(int[][] grid, Money money){
        if(waveOn){
            //balloon creation
            if(waveCreate.getBalloonsLeft()){
                waveCreate.addNextBalloon(balloons);
                balloonsMade++;
                balloonsAlive++;
            }
            //tower update
            for(Tower t : towers)
                t.update(balloonGrid(balloons), money);
            //balloon death
            int b = 0;
            while(b < balloons.size()){
                balloons.get(b).update(grid);
                if(balloons.get(b).getRow() == 29 && balloons.get(b).getCol() == 29){
                    hp -= balloons.get(b).getHp();
                    balloons.remove(b);
                    balloonsAlive--;
                }
                else if(balloons.get(b).getHp() <= 0){
                    balloons.remove(b);
                    money.setMoney(money.getMoney()+1);
                    balloonsAlive--;
                }
                else
                    b++;
            }
            //end of wave
            if(!waveCreate.getBalloonsLeft() && balloonsAlive == 0){
                waveOn = false;
                startWaveBtn = true;
            }
        }
    }

    public void draw(Graphics g, boolean tackBool, boolean gunnerBool, boolean sniperBool, Money money, JPanel panel){
        //wave number
        c = new Color(0, 0, 0);
        f = new Font("Arial", 0, 25);
        g.setFont(f);
        g.setColor(c);
        g.drawString("Wave: "+waveNum, 615, 125);   
        //hp
        g.drawString("HP: "+hp, 615, 175); 
        //money
        g.drawString("Money: "+money.getMoney(), 615, 225); 
        //wave on
        f = new Font("Arial", 0, 15);
        g.setFont(f);
        g.drawString("waveOn: "+waveOn, 615, 275);  
        //ballons made
        g.drawString("balloonsMade: "+balloonsMade, 615, 300); 
        //ballons alive
        g.drawString("balloonsAlive: "+balloonsAlive, 615, 325); 
        //tackBool
        g.drawString("tackBool: "+tackBool, 740, 380); 
        //gunnerBool
        g.drawString("gunnerBool: "+gunnerBool, 740, 455); 
        //sniperBool
        g.drawString("sniperBool: "+sniperBool, 740, 530); 
        //balloons
        for(Balloon b : balloons)
            b.draw(g);
        //towers
        for(Tower t : towers)
            t.draw(g, panel);
    }

    public Balloon[][] balloonGrid(ArrayList<Balloon> balloons){
        Balloon[][] grid = new Balloon[30][30];
        for(Balloon b : balloons)
            grid[b.getRow()][b.getCol()] = b;
        return grid;
    }

    public void addTower(Tower tower){
        towers.add(tower);
    }

    public boolean getStartWaveBtn(){
        return startWaveBtn;
    }
}