import greenfoot.*;

public class Sunflower extends Plants
{
    private GifImage gif = new GifImage("sun_flower.gif");
    
    private long lastAdded = System.currentTimeMillis();
    

    public Sunflower()
    {
        setImage(gif.getCurrentImage());    
    }
    

    public void act() 
    {
       setImage(gif.getCurrentImage());
       produceSun(4000);
       plantHit("sun_flower_dying.gif", 1000);
    }

    /**
     * Method produceSun untuk menghasilkan matahari dengan interval sesuai parameter interval
     */
    public void produceSun(int timeInterval)
    {
        long curTime  = System.currentTimeMillis();
        
        if (curTime >= lastAdded + timeInterval) //5000ms = 5s
        {
            lastAdded  = curTime;
            Sun sun = new Sun();
            World world = getWorld();
            
            if(world.getObjectsAt(getX() + 30, getY() + 30, Sun.class).isEmpty())
            {
                world.addObject(sun, getX() + 30, getY() + 30);
            }
        }
    }
}

