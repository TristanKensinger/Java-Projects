package Tower_Defense;
import java.awt.*;
import javax.swing.*;

public interface Tower{
    public void update(Balloon[][] grid, Money money);


    public void draw(Graphics g, JPanel panel);
}