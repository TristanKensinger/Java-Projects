import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.util.Random;
//Tristan Kensinger
//5-26-17

public class NinjaJumper extends Applet implements Runnable, MouseListener, KeyListener 
{
    Thread main= new Thread (this);
    Image buffer, playerStand, BG1, BG2, BG3;
    boolean standR=true, standL=false, right=false, left=false, jump=false, fall=false;
    Graphics bufferG;
    Font HomeScreen =new Font("Times New Roman",3,50);
    Font Normal =new Font("Times New Roman",3,30);
    int pg=0, mouseX, mouseY, room=999, roomCt=0, background=1;
    Random rand = new Random ();
    AnimMovePic player;
    Image[] playerwalk= new Image[10];
    Image[] playerjump= new Image[1];
    long beginTime, endTime;
    double elapsedTime;
    String output="";

    public void init()
    {
        this.setLayout(null);
        this.resize(1400,750);
        this.addMouseListener(this);
        this.addKeyListener(this);
        buffer = createImage(this.getWidth(),this.getHeight());
        bufferG=buffer.getGraphics();

        BG1=getImage(this.getCodeBase(),"ninjaBG1.png");//https://clipartfest.com/categories/view/1de193b8144975a9a856a7daf64e8f6e9b25b389/cartoon-dojo-background.html
        BG2=getImage(this.getCodeBase(),"ninjaBG2.jpg");//https://clipartfest.com/categories/view/8bb5d92a76c4b8faaad8e86cef9471922dbe1e35/cartoon-bamboo-forest.html
        BG3=getImage(this.getCodeBase(),"ninjaBG3.jpg");//http://www.animalhi.com/Birds/birds/birds_japanese_pigeons_sparrow_artwork_kitagawa_utamaro_1440x902_wallpaper_25388/download_2560x1600

        playerwalk[0]=getImage(this.getCodeBase(),"ninjaRun1.png");//http://www.gameart2d.com/freebies.html
        playerwalk[1]=getImage(this.getCodeBase(),"ninjaRun2.png");//All ninja pics were from the site listed above
        playerwalk[2]=getImage(this.getCodeBase(),"ninjaRun3.png");
        playerwalk[3]=getImage(this.getCodeBase(),"ninjaRun4.png");
        playerwalk[4]=getImage(this.getCodeBase(),"ninjaRun5.png");
        playerwalk[5]=getImage(this.getCodeBase(),"ninjaRun6.png");
        playerwalk[6]=getImage(this.getCodeBase(),"ninjaRun7.png");
        playerwalk[7]=getImage(this.getCodeBase(),"ninjaRun8.png");
        playerwalk[8]=getImage(this.getCodeBase(),"ninjaRun9.png");
        playerwalk[9]=getImage(this.getCodeBase(),"ninjaRun10.png");
        playerjump[0]=getImage(this.getCodeBase(),"ninjaJump.png");
        playerStand=getImage(this.getCodeBase(),"ninjaStand.png");

        player=new AnimMovePic(playerwalk,50,0,525,0,0);
        player.setAlive(true);
        player.start();
        main.start();
    }

