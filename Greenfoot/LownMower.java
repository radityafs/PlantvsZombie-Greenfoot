import greenfoot.*;

public class LownMower extends Actor
{
    //Deklarasi Variabel yang dibutuhkan
    private GifImage LownMower = new GifImage("lawn_mower.gif");
    GreenfootSound sound = new GreenfootSound("lamborghini.wav");
    
    private int speed = 0;
    
    /**
     * Pada Constructor LownMower, fungsi yang pertama kali dieksekusi adalah
     * mengganti gambar class dengan state gambar Gif LownMower
     */
    public LownMower()
    {
        setImage(LownMower.getCurrentImage());    
    }

    /**
     * pada Method act, karena method act akan selalu berjalan ketika aplikasi dijalankan
     * maka dilakukan pengkondisian disini, apabila zombie menabrak lown mower, maka lown mower akan berjalan dan menabrak zombie
     * dan suara animasi lownmower berjalan akan di mainkan
     */
    public void act()
    {
        move(speed);
        
        if(isTouching(Zombie.class))
        {
            removeTouching(Zombie.class);
            speed = 12;
            sound.play();
        }
        if(speed > 0)
        {                      
            setImage(LownMower.getCurrentImage());
        }
        
        checkBoundaries();
    }    

    /**
     * Method checkBoundaries untuk mengecek apakah object sudah sampai pojok kanan
     * jika sudah , maka object akan dihapus
     */
    protected void checkBoundaries()
    {
        if(getX() > getWorld().getWidth() - 10)
            getWorld().removeObject(this);       
    }
}
