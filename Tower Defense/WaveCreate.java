package Tower_Defense;
import java.util.ArrayList;

public class WaveCreate{
    int waveNum = -1;
    int balloonWaves[][] = new int[7][50];
    String balloonTypes[][] = new String[7][50];
    boolean balloonsLeft = true;

    public WaveCreate(){
        stringToWave(0, "10,0,0,0,0,0,0,");
        stringToWave(1, "20,0,0,0,0,0,0,");
        stringToWave(2, "30,0,0,0,0,0,0,");
        stringToWave(3, "40,0,0,0,0,0,0,");
        stringToWave(4, "50,0,0,0,0,0,0,");

        stringToWave(5, "0,25,0,0,0,0,0,");
        stringToWave(6, "50,25,0,0,0,0,0,");
        stringToWave(7, "20,5,10,0,0,0,0,");
        stringToWave(8, "70,0,30,0,0,0,0,");
        stringToWave(9, "40,40,40,0,0,0,0,");

        stringToWave(10, "20c,20,20,20,0,0,0,");
        stringToWave(11, "50,25,0,50,0,0,0,");
        stringToWave(12, "20,20,20,20,0,0,0,");
        stringToWave(13, "50,80c,30,50,0,0,0,");
        stringToWave(14, "80,80,20,20,30,0,0,");

        stringToWave(15, "150,0,0,0,0,0,0,");
        stringToWave(16, "200c,0,0,0,0,0,0,");
        stringToWave(17, "30,40,50,60,70,80,0,");
        stringToWave(18, "20,50,60,70,80,90,0,");
        stringToWave(19, "100,100,100c,0,0,0,100,");
    }

    public void addNextBalloon(ArrayList<Balloon> balloons){
        ArrayList<Integer> optionBalloons = new ArrayList<Integer>();
        ArrayList<Integer> optionTypes = new ArrayList<Integer>();
        optionBalloons.clear();
        optionTypes.clear();
        balloonsLeft = false;
        for(int r=0; r<7; r++){
            //not efficient !!!
            for(int i=0; i<balloonWaves[r][waveNum]; i++){
                optionBalloons.add(r);
                if(balloonTypes[r][waveNum] == "c")
                    optionTypes.add(1);
                else
                    optionTypes.add(0);
                balloonsLeft = true;
            }
        }

        if(balloonsLeft){
            int p = (int)(Math.random()*optionBalloons.size());
            if(optionTypes.get(p) == 0)
                balloons.add(new Balloon(0, 0, optionBalloons.get(p)+1, false));
            else
                balloons.add(new Balloon(0, 0, optionBalloons.get(p)+1, true));
            balloonWaves[optionBalloons.get(p)][waveNum] -= 1;
        }
    }

    public int totalBalloons(){
        int total = 0;
        for(int r=0; r<7; r++){
            total += balloonWaves[r][waveNum];
        }
        return total;
    }

    public void updateWaveNum(){
        waveNum++;
        balloonsLeft = true;
    }

    private void stringToWave(int col, String str){
        for(int r=0; r<7; r++){
            String n = str.substring(0, str.indexOf(","));
            if(n.indexOf("c") == -1)
                balloonWaves[r][col] = Integer.parseInt(n);
            else{
                balloonWaves[r][col] = Integer.parseInt(n.substring(0, str.indexOf("c")));
                balloonTypes[r][col] = "c";
            }
            str = str.substring(str.indexOf(",")+1);
        }
    }

    public boolean getBalloonsLeft(){
        return balloonsLeft;
    }
}