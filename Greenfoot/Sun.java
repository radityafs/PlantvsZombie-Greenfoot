import greenfoot.*; 

public class Sun extends Actor
{
    private GifImage gif = new GifImage("sun.gif");
    private boolean sunFall = false;
    private int sunSpeed = 2;

    public Sun()
    {
        setImage(gif.getCurrentImage());        
    }

    public void act() 
    {
        setImage(gif.getCurrentImage());

        if(sunFall == true)
        {
            sunDrop();
        }

        if (Greenfoot.mouseClicked(this))
        {
            Arena world = (Arena)getWorld();
            Counter sunCounter = world.getSunCounter();
            sunCounter.add(25);
            world.removeObject(this);
        }
    }

    private void sunDrop()
    {
        move(sunSpeed);
        
        if(getY() >= getWorld().getHeight() - 30){
            sunSpeed = 0;
        }
            
    }

    public void letTheSunFall()
    {
        sunFall = true;        
        turn(90);
    }
}

