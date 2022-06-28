import greenfoot.*;

public class PeaShooter extends Plants
{
    private GifImage gif = new GifImage("pea_shooter.gif");
    /**
     * constructor PeaShooter memanggil method setImage untuk mengganti gambar dengan state gambar gif
     */
    public PeaShooter()
    {
        setImage(gif.getCurrentImage());    
    }

    private long lastAdded = System.currentTimeMillis();
    /**
     * Method shootPeas menerima parameter timeInterval
     * digunakan untuk menentukan interval tembakan Pea
     */
    private void shootPeas(int timeInterval)
    {
        if (!getWorld().getObjects(Zombie.class).isEmpty())
        {
            long curTime  = System.currentTimeMillis();
            if (curTime >= lastAdded + timeInterval) //
            {
                lastAdded  = curTime;
                Pea pea = new Pea();
                World world = getWorld();
                world.addObject(pea, getX() + 28, getY() -11);
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
        shootPeas(2000);
        plantHit("pea_shooter_dying.gif",900);
    }

}

