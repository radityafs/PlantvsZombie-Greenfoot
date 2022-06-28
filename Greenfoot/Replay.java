import greenfoot.*; 

public class Replay extends Actor
{
    private GifImage gif = new GifImage("gameOver.gif");
    /**
     * Method act pada class Replay dilakukan pengkondisian untuk
     * mengembalikan World ke Class Start jika diklik
     */
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
