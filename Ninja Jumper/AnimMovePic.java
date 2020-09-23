import java.awt.*;

public class AnimMovePic extends MovingPic
{
    private int frameCt;
    private Image[] pics;
    private int skipCt=1;
    private int loopCt;

    public AnimMovePic (Image[] inPics, int inDelay, int inX, int inY, int inXchange, int inYchange)
    {
        super(null, inDelay, inX, inY, inXchange, inYchange);
        setImages(inPics);
    }

    public void setFrameCt (int inFrameCt)
    {
        if(inFrameCt >= 0 && inFrameCt < pics.length)
            frameCt=inFrameCt;
    }

    public int getFrameCt()
    {
        return frameCt;
    }

    public Image getImage()
    {
        return pics[frameCt];
    }

    public void setImages (Image[] inPics)
    {
        pics = inPics;
        frameCt = 0;
    }

    public int getskipCt()
    {
        return skipCt;  
    }

    public void setskipCt(int s)
    {
        skipCt=s;  
    }
    
    public int getloopCt()
    {
        return loopCt;  
    }

    public void setloopCt(int s)
    {
        loopCt=s;  
    }

    public void run()
    {
        while (getAlive())
        {
            loopCt++;
            setX (getX() + getXChange() );
            setY (getY() + getYChange() );
            if(loopCt % skipCt==0)
                frameCt++;
            if(frameCt == pics.length)
                frameCt=0;
            try {sleep(getDelay());} catch(Exception e){}
        }
    }
}