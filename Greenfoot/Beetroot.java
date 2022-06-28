import greenfoot.*;

public class Beetroot extends Plants
{
    private GifImage gif = new GifImage("beetroot.gif");
    private long lastAdded = System.currentTimeMillis();
    
    /**
     * constructor Beetroot memanggil method setImage untuk mengganti gambar dengan state gambar gif
     */
    public Beetroot()
    {
        setImage(gif.getCurrentImage());    
    }

    /**
     * Method shootBeet menerima parameter timeInterval
     * digunakan untuk menentukan interval tembakan Beet
     */
    private void shootBeet(int timeInterval)
    {
        if (!getWorld().getObjects(Zombie.class).isEmpty())
        {
            long curTime  = System.currentTimeMillis();
            
            if (curTime >= lastAdded + timeInterval) 
            {
                lastAdded  = curTime;
                
                Beet beet = new Beet();
                World world = getWorld();
                world.addObject(beet, getX() + 29, getY() + 20);
            }
        }
    }

    /**
     * pada method act
     * menjalankan setImage dari state / method getCurrentImage
     * kemudian memanggil method shootBeet dengan interval 2000ms
     * dan memanggil method plantHit dengan paremeter gif ketika beetroot mati dan interval waktu dihapus
     */
    public void act() 
    {
        setImage(gif.getCurrentImage());
        shootBeet(2000);
        
        plantHit("beetroot_dying.gif", 1000);
    }

}
