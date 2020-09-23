import javax.swing.JFrame;

public class Main{
    public static void main(String[]args){
        JFrame frame = new JFrame();
        frame.setTitle("The Big Dig");
        frame.setSize(700,700);
        frame.setResizable(false);
        frame.setLocation(0,0);
        frame.add(new Game());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}