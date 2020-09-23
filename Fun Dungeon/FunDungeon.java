import java.awt.*;
import java.applet.Applet;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;
import java.util.*;

public class FunDungeon extends Applet implements Runnable, KeyListener{
    Thread main = new Thread(this);
    Random rand = new Random();
    Image buffer;
    Graphics bufferG;
    Room room = new Room();
    boolean up, right, down, left;
    boolean shootUp, shootRight, shootDown, shootLeft;
    int shootCt = 0, points = 0, page = 0;
    ArrayList<Bullet> playerBullets = new ArrayList<Bullet>();
    Font font1 = new Font("SansSerif",100,25);
    AudioClip music[] = new AudioClip[4];
    int currentSong = (int)(Math.random()*4);
    Image floor, rock, door, home, end;

    public void init(){
        //applet code
        this.resize(800,600);
        this.addKeyListener(this);
        buffer = createImage(this.getWidth(),this.getHeight());
        bufferG = buffer.getGraphics();
        //         music[0] = this.getAudioClip(this.getCodeBase(), "music1.wav");
        //         music[1] = this.getAudioClip(this.getCodeBase(), "music2.wav");
        //         music[2] = this.getAudioClip(this.getCodeBase(), "music3.wav");
        //         music[3] = this.getAudioClip(this.getCodeBase(), "music4.wav");
        //         music[currentSong].loop();
        floor = this.getImage(this.getCodeBase(),"wood.png");
        rock = this.getImage(this.getCodeBase(),"rock.png");
        door = this.getImage(this.getCodeBase(),"door.png");
        home = this.getImage(this.getCodeBase(),"homeScreen.png");
        end = this.getImage(this.getCodeBase(),"gameOver.png");
        room.updateRoom();
        main.start();
    }

    public void run(){
        while(true){
            repaint();
            try{main.sleep(5);}catch(Exception e){}
            //game conditions
            if(room.getNumEnemies() == 0)
                room.unlock();
            if(room.getPlayer().getImmunityFrames() > 0)
                room.getPlayer().setImmunityFrames(room.getPlayer().getImmunityFrames() -1);
            //movement
            if(up)
                room.movePlayer(0,-1);
            if(right)
                room.movePlayer(1,0);
            if(down)
                room.movePlayer(0,1);
            if(left)
                room.movePlayer(-1,0);
            if(room.getNumEnemies() > 0)
                for(Enemy e : room.getEnemies())
                    if(room.getPlayer().getImmunityFrames() == 0 && room.getPlayer().collides(((Obstacle)e),0,0)){
                        room.getPlayer().setHealth(room.getPlayer().getHealth() - 1);
                        room.getPlayer().setImmunityFrames(250);
                        if(room.getPlayer().getHealth() == 0)
                            page = 2;
            }
            //shooting
            if(shootUp || shootRight || shootDown || shootLeft)
                shootCt++;
            if(shootCt == 40){
                shootCt = 0;
                if(shootUp)
                    playerBullets.add(new Bullet(room.getPlayer().getX(),room.getPlayer().getY(),-1,-1,5,5,0,-3));
                else if(shootRight)
                    playerBullets.add(new Bullet(room.getPlayer().getX(),room.getPlayer().getY(),-1,-1,5,5,3,0));
                else if(shootDown)
                    playerBullets.add(new Bullet(room.getPlayer().getX(),room.getPlayer().getY(),-1,-1,5,5,0,3));
                else if(shootLeft)
                    playerBullets.add(new Bullet(room.getPlayer().getX(),room.getPlayer().getY(),-1,-1,5,5,-3,0));
            }
            for(int i=0; i<playerBullets.size(); i++){
                int collisions = 0;
                for(Obstacle obs : room.getList())
                    if(playerBullets.get(i).collides(obs, playerBullets.get(i).getXV(), playerBullets.get(i).getYV()))
                        collisions++;
                if(collisions > 0 || playerBullets.get(i).getX() < 0 || playerBullets.get(i).getX() > 600 || playerBullets.get(i).getY() < 0 || playerBullets.get(i).getY() > 600){
                    playerBullets.remove(i);
                    i--;
                }
                else{
                    boolean hit = false;
                    for(Enemy e : room.getEnemies()){
                        if(playerBullets.get(i).collides(((Obstacle)e),0,0)){
                            e.setHealth(e.getHealth() - 1);
                            if(page == 1)
                                points++;
                            hit = true;
                        }
                    }
                    if(hit){
                        playerBullets.remove(i);
                        i--;
                    }
                    else
                        playerBullets.get(i).update();
                }
            }
            //enemies
            for(int i=0; i<room.getEnemies().size(); i++){
                if(room.getEnemies().get(i).getHealth() == 0){
                    room.getEnemies().remove(i);
                    room.setNumEnemies(room.getNumEnemies() - 1);
                    i--;
                    if(page == 1)
                        points += 5;
                }
                else
                    room.getEnemies().get(i).move(room.getPlayer(),room);
            }
        }
    }