    public void run()
    {
        while(true)
        {
            repaint();
            if(pg==2 && roomCt<5)
            {
                endTime=System.currentTimeMillis();
                elapsedTime=(endTime-beginTime)/1000.0;
            }
            try
            {
                main.sleep(50);
            }
            catch(Exception e){}
            if(jump || fall)
            {
                player.setYChange(player.getYChange()+5);
                if(player.getY()>=525)
                {
                    jump=false;
                    fall=false;
                    if(right || left)
                    {
                        player.setImages(playerwalk);
                        player.setFrameCt(0);
                    }
                    player.setY(525);
                    player.setYChange(0);
                }
            }
            if(player.getX()>1350)
            {
                room = rand.nextInt(3);
                player.setX(0);
                player.setY(525);
                roomCt++;
                background = rand.nextInt(3)+1;
                if(roomCt==5)
                {
                    pg=3;
                    player.setAlive(false);
                    endTime=System.currentTimeMillis();
                    elapsedTime=(endTime-beginTime)/1000.0;
                    output=(elapsedTime+"");
                }
            }
            if(player.getX()<0)
                player.setX(0);
            ///
            Rectangle playerFeet = new Rectangle(player.getX(),player.getY()+75,50,50);
            Rectangle playerHead = new Rectangle(player.getX(),player.getY(),50,75);
            ///
            Rectangle r0_1 = new Rectangle(0,450,300,50);
            Rectangle r0_2 = new Rectangle(400,250,100,400);
            Rectangle r0_3 = new Rectangle(500,625,325,25);     
            Rectangle r0_4 = new Rectangle(825,600,250,50);
            Rectangle r0_5 = new Rectangle(900,0,100,450);
            ///
            Rectangle r1_1 = new Rectangle(100,600,100,50);
            Rectangle r1_2 = new Rectangle(500,575,100,75);
            Rectangle r1_3 = new Rectangle(950,550,100,100);
            Rectangle r1_4 = new Rectangle(200,635,1200,15);
            ///
            Rectangle r2_1 = new Rectangle(600,0,150,650);
            Rectangle r2_2 = new Rectangle(450,450,150,50);
            Rectangle r2_3 = new Rectangle(0,300,150,50);
            Rectangle r2_4 = new Rectangle(450,150,150,50);
            Rectangle r2_5 = new Rectangle(525,100,50,50);
            Rectangle r2_6 = new Rectangle(750,140,150,50);
            Rectangle r2_7 = new Rectangle(1200,275,250,75);
            Rectangle r2_8 = new Rectangle(1325,0,100,340);
            Rectangle r2_9 = new Rectangle(750,635,450,15);
            Rectangle r2_10 = new Rectangle(1200,600,250,50);
            ///
            if(room==0)
            {
                if(playerFeet.intersects(r0_1) && player.getY()<425)
                {
                    player.setYChange(0); 
                    player.setY(325);
                    jump=false;
                    fall=false;
                }
                if(player.getY()==325 && player.getX()>290)
                    fall=true;
                if(playerHead.intersects(r0_1) && jump==true)
                {
                    player.setYChange(0);
                    player.setY(505);
                }
                ///
                if(playerFeet.intersects(r0_2) && player.getY()<200)
                {
                    player.setYChange(0); 
                    player.setY(125);
                    jump=false;
                    fall=false;
                }
                if(player.getY()==125 && player.getX()<350 && !jump || player.getY()==125 && player.getX()>495  && !jump)
                    fall=true;
                if(playerHead.intersects(r0_2) && player.getX()<425)
                    player.setX(350);
                if(playerHead.intersects(r0_2) && player.getX()>450)
                    player.setX(510);
                ///
                if(playerFeet.intersects(r0_3))
                {
                    player.setX(0);
                    player.setY(525);
                }
                ///
                if(playerFeet.intersects(r0_4))
                {
                    player.setY(475);
                    player.setYChange(0); 
                    jump=false;
                    fall=false;
                }
                if(player.getY()==475 && player.getX()<775 && !jump || player.getY()==475 && player.getX()>1075 && !jump)
                    fall=true;
                ///
                if(playerHead.intersects(r0_5) && jump==true && player.getY()>350)
                {
                    player.setYChange(0);
                    player.setY(455);
                }
                if(playerHead.intersects(r0_5) && player.getX()<925)            
                    player.setX(850);
                if(playerHead.intersects(r0_5) && player.getX()>975)            
                    player.setX(1010);
            }
            ///
            if(room==1)
            {
                if(playerFeet.intersects(r1_1) && player.getX()<250 && player.getX()>50)
                {
                    player.setYChange(0); 
                    player.setY(475);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==475 && player.getX()<50 && !jump || player.getY()==475 && player.getX()>200  && !jump)
                    fall=true;
                ///
                if(playerFeet.intersects(r1_2) && player.getX()<650 && player.getX()>450)
                {
                    player.setYChange(0); 
                    player.setY(450);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==450 && player.getX()<450 && !jump || player.getY()==450 && player.getX()>600  && !jump)
                    fall=true;
                ///
                if(playerFeet.intersects(r1_3) && player.getX()<1100 && player.getX()>900)
                {
                    player.setYChange(0); 
                    player.setY(425);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==425 && player.getX()<900 && !jump || player.getY()==425 && player.getX()>1050  && !jump)
                    fall=true;
                ///
                if(playerFeet.intersects(r1_4))
                {
                    player.setX(0);
                    player.setY(525);
                }    
            }
            ///
            if(room==2)
            {
                if(playerHead.intersects(r2_1) && player.getX()<600)
                    player.setX(545);
                if(playerHead.intersects(r2_1) && player.getX()>700)
                    player.setX(760);
                ///
                if(playerHead.intersects(r2_2))
                {
                    player.setY(505);
                    player.setYChange(0);
                }
                if(playerFeet.intersects(r2_2))
                {
                    player.setYChange(0); 
                    player.setY(325);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==325 && player.getX()<405)
                    fall=true;
                ///
                if(playerHead.intersects(r2_3))
                {
                    player.setY(355);
                    player.setYChange(0);
                }
                if(playerFeet.intersects(r2_3))
                {
                    player.setYChange(0); 
                    player.setY(175);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==175 && player.getX()>145 && player.getX()<700)
                    fall=true;
                ///
                if(playerHead.intersects(r2_4))
                {
                    player.setY(205);
                    player.setYChange(0);
                }
                if(playerFeet.intersects(r2_4))
                {
                    player.setYChange(0); 
                    player.setY(25);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==25 && player.getX()<405)
                    fall=true;
                ///
                if(playerFeet.intersects(r2_5))
                {
                    player.setY(15);
                    player.setX(775);
                }
                ///
                if(playerFeet.intersects(r2_6))
                {
                    player.setY(15); 
                    player.setYChange(0);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==15 && player.getX()>895 && player.getX()<1000)
                    fall=true;
                if(playerHead.intersects(r2_6))
                {
                    player.setYChange(0);
                    player.setY(195);
                }
                ///
                if(playerFeet.intersects(r2_7))
                {
                    player.setY(150); 
                    player.setYChange(0);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==150 && player.getX()<1155)
                    fall=true;
                if(playerHead.intersects(r2_7) && player.getY()>345)
                {
                    player.setYChange(0);
                    player.setY(355);
                }
                ///
                if(playerHead.intersects(r2_8))
                    player.setX(1265);
                ///
                if(playerFeet.intersects(r2_9))
                {
                    player.setX(0);
                    player.setY(525);
                }
                ///
                if(playerFeet.intersects(r2_10))
                {
                    player.setY(475);  
                    player.setYChange(0);
                    jump=false;
                    fall=false; 
                }
                if(player.getY()==475 && player.getX()<1155)
                    fall=true;
            }
        }

    }

