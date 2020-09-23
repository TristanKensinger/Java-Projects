import java.util.*;

public class Room{
    private ArrayList<Obstacle> list = new ArrayList<Obstacle>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private RoomTemplate temp = new RoomTemplate();
    private int roomNum, numEnemies;
    private final int totalRooms = 7;  
    private Player player = new Player(-1, -1, 7, 7, 20, 20, 3);

    public Room(){
        roomNum = 1;
    }

    public void unlock(){
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).getName().equals("door"))
                list.remove(i);
    }

    public void updateRoom(){
        //placing player
        int hp = player.getHealth();
        if(player.getX() < 5)
            player = new Player(-1, -1, 7, 13, 20, 20, hp);
        if(player.getX()+player.getWidth() > 555)
            player = new Player(-1, -1, 7, 1, 20, 20, hp);
        if(player.getY() < 5)
            player = new Player(-1, -1, 13, 7, 20, 20, hp);
        if(player.getY()+player.getHeight() > 555)
            player = new Player(-1, -1, 1, 7, 20, 20, hp);
        //methods
        list.clear();
        if(roomNum == 1)
            temp.room1(list);
        if(roomNum == 2)
            temp.room2(list);    
        if(roomNum == 3)
            temp.room3(list);
        if(roomNum == 4)
            temp.room4(list);
        if(roomNum == 5)
            temp.room5(list);
        if(roomNum == 6)
            temp.room6(list);
        if(roomNum == 7)
            temp.room7(list);
        //enemies
        enemies.clear();
        if(roomNum > 1){
            for(int i=0; i<15; i++){
                int x = (int)(Math.random()*600);
                int y = (int)(Math.random()*600);
                Enemy n = new Enemy(x,y,-1,-1,0,0);
                int ct = 0;
                if(Math.abs(player.getX() - x) > 100 && Math.abs(player.getY() - y) > 100){
                    for(Obstacle obs : list)
                        if(n.collides(obs,0,0))
                            ct++;
                    if(ct == 0){
                        enemies.add(n);
                        numEnemies++;
                    }
                }
            }
        }
    }

    public boolean movePlayer(int x, int y){
        if(player.getX()+x < 0 || player.getX()+player.getWidth()+x > 600 || player.getY()+y < 0 || player.getY()+player.getHeight()+y > 600){
            roomNum = (int)((Math.random()*(totalRooms-1))+2);
            updateRoom();
            return true;
        }
        else{
            int collideCt = 0;
            for(Obstacle obs : list)
                if(player.collides(obs, x, y))
                    collideCt++;
            if(collideCt == 0){
                player.setX(player.getX()+x);
                player.setY(player.getY()+y);
                return true;
            }
            return false;
        }
    }

    //getters
    public Player getPlayer(){
        return player;
    }

    public int getRoomNum(){
        return roomNum;
    }

    public ArrayList<Obstacle> getList(){
        return list;
    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public int getTotalRooms(){
        return totalRooms;
    }

    public int getNumEnemies(){
        return numEnemies;
    }

    //setters
    public void setRoomNum(int roomNum){
        this.roomNum = roomNum;
    }

    public void setNumEnemies(int numEnemies){
        this.numEnemies = numEnemies;
    }
}