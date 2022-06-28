import greenfoot.*; 

public class Sun extends Actor
{
    /**
     * Deklarasi Variabel / properti yang digunakan
     */
    private GifImage gif = new GifImage("sun.gif");
    private boolean sunFall = false;
    private int sunSpeed = 2;

    /**
     * Constructor Class Sun
     * berfungsi mengubah gambar object menjadi gambar dari value gif.
     */
    public Sun()
    {
        setImage(gif.getCurrentImage());        
    }

    /**
     * Method sunDrop digunakan untuk menjatuhkan sun kebawah
     */
    private void sunDrop()
    {
        move(sunSpeed);

        if(getY() >= getWorld().getHeight() - 30){
            sunSpeed = 0;
        }

    }

    /**
     * Method letTheSunFall digunakan untuk mengarahkan matahari kebawah
     * dan mengatur nilai properti sunFall menjadi true
     */
    public void letTheSunFall()
    {
        sunFall = true;        
        turn(90);
    }

    /**
     *   Method act akan diselalu dijalankan sesudah class diinisiasi
     *   disini saya memanfaatkan method act untuk :
     *   1. mengecek nilai properti sunFall apakah true
     *      jika iya maka akan memanggil method sunDrop (menjatuhkan sun)
     *   2. mengecek apakah object diklik, jika iya maka akan menambah sunCounter dan dihapus dari arena
     */
    public void act() 
    {
        setImage(gif.getCurrentImage());

        if(sunFall == true)
        {
            sunDrop();
        }

        if (Greenfoot.mouseClicked(this))
        {
            Arena world = (Arena)getWorld();
            Counter sunCounter = world.getSunCounter();
            sunCounter.add(25);
            world.removeObject(this);
        }
    }

}