    public void paint (Graphics g)
    {
        bufferG.setColor(Color.cyan);
        bufferG.fillRect(0,0,1400,750);
        ///
        if(background==1)
            bufferG.drawImage(BG1,0,0,1400,750,this);
        if(background==2)
            bufferG.drawImage(BG2,0,0,1400,750,this);
        if(background==3)
            bufferG.drawImage(BG3,0,0,1400,750,this);
        ///
        if(pg==0)
        {
            bufferG.setColor(Color.red);
            bufferG.fillRect(50,0,560,75);
            bufferG.fillRect(1175,50,125,75);
            bufferG.fillRect(1175,250,125,75);
            bufferG.setFont(HomeScreen);
            bufferG.setColor(Color.black);
            bufferG.drawString("Start",1187,105);
            bufferG.drawString("Rules",1180,305);
            bufferG.drawString("Welcome to NinjaJumper",75,50);  
        }

        if(pg==1)
        {
            bufferG.setFont(HomeScreen);
            bufferG.setColor(Color.red);
            bufferG.fillRect(40,0,150,75);
            bufferG.fillRect(40,175,1050,450);
            bufferG.fillRect(1175,550,130,75);
            bufferG.setColor(Color.black); 
            bufferG.drawString("Rules",50,50);
            bufferG.drawString("Home",1178,605);
            bufferG.setFont(Normal);
            bufferG.drawString("The goal of the game is to complete 5 levels in the fastest time possible.",65,200);
            bufferG.drawString("The controls are the arrow keys. If you ever are having troubles jumping",65,250);
            bufferG.drawString("just hold the up key. For large jumps and mid air manuvering you can do 2 things.",65,300);
            bufferG.drawString("First you can rapidly hit the left or right arrow in air to flutter,",65,350);
            bufferG.drawString("or the better method of walking of an edge and then jumping, this allows",65,400);
            bufferG.drawString("you to essentially double jump. Have fun!!!",65,450);
        }

        if(pg==2)
        {
            bufferG.setColor(Color.white);
            bufferG.fillRect(40,10,450,100);
            bufferG.setColor(Color.black);
            bufferG.drawString("Rooms Completed  " + roomCt,50,50);
            bufferG.drawString(elapsedTime+"",50,100);
            ///
            if(standR && !jump)
                bufferG.drawImage(playerStand,player.getX(),player.getY(),50,125,this);
            if(standL && !jump)
                bufferG.drawImage(playerStand,player.getX()+50,player.getY(),-50,125,this);
            if(right && !jump)
                bufferG.drawImage(player.getImage(),player.getX(),player.getY(),60,125,this);
            if(left && !jump)
                bufferG.drawImage(player.getImage(),player.getX()+60,player.getY(),-60,125,this);
            if((right || standR) && jump)
                bufferG.drawImage(player.getImage(),player.getX(),player.getY(),60,125,this);
            if((left || standL) && jump)
                bufferG.drawImage(player.getImage(),player.getX()+60,player.getY(),-60,125,this);
            ///
            if(room==0)
            {
                bufferG.setColor(Color.black); 
                bufferG.fillRect(0,650,1400,100);
                bufferG.fillRect(400,250,100,400);
                bufferG.fillRect(0,450,300,50);
                bufferG.fillRect(900,0,100,450);
                bufferG.fillRect(825,600,250,50);
                bufferG.setColor(Color.red); 
                bufferG.fillRect(500,625,325,25);
            }
            if(room==1)
            {
                bufferG.setColor(Color.red); 
                bufferG.fillRect(200,635,1200,15);
                bufferG.setColor(Color.black); 
                bufferG.fillRect(0,650,1400,100);  
                bufferG.fillRect(100,600,100,50);
                bufferG.fillRect(500,575,100,75);
                bufferG.fillRect(950,550,100,100);
            }
            if(room==2)
            {
                bufferG.setColor(Color.black); 
                bufferG.fillRect(0,650,1400,100);
                bufferG.fillRect(600,0,150,650);
                bufferG.fillRect(450,450,150,50);
                bufferG.fillRect(0,300,150,50);
                bufferG.fillRect(450,150,150,50);
                bufferG.fillRect(750,140,150,50);
                bufferG.fillRect(1325,0,100,340);
                bufferG.fillRect(1200,275,250,75);
                bufferG.fillRect(1200,600,250,50);
                bufferG.setColor(Color.red);
                bufferG.fillRect(750,635,450,15);
                bufferG.setColor(Color.blue);
                bufferG.fillRect(525,100,50,50);
            }
        }
        ///
        if(pg==3)
        {
            bufferG.setFont(HomeScreen);
            bufferG.setColor(Color.white);
            bufferG.fillRect(40,10,450,100);
            bufferG.setColor(Color.black);
            bufferG.drawString("Great Job",50,50);
            bufferG.drawString(output,50,100);
        }
        ///
        g.drawImage(buffer,0,0,this);
    }

