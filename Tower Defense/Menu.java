package Tower_Defense;
import java.awt.*;

public class Menu{
    Color c;
    Font f;

    public void paintComponent(Graphics g, boolean createMapBool, boolean eraseBool, boolean pathBool, boolean startBool){
        //menu background
        c = new Color(188, 147, 66);
        g.setColor(c);
        g.fillRect(600, 0, 300, 630);
        //title background
        c = new Color(168, 127, 46);
        g.setColor(c);
        g.fillRect(600, 0, 300, 75);
        //title text
        c = new Color(0, 0, 0);
        f = new Font("Arial", 1, 33);
        g.setFont(f);
        g.setColor(c);
        g.drawString("Tower Defense 1", 615, 50);
        //create map text
        f = new Font("Arial", 0, 17);
        g.setFont(f);
        if(!startBool)
            g.drawString("createMap: "+createMapBool, 750, 130);
        //start game text
        if(!startBool)
            g.drawString("startBool: "+startBool, 750, 205);
        //selection screen
        if(createMapBool){
            //selection background
            c = new Color(208, 167, 86);
            g.setColor(c);
            g.fillRect(625, 175, 250, 400);
            //eraser text
            c = new Color(0, 0, 0);
            g.setColor(c);
            g.drawString("erase: "+eraseBool, 750, 218);
            //path text
            g.drawString("path: "+pathBool, 750, 293);
        }
        //rules
        if(!createMapBool && !startBool){
            //rules title
            f = new Font("Arial", 1, 33);
            g.setFont(f);
            g.drawString("Rules", 615, 275);
            //rules text
            f = new Font("Arial", 0, 17);
            g.setFont(f);
            g.drawString("Press the create map button and", 615, 300);
            g.drawString("create your very own map! Make", 615, 325);
            g.drawString("sure there is a path on the top", 615, 350);
            g.drawString("left and bottom right corner.", 615, 375);
            g.drawString("Top left is the start, bottom right", 615, 400);
            g.drawString("is the exit. Once you are", 615, 425);
            g.drawString("content with your map, press start", 615, 450);
            g.drawString("and enjoy.", 615, 475);
        }
    }
}