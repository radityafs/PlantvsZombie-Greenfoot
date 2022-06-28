import greenfoot.*;

public class Walnut extends Plants
{
    private GifImage gifFullLife = new GifImage("walnut_full_life.gif");
    private GifImage gifHalfLife = new GifImage("walnut_half_life.gif");
    private GifImage gif = gifFullLife;
    private int halfLife = 5000;

    public Walnut()
    {
        setImage(gifFullLife.getCurrentImage());
        setTimeToLive(halfLife * 2);
    }

    public void act() 
    {
        plantHit("walnut_dead.gif", 1000);
        halfDead();
    }

    private void halfDead()
    {
        if(timeToLive < halfLife)
        {
            setImage(gifHalfLife.getCurrentImage());
        }
        else
        {
            setImage(gifFullLife.getCurrentImage());
        }
    }
}

