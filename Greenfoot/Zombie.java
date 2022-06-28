import greenfoot.*;

public class Zombie extends Actor
{
    protected int zombieSpeed;
    protected int zombieHealth;   
    protected GreenfootSound comingZombie = new GreenfootSound("zombies_coming.wav");

    protected static boolean gameOver = false;
    protected static int zombieCount = 0;

    public Zombie()
    {   
        if(zombieCount==0)
        {
            comingZombie.play();
        }

        zombieCount+=1;
    }

    protected void setSpeed(int speed)
    {
        if(isTouching(Plants.class))
        {
            zombieSpeed = 0;
        }
        else
        {
            zombieSpeed = speed;
        }
    }

    protected void setHealth(int health)
    {
        zombieHealth = health;
    }

    protected void zombieHit(int damage, String filename, int timeLoop, int points)
    {   
        if(isTouching(Bullet.class))
        {
            zombieHealth -= damage;
            removeTouching(Bullet.class);
        }

        if(zombieHealth <= 0)
        {
            removeTouching(Bullet.class);                
            dyingZombieAnimation(filename,timeLoop);

            Arena world = (Arena)getWorld();
            Counter score = world.getScoreCounter();
            score.add(points);
            world.removeObject(this);
        }
    }

    protected void dyingZombieAnimation(String filename,int timeLoop)
    {
        DeadActor dead = new DeadActor(filename,timeLoop);
        World world = getWorld();
        world.addObject(dead, getX(), getY());
    }

    protected void checkGameOver()
    {
        Arena world = (Arena)getWorld();
        if(getX() < 260)
        {   
            setHealth(-1);
            Counter score = world.getScoreCounter();          
            world.stopBackgroundMusic();
            gameOver = true;
            Greenfoot.setWorld(new GameOver(score.getValue()));            

        }
    }
}

