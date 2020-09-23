import java.awt.*;

public class Enemy extends Obstacle{
    String name = "enemy1";
    int type;
    int health;
    public Enemy(int x, int y, int row, int col, int width, int height){
        super(x, y, row, col, width, height);
        type = (int)(Math.random()*3);
        if(type == 0){
            health = 10;
            setWidth(35);
            setHeight(35);
        }
        if(type == 1){
            health = 1;
            setWidth(5);
            setHeight(5);
        }
        if(type == 2){
            health = 5;
            setWidth(20);
            setHeight(20);
        }
    }

    public void move(Player player, Room room){
        double n = Math.random();
        double chance = 0;
        if(type == 0)
            chance = .7;
        if(type == 1)
            chance = 1;
        if(type == 2)
            chance = .7;
        int upCt = 0, rightCt = 0, downCt = 0, leftCt = 0;
        for(Obstacle obs : room.getList()){
            if(this.collides(obs,0,-1))
                upCt++;
            if(this.collides(obs,1,0))
                rightCt++;
            if(this.collides(obs,0,1))
                downCt++;
            if(this.collides(obs,-1,0))
                leftCt++;
        }
        if(n < chance){
            if(player.getX() > getX() && rightCt == 0)
                setX(getX() + 1);
            if(player.getX() < getX() && leftCt == 0)
                setX(getX() - 1);
            if(player.getY() > getY() && downCt == 0)
                setY(getY() + 1);
            if(player.getY() < getY() && upCt == 0)
                setY(getY() - 1);
        }
    }

    public String getName(){
        return name;
    }

    public void draw(Graphics g){
        Color c = new Color(0,0,0);
        if(health == 10)
            c = new Color(0,255,0);
        if(health == 9)
            c = new Color(0,225,0);
        if(health == 8)
            c = new Color(0,195,0);
        if(health == 7)
            c = new Color(0,165,0);
        if(health == 6)
            c = new Color(0,135,0);
        if(health == 5)
            c = new Color(0,105,0);
        if(health == 4)
            c = new Color(0,75,0);
        if(health == 3)
            c = new Color(0,60,0);
        if(health == 2)
            c = new Color(0,50,0);
        if(health == 1)
            c = new Color(0,40,0);
        g.setColor(c);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }
}