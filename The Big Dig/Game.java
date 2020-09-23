import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements Runnable, KeyListener{
    Thread main = new Thread(this);
    Player player = new Player(320,350,10,10);
    Collidable loaded[][] = new Collidable[45][37];
    Collidable map[][] = new Collidable[735][735];
    WorldGen worldGen = new WorldGen();
    boolean jump, right, left, fall, miningUp, miningRight, miningDown, miningLeft, inventory, game;
    long beginTime, endTime;
    double elapsedTime, fps = 0;
    int runCt = 0, t1 = 1, rowStart = 0, colStart = 349, xoffset = 0, yoffset = 1, playerYV = 0, floatTime = 0, mineSpeed = 1, money = 0, drillCost = 500, sizeCost = 2500;
    int collection[] = new int[10];

    public Game(){
        super.setDoubleBuffered(true);
        main.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        beginTime = System.currentTimeMillis();
        worldGen.generate(map);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;  
        if(!game){
            Color c = new Color(189,183,107);
            g2.setColor(c);
            g2.fillRect(0,0,700,700);
            g2.setColor(Color.blue);
            g2.fillRect(85,50,500,140);
            Font font = new Font("Times New Roman",30,90);
            g2.setFont(font);
            g2.setColor(Color.black);
            g2.drawString("The Big Dig",110,150);
            font = new Font("Times New Roman",30,30);
            g2.setFont(font);
            g2.drawString("Controls:",50,300);
            g2.drawString("WASD To Move",50,340);
            g2.drawString("Arrow Keys To Mine",50,380);
            g2.drawString("Space Bar To Jump",50,420);
            g2.drawString("Press ESC For Inventory",50,460);
            g2.drawString("Press Enter To Begin Game",50,500);
        }
        if(game){
            if(!inventory){
                Color color = new Color(0);
                if(rowStart > -1)
                    color = new Color(150,150,255);
                if(rowStart > 20)
                    color = new Color(210,180,140);
                if(rowStart > 200)
                    color = new Color(172,172,172);
                g2.setColor(color);
                g2.fillRect(0,0,700,700);
                player.draw(g2,0,0);
                for(int r=0; r<loaded.length; r++)
                    for(int c=0; c<loaded[0].length; c++)
                        if(loaded[r][c] != null)
                            loaded[r][c].draw(g2,xoffset,yoffset);
                g2.setColor(Color.black);
                g2.drawString(fps+"",5,10);
                g2.drawString("fps",45,10);
            }
            else{
                Color c = new Color(70,130,180);
                g2.setColor(c);
                g2.fillRect(0,0,700,700);
                c = new Color(255,165,0);
                g2.setColor(c);
                g2.fillRect(0,0,700,90);
                Font font = new Font("Times New Roman",30,60);
                g2.setFont(font);
                g2.setColor(Color.black);
                g2.drawString("Inventory",230,60);
                font = new Font("Times New Roman",30,30);
                g2.setFont(font);
                c = new Color(0,255,0);
                g2.setColor(c);
                g2.drawString("Money:",300,160);
                c = new Color(0,0,255);
                g2.setColor(c);
                g2.drawString("Current Mining Speed:",300,260);
                c = new Color(255,0,255);
                g2.setColor(c);
                g2.drawString("Current Player Size:",300,480);
                g2.setColor(Color.black);
                g2.drawString("Press H To Sell Your Resources",300,130);
                g2.drawString("Press J To Buy Next Drill",300,230);
                g2.drawString("Press K To Teleport To Spawn",300,360);
                g2.drawString("Press L To Increase Player Size",300,450);
                g2.drawString(player.getW()+"",545,480);
                g2.drawString("Cost To Increase Size: "+sizeCost+"$",300,510);
                g2.drawString("Cost To Teleport: 5000$",300,390);
                g2.drawString("Cost To Teleport: 5000$",300,390);
                g2.drawString("Next Drill Costs "+drillCost+"$",300,290);
                g2.drawString(mineSpeed+"",585,260);
                g2.drawString(money+"",410,160);
                g2.drawLine(280,90,280,700);
                //resources
                g2.drawString("Grass: "+collection[0],100,130);
                g2.drawString("Rock: "+collection[1],100,160);
                g2.drawString("Border: "+collection[2],100,190);
                g2.drawString("Coal: "+collection[3],100,220);
                g2.drawString("Dirt: "+collection[4],100,250);
                g2.drawString("Amethyst: "+collection[5],100,280);
                g2.drawString("Diamond: "+collection[6],100,310);
                g2.drawString("Ruby: "+collection[7],100,340);
                g2.drawString("Emerald: "+collection[8],100,370);
                g2.drawString("Diorite: "+collection[9],100,400);
                //prices
                c = new Color(255,0,0);
                g2.setColor(c);
                font = new Font("Times New Roman",10,15);
                g2.setFont(font);
                g2.drawString("2$",0,130);
                g2.drawString("3$",0,160);
                g2.drawString("2147483647$",0,190);
                g2.drawString("100$",0,220);
                g2.drawString("1$",0,250);
                g2.drawString("500$",0,280);
                g2.drawString("1000$",0,310);
                g2.drawString("2000$",0,340);
                g2.drawString("5000$",0,370);
                g2.drawString("6$",0,400);
            }
        }
    }

    public void run(){
        while(true){
            repaint();
            if(game){
                endTime = System.currentTimeMillis();
                elapsedTime = (endTime-beginTime)/1000.0;
                runCt++;
                if(elapsedTime > t1){
                    fps = runCt;
                    t1++;
                    runCt = 0;
                }
                try{main.sleep(5);}catch(Exception e){}
                //loaded screen update
                if(!inventory){
                    int rowIndex = -1;
                    int columnIndex = -1;
                    for(int r=rowStart; r<rowStart+45; r++){
                        rowIndex++;
                        columnIndex = -1;
                        for(int c=colStart; c<colStart+37; c++){
                            columnIndex++;
                            loaded[rowIndex][columnIndex] = map[r][c];
                            if(map[r][c] != null && map[r][c].getHP() <= 0){
                                collection[map[r][c].getId()]++;
                                map[r][c] = null;
                            }
                        }
                    }
                    //future collides optimization !!!
                    if(right && !player.collides(loaded,-1*(xoffset-1),-1*(yoffset)) && xoffset > -7000){
                        xoffset--;
                    }
                    if(left && !player.collides(loaded,-1*(xoffset+1),-1*(yoffset)) && xoffset < 7000){
                        xoffset++;
                    }
                    if(xoffset%20 == 0){
                        colStart = 349;
                        colStart += (-1*xoffset)/20;
                    }
                    if(jump){
                        if(!player.collides(loaded,-1*(xoffset),-1*(yoffset+playerYV))){
                            yoffset += playerYV;
                            if(floatTime % 10 == 0){
                                playerYV--;
                            }
                            floatTime--;
                            if(playerYV == -7)
                                jump = false;
                        }
                        else jump = false;
                    }
                    if(!jump && !player.collides(loaded,-1*(xoffset),-1*(yoffset-1))){
                        yoffset-=1;
                        fall = true;
                    }
                    else fall = false;
                    if(yoffset%20 == 0){
                        rowStart = 0;
                        if(rowStart+(-1*yoffset)/20 > -1)
                            rowStart += (-1*yoffset)/20;
                    }
                    for(int r=0; r<loaded.length; r++){
                        for(int c=0; c<loaded[0].length; c++){
                            if(loaded[r][c] != null){
                                if(miningUp){
                                    if(player.collides(loaded[r][c],-1*(xoffset),-1*(yoffset+30)))
                                        loaded[r][c].setHP(loaded[r][c].getHP()-mineSpeed);
                                }
                                if(miningRight){
                                    if(player.collides(loaded[r][c],-1*(xoffset-1),-1*(yoffset)))
                                        loaded[r][c].setHP(loaded[r][c].getHP()-mineSpeed);
                                }
                                if(miningDown){
                                    if(player.collides(loaded[r][c],-1*(xoffset),-1*(yoffset-1)))
                                        loaded[r][c].setHP(loaded[r][c].getHP()-mineSpeed);
                                }
                                if(miningLeft){
                                    if(player.collides(loaded[r][c],-1*(xoffset+1),-1*(yoffset)))
                                        loaded[r][c].setHP(loaded[r][c].getHP()-mineSpeed);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void keyPressed(KeyEvent e){
        int code=e.getKeyCode();
        if(game){
            if(!inventory){
                if(code==e.VK_SPACE){
                    if(!jump && !fall){
                        jump = true;
                        playerYV = 7;
                        floatTime = 100;
                    }
                } 
                if(code==e.VK_D){
                    right = true;
                } 
                if(code==e.VK_A){
                    left = true;
                } 
                //mining
                if(code==e.VK_UP){
                    miningUp = true;
                } 
                if(code==e.VK_RIGHT){
                    miningRight = true;
                } 
                if(code==e.VK_DOWN){
                    miningDown = true;
                } 
                if(code==e.VK_LEFT){
                    miningLeft = true;
                }
            } 
        }
    }

    public void keyReleased(KeyEvent e){
        int code=e.getKeyCode();
        if(!game){
            if(code==e.VK_ENTER){
                game = true;
            }
        }
        if(game){
            if(code==e.VK_ESCAPE){
                inventory = !inventory;
            } 
            if(inventory){
                if(code==e.VK_H){
                    for(int i=0; i<collection.length; i++){
                        if(i == 0) money += collection[i]*2;
                        if(i == 1) money += collection[i]*3;
                        if(i == 2) money += collection[i]*2147483647;
                        if(i == 3) money += collection[i]*100;
                        if(i == 4) money += collection[i]*1;
                        if(i == 5) money += collection[i]*500;
                        if(i == 6) money += collection[i]*1000;
                        if(i == 7) money += collection[i]*2000;
                        if(i == 8) money += collection[i]*5000;
                        if(i == 9) money += collection[i]*6;
                        collection[i] = 0;
                    }
                } 
                if(code==e.VK_J){
                    if(money - drillCost >= 0){
                        money -= drillCost;
                        mineSpeed++;
                        drillCost += 500;
                    }
                }
                if(code==e.VK_K){
                    if(money - 5000 >= 0){
                        money -= 5000;
                        yoffset = 0 + player.getH();;
                        xoffset = 0;
                        rowStart = 0;
                        colStart = 349;
                    }
                }
                if(code==e.VK_L){
                    if(money - sizeCost >= 0){
                        money -= sizeCost;
                        sizeCost += 2500;
                        player.setW(player.getW()+10);
                        player.setH(player.getH()+10);
                        yoffset += 10;
                    }
                }
            }
            if(!inventory){
                if(code==e.VK_D){
                    right = false;
                } 
                if(code==e.VK_A){
                    left = false;
                } 
                //mining
                if(code==e.VK_UP){
                    miningUp = false;
                } 
                if(code==e.VK_RIGHT){
                    miningRight = false;
                } 
                if(code==e.VK_DOWN){
                    miningDown = false;
                } 
                if(code==e.VK_LEFT){
                    miningLeft = false;
                } 
            }
        }
    }

    public void keyTyped(KeyEvent e){}
}