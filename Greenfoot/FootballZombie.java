import greenfoot.*;

public class FootballZombie extends Zombie
{

    private GifImage gif = new GifImage("zombie_football.gif");

    public FootballZombie()
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
        zombieHit(20, "zombie_football_dying.gif", 600, 20);       
    }
}