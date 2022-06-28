import greenfoot.*;

public class Start extends World
{
    // background suara saat di menu
    private GreenfootSound musicMenu = new GreenfootSound("menu.wav");

    /**
     * Constructor class start
     * fungsi dibawah akan dijalankan ketika Class di inisiasi
     */
    public Start()
    {    
        super(1111, 602, 1); 
        
        // Menampilkan Button Start untuk memulai game
        addButtonStart();

        // Menjalankan suara secara berulang
        //musicMenu.playLoop();
    }

    /**
     * Menambahkan Tombol Start 
     * untuk memulai permainan dengan memanggil Class ButtonStart
     */
    private void addButtonStart()
    {
        ButtonStart start = new ButtonStart();
        addObject(start, 555, 534);  
    }

    
    /**
     * Menghentikan suara background menu 
     * saat world / halaman berganti
     */
    public void stopBackgroundMusic()
    {
        musicMenu.stop();
    }

    
}
