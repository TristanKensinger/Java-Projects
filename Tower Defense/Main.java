package Tower_Defense;
import javax.swing.JFrame;

public class Main{
    public static void main(String[]args){
        JFrame frame = new JFrame();
        frame.setTitle("Canvas");
        frame.setSize(900,630);
        frame.setResizable(false);
        frame.setLocation(0,0);
        frame.add(new Canvas());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}