    public void keyPressed(KeyEvent e){
        int code=e.getKeyCode();
        if(page == 0){
            if(code == e.VK_ENTER){
                page = 1;
            }
            if(code == e.VK_SPACE){
                page = -1;
            }
        }
        if(page == -1){
            if(code == e.VK_ENTER){
                page = 0;
            }
        }
        if(page == 1){
            //movement
            if(code == e.VK_W){
                up = true;
            }
            if(code == e.VK_A){
                left = true;
            }
            if(code == e.VK_S){
                down = true;
            }
            if(code == e.VK_D){
                right = true;
            }
            //shooting
            if(code == e.VK_UP){
                shootUp = true;
            }
            if(code == e.VK_RIGHT){
                shootRight = true;
            }
            if(code == e.VK_DOWN){
                shootDown = true;
            }
            if(code == e.VK_LEFT){
                shootLeft = true;
            }
        }
        if(page == 2){
            if(code == e.VK_ENTER){
                page = 0;
                points = 0;
                room = new Room();
                room.updateRoom();
                up = false;
                right = false;
                down = false;
                left = false;
                shootUp = false;
                shootRight = false;
                shootDown = false;
                shootLeft = false;
                music[currentSong].stop();
                currentSong = (int)(Math.random()*4);
                music[currentSong].loop();
            }
        }
    }

    public void keyReleased(KeyEvent e){
        if(page == 1){
            int code=e.getKeyCode();
            //movement
            if(code == e.VK_W){
                up = false;
            }
            if(code == e.VK_A){
                left = false;
            }
            if(code == e.VK_S){
                down = false;
            }
            if(code == e.VK_D){
                right = false;
            }    
            //shooting
            if(code == e.VK_UP){
                shootUp = false;
            }
            if(code == e.VK_RIGHT){
                shootRight = false;
            }
            if(code == e.VK_DOWN){
                shootDown = false;
            }
            if(code == e.VK_LEFT){
                shootLeft = false;
            }
        }
    }

    public void keyTyped(KeyEvent e){}

    public void paint(Graphics g){
        bufferG.setFont(font1);
        if(page == -1){
            bufferG.setColor(Color.gray);
            bufferG.fillRect(0,0,800,600);
            bufferG.setColor(Color.black);
            bufferG.drawString("Rules:",50,50);
            bufferG.drawString("Kill enemies to gain points and dodge them to protect your lives",50,100);
            bufferG.drawString("PRESS enter to go back to home screen",50,150);
        }
        if(page == 0){
            bufferG.drawImage(home,0,0,this);
        }
        if(page == 1){
            Color c = new Color(200, 200, 200);
            bufferG.setColor(c);
            bufferG.fillRect(0,0,800,600);
            for(int r=0; r<15; r++)
                for(int cc=0; cc<15; cc++)
                    bufferG.drawImage(floor,cc*40,r*40,this);
            bufferG.setColor(Color.black);
            bufferG.drawString("Points:   "+points,640,50);
            bufferG.drawString("Health:   "+room.getPlayer().getHealth(),640,150);
            //drawing
            for(Obstacle obs : room.getList()){
                if(obs.getName().equals("wall"))
                    bufferG.drawImage(rock,obs.getX(),obs.getY(),this);
                if(obs.getName().equals("door"))
                    bufferG.drawImage(door,obs.getX(),obs.getY(),this);
            }
            for(Bullet b : playerBullets)
                b.draw(bufferG);
            //player
            room.getPlayer().draw(bufferG);
            //enemies
            for(Enemy n : room.getEnemies())
                n.draw(bufferG);
        }
        if(page == 2){
            bufferG.drawImage(end,0,0,this);
            bufferG.setColor(Color.white);
            bufferG.drawString(points+"",480,445);
            bufferG.drawString("Current High Score:   929 Sebastian Churion",50,550);
            //636 by Tristan Kensinger
            //418 Colby Hamburger
            //405 Gavin Kensinger
            //338 Jude Harfoush
            //252 Rocco Polimeni
        }
        g.drawImage(buffer,0,0,this);
    }

    public void update(Graphics g){
        paint(g);
    }
}