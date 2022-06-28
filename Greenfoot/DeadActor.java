import greenfoot.*;

public class DeadActor extends Actor
{
    private GifImage deadActorImage;

    private int delayTime;

    private long timeAdded = System.currentTimeMillis();

    /**
     * Constructor class DeadActor
     * membutuhkan 2 parameter yaitu nama file gambar ketika Actor mati
     * dan delayTime (jeda sebelum Actor dihapus dari arena)
     */
    public DeadActor(String filename, int delayTime)
    {
        deadActorImage = new GifImage(filename);

        setImage(deadActorImage.getCurrentImage());

        this.delayTime = delayTime;
    }

    /**
     *   Method act akan diselalu dijalankan sesudah class diinisiasi
     *   disini saya memanfaatkan method act untuk :
     *   melakukan pengecekan apabila waktu sudah melebihi delayTime maka akan dihapus dari arena.
     */
    public void act() 
    {
        long currentTime  = System.currentTimeMillis();
        setImage(deadActorImage.getCurrentImage());

        if (currentTime >= timeAdded + delayTime)
        {
            getWorld().removeObject(this);            
        }
    }   
}
