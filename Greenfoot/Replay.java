import greenfoot.*; 

public class Replay extends Actor
{
    private GifImage gif = new GifImage("gameOver.gif");

    public void act() 
    {
        setImage(gif.getCurrentImage());
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Start());
            GameOver world = (GameOver)getWorld();
            world.stopBackgroundMusic();
        }
    }    
}
