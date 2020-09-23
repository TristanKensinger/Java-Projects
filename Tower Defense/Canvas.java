package Tower_Defense;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Canvas extends JPanel implements Runnable, ActionListener, MouseMotionListener, MouseListener{
    //canvas data
    Thread main = new Thread(this);
    int[][] grid = new int[30][30];
    JButton createMapBtn = new JButton("Create Map");
    JButton eraseBtn = new JButton("Eraser");
    JButton grassBtn = new JButton("Grass");
    JButton pathBtn = new JButton("Path");
    JButton startBtn = new JButton("Start");
    JButton startWaveBtn = new JButton("Start Wave");
    JButton tackShooterBtn = new JButton("Tack 250$");
    JButton gunnerBtn = new JButton("Gun 100$");
    JButton sniperBtn = new JButton("Snipe 150$");
    boolean createMapBool, eraseBool, pathBool, startBool, tackBool, gunnerBool, sniperBool;
    int mouseX, mouseY;
    Menu menu = new Menu();
    Money money = new Money(100);
    Wave wave = new Wave(0, false);
    Color color;
    ImageIcon grass, dirt;
    Image grassPic, dirtPic;

    public Canvas(){
        super.setDoubleBuffered(true);
        main.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setLayout(null);
        //create map button
        createMapBtn.setBounds(625, 100, 100, 50);
        createMapBtn.addActionListener(this);
        createMapBtn.setBackground(new Color(120, 120, 120));
        createMapBtn.setForeground(new Color(0));
        createMapBtn.setFocusPainted(false);
        this.add(createMapBtn);
        //erase button
        eraseBtn.setBounds(650, 200, 75, 25);
        eraseBtn.addActionListener(this);
        eraseBtn.setBackground(new Color(120, 120, 120));
        eraseBtn.setForeground(new Color(0));
        eraseBtn.setFocusPainted(false);
        eraseBtn.setVisible(false);
        this.add(eraseBtn);
        //path button
        pathBtn.setBounds(650, 275, 75, 25);
        pathBtn.addActionListener(this);
        pathBtn.setBackground(new Color(120, 120, 120));
        pathBtn.setForeground(new Color(0));
        pathBtn.setFocusPainted(false);
        pathBtn.setVisible(false);
        this.add(pathBtn);
        //start button
        startBtn.setBounds(625, 175, 100, 50);
        startBtn.addActionListener(this);
        startBtn.setBackground(new Color(120, 120, 120));
        startBtn.setForeground(new Color(0));
        startBtn.setFocusPainted(false);
        startBtn.setVisible(true);
        this.add(startBtn);
        //start wave button
        startWaveBtn.setBounds(775, 100, 100, 50);
        startWaveBtn.addActionListener(this);
        startWaveBtn.setBackground(new Color(120, 120, 120));
        startWaveBtn.setForeground(new Color(0));
        startWaveBtn.setFocusPainted(false);
        startWaveBtn.setVisible(false);
        this.add(startWaveBtn);
        //tack shooter button
        tackShooterBtn.setBounds(615, 350, 100, 50);
        tackShooterBtn.addActionListener(this);
        tackShooterBtn.setBackground(new Color(120, 120, 120));
        tackShooterBtn.setForeground(new Color(0));
        tackShooterBtn.setFocusPainted(false);
        tackShooterBtn.setVisible(false);
        this.add(tackShooterBtn);
        //gunner button
        gunnerBtn.setBounds(615, 425, 100, 50);
        gunnerBtn.addActionListener(this);
        gunnerBtn.setBackground(new Color(120, 120, 120));
        gunnerBtn.setForeground(new Color(0));
        gunnerBtn.setFocusPainted(false);
        gunnerBtn.setVisible(false);
        this.add(gunnerBtn);
        //sniper button
        sniperBtn.setBounds(615, 500, 100, 50);
        sniperBtn.addActionListener(this);
        sniperBtn.setBackground(new Color(120, 120, 120));
        sniperBtn.setForeground(new Color(0));
        sniperBtn.setFocusPainted(false);
        sniperBtn.setVisible(false);
        this.add(sniperBtn);
        //pictures
        grass = new ImageIcon(this.getClass().getResource("grass.png"));
        grassPic = grass.getImage();
        dirt = new ImageIcon(this.getClass().getResource("dirt.png"));
        dirtPic = dirt.getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;  
        g2D.setColor(Color.white);
        g2D.fillRect(0, 0, 600, 600);
        //grid
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                //grass
                if(grid[r][c] == 0 || grid[r][c] == 2){
                    g.drawImage(grassPic, c*20, r*20, 20, 20, this);
                    //                     color = new Color(51, 102, 0);
                    //                     g2D.setColor(color);
                    //                     g2D.fillRect(c*20, r*20, 20, 20);
                }
                //path
                if(grid[r][c] == 1){
                    g.drawImage(dirtPic, c*20, r*20, 20, 20, this);
                    //                     color = new Color(102, 51, 0);
                    //                     g2D.setColor(color);
                    //                     g2D.fillRect(c*20, r*20, 20, 20);
                }
                //outline
                if(createMapBool || tackBool || gunnerBool || sniperBool){
                    color = new Color(0, 0, 0);
                    g2D.setColor(color);
                    g2D.drawRect(c*20, r*20, 20, 20);
                }
            }
        }
        //menu
        menu.paintComponent(g2D, createMapBool, eraseBool, pathBool, startBool);
        //wave
        if(startBool)
            wave.draw(g2D, tackBool, gunnerBool, sniperBool, money, this);
    }

    public void run(){
        while(true){
            try{main.sleep(50);}catch(Exception e){}
            wave.update(grid, money);
            if(wave.getStartWaveBtn() == true)
                startWaveBtn.setVisible(true);
            repaint();
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == createMapBtn){
            createMapBool = !createMapBool;
            eraseBtn.setVisible(!eraseBtn.isVisible());
            pathBtn.setVisible(!pathBtn.isVisible());
            startBtn.setVisible(!startBtn.isVisible());
            eraseBool = false;
            pathBool = false;
        }
        if(e.getSource() == eraseBtn){
            eraseBool = !eraseBool;
            pathBool = false;
        }
        if(e.getSource() == pathBtn){
            pathBool = !pathBool;
            eraseBool = false;
        }
        if(e.getSource() == startBtn){
            startBool = true;
            createMapBtn.setVisible(false);
            startBtn.setVisible(false);
            tackShooterBtn.setVisible(true);
            gunnerBtn.setVisible(true);
            sniperBtn.setVisible(true);
            startWaveBtn.setVisible(true);
        }
        if(e.getSource() == startWaveBtn){
            startWaveBtn.setVisible(false);
            wave.startNextWave();
        }
        if(e.getSource() == tackShooterBtn){
            tackBool = !tackBool;
            gunnerBool = false;
            sniperBool = false;
        }
        if(e.getSource() == gunnerBtn){
            gunnerBool = !gunnerBool;
            tackBool = false;
            sniperBool = false;
        }
         if(e.getSource() == sniperBtn){
            sniperBool = !sniperBool;
            tackBool = false;
            gunnerBool = false;
        }
    }

    public void mouseMoved(MouseEvent e){}

    public void mouseDragged(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        //map design
        if(createMapBool && mouseY/20>-1 && mouseX/20>-1 && mouseY/20<30 && mouseX/20<30){
            if(eraseBool){
                grid[mouseY/20][mouseX/20] = 0;
            }
            else if(pathBool){
                grid[mouseY/20][mouseX/20] = 1;
            }
        }
    }

    public void mouseClicked(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        //tack shooter
        if(tackBool && mouseY/20>-1 && mouseX/20>-1 && mouseY/20<30 && mouseX/20<30){
            if(grid[mouseY/20][mouseX/20] == 0 && money.getMoney() >= 250){
                wave.addTower(new TackShooter(mouseY/20, mouseX/20));
                grid[mouseY/20][mouseX/20] = 2;
                money.setMoney(money.getMoney()-250);
            }
        }
        //gunner shooter
        if(gunnerBool && mouseY/20>-1 && mouseX/20>-1 && mouseY/20<30 && mouseX/20<30){
            if(grid[mouseY/20][mouseX/20] == 0 && money.getMoney() >= 100){
                wave.addTower(new Gunner(mouseY/20, mouseX/20));
                grid[mouseY/20][mouseX/20] = 2;
                money.setMoney(money.getMoney()-100);
            }
        }
        //sniper shooter
        if(sniperBool && mouseY/20>-1 && mouseX/20>-1 && mouseY/20<30 && mouseX/20<30){
            if(grid[mouseY/20][mouseX/20] == 0 && money.getMoney() >= 150){
                wave.addTower(new Sniper(mouseY/20, mouseX/20));
                grid[mouseY/20][mouseX/20] = 2;
                money.setMoney(money.getMoney()-150);
            }
        }
    }

    public void mousePressed(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
}