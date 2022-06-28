import greenfoot.*;

public class NormalZombie extends Zombie
{
    private GifImage gif = new GifImage("zombie_normal.gif");

    public NormalZombie()
    {
        setImage(gif.getCurrentImage());
        setHealth(100);
    }

    public void act() 
    {
        setImage(gif.getCurrentImage());
        move(zombieSpeed);
        checkGameOver();
        setSpeed(-1);
        zombieHit(25, "zombie_normal_dying.gif", 800, 10);       
    }    
}

