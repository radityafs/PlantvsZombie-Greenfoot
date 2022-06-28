import greenfoot.*;

public class Plants extends Actor
{   
    //Mendeklarasikan Variabel
    GreenfootSound plantEaten = new GreenfootSound("chomp.wav");
    protected int timeToLive = 2000; 
    
    /**
     *  Method Mutator / Setter
     *  untuk merubah nilai properti timeToLive
     */
    protected void setTimeToLive(int time)
    {
        timeToLive = time;
    }
    
    /**
     * Method untuk menampilkan animasi ketika plants sudah mati
     * ketika timeToLive sudah habis / 0
     */
    protected void dyingPlantAnimation(String filename,int timeLoop)
    {
        DeadActor dead = new DeadActor(filename,timeLoop);
        World world = getWorld();
        world.addObject(dead, getX(), getY());
    }
    
    /**
     * Method plantHit untuk mengecek apakah Plants terkena Zombie
     * jika terkena ,timeToLive akan dikurangi sebanyak 20
     * dan suara animasi dimakan akan dijalankan
     * kemudian
     * jika timeToLive sudah 0 maka objek akan dihapus dan memanggil method dyingPlantAnimation
     */
    protected void plantHit(String filename, int timeLoop)
    {
        if(isTouching(Zombie.class))
        {
            timeToLive -= 20;
            plantEaten.play();
        }
        
        if (timeToLive <= 0)
        {
            World world = getWorld();
            
            dyingPlantAnimation(filename,timeLoop);
            
            world.removeObject(this);
            plantEaten.stop();
        }
    }
    

}
