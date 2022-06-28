import greenfoot.*;

public class ZombiesAreComing extends Actor
{
    /**
     * Deklarasi nilai properti / variabel
     */
    private GreenfootSound comingZombie = new GreenfootSound("zombies_coming.wav");    
    private long lastAdded;

    /**
     * Constructor ZombieAreComing
     * berfungsi menjalankan music comingZombie
     * dan merubah nilai properti lastAdded
     */
    public ZombiesAreComing()
    {
        comingZombie.play();
        lastAdded = System.currentTimeMillis();
    }

    /**
     * pada fungsi / method act terdapat pengkondisian untuk mengecek
     * apakah waktu sudah 1500ms / 1.5s dari saat ditambahkan
     * jika iya maka object akan dihapus dari world arena
     */
    public void act() 
    {
        long curTime  = System.currentTimeMillis();
        if (curTime >= lastAdded +1500)
            getWorld().removeObject(this);        
    }    
}