    public void update(Graphics g)
    {
        paint(g);  
    }

    public void keyPressed(KeyEvent e)
    {
        int code=e.getKeyCode();
        if(code==e.VK_RIGHT)
        {
            if(standR || standL)
            {
                if(!jump)
                {
                    player.setImages(playerwalk);
                    player.setFrameCt(0);
                }
                right=true;
                standR=false;
                standL=false;
                player.setXChange(15);
            }
        }
        if(code==e.VK_LEFT)
        {
            if(standR || standL)
            {
                if(!jump)
                {
                    player.setImages(playerwalk);
                    player.setFrameCt(0);
                }
                left=true;
                standR=false;
                standL=false;
                player.setXChange(-15);
            }
        }
        if(code==e.VK_UP && jump ==false)
        {
            player.setImages(playerjump);
            player.setFrameCt(0);
            player.setYChange(-50);
            jump=true;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if(left)
            standL=true;
        if(right)
            standR=true;
        left=false;
        right=false;
        player.setXChange(0);
        player.setYChange(0);
    }

    public void keyTyped(KeyEvent e){}

    public void mouseClicked(MouseEvent e)
    {
        mouseX=e.getX();
        mouseY=e.getY();

        if(mouseX>1175 && mouseX<1300 && mouseY>50 && mouseY<125 && pg==0)
        {
            room = rand.nextInt(3);
            background=0;
            background = rand.nextInt(3)+1;
            pg=2;
            beginTime=System.currentTimeMillis();
        }
        if(mouseX>1175 && mouseX<1300 && mouseY>250 && mouseY<325 && pg==0)
            pg=1;
        if(mouseX>1175 && mouseX<1300 && mouseY>550 && mouseY<625 && pg>0 && pg<3)
            pg=0;

        repaint();
    }

    public void mousePressed(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
}