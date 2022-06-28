import greenfoot.*;

public class GameOver extends World
{
    // Deklarasi dan inisiasi music background.
    private GreenfootSound musicGameOver = new GreenfootSound("atebrains.wav");
    
    /**
     * Constructor for objects of class GameOver.
     */
    public GameOver(int score)
    {    
        super(1111, 602, 1); 
        
        // Menjalankan music background gameover
        musicGameOver.play();
        
        // menampilkan counter total score yang berhasil didapatkan
        Counter counter = new Counter();
        addObject(counter,613,553);
        counter.setValue(score);
        
        // Menambahkan kelas replay, untuk mengulangi permainan
        Replay replay = new Replay();
        addObject(replay, 1042, 577);
    }
    
    /**
     * Method untuk menghentikan music background
     */
    public void stopBackgroundMusic()
    {
        musicGameOver.stop();
    }
    
}


