import greenfoot.*;

public class Zombie extends Actor
{
    //Deklarasi Variabel yang dibutuhkan
    protected int zombieSpeed;
    protected int zombieHealth;   
    protected GreenfootSound comingZombie = new GreenfootSound("zombies_coming.wav");

    protected static boolean gameOver = false;
    protected static int zombieCount = 0;
    
    /**
     * Constructor class Zombie
     * akan menjalankan musik comingZombie apabila Zombie muncul pertama kali
     */
    public Zombie()
    {   
        if(zombieCount==0)
        {
            comingZombie.play();
        }

        zombieCount+=1;
    }

    /**
     * Method setSpeed adalah method Mutator / Setter yang 
     * berfungsi untuk merubah nilai properti zombieSpeed
     */
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

    /**
     * Method setHealth adalah method Mutator / Setter yang 
     * berfungsi untuk merubah nilai properti zombieHealth
    */
    
    protected void setHealth(int health)
    {
        zombieHealth = health;
    }

    /**
     * Method ZombieHit digunakan untuk mengecek apakah terkena tembakan dari class bullet
     * jika terkena akan mengurangi zombieHealth
     * kemudian juga mengecek apakah nilai zombiHealth <= 0
     * jika true maka akan memanggil method dyingZombieAnimation
     */
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

    /**
     * Method dyingZombieAnimation digunakan untuk menampilkan animasi kematian zombie
     * menerima parameter, filename berupa gambar animasi kematian dan timeLoop / interval delay sebelum object dihapus dari arena
     */
    protected void dyingZombieAnimation(String filename,int timeLoop)
    {
        DeadActor dead = new DeadActor(filename,timeLoop);
        World world = getWorld();
        world.addObject(dead, getX(), getY());
    }

    /**
     * Method checkGameOver digunakan untuk mengecek apakah zombie sudah melewati pekarangan / arena
     * jika sudah melewati maka akan dianggap gameOver / game selesai, dan diarahkan ke World GameOver
     */
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

