import greenfoot.*;

public class FootballZombie extends Zombie
{
    //deklarasi gambar zombie Football
    private GifImage gif = new GifImage("zombie_football.gif");

    /**
     * pada constructor FootballZombie
     * berfungsi mengubah gambar Objek menjadi gambar properti gif. dan
     * terdapat perintah untuk memanggil method setHealth ke parent dengan melempar parameter 100
     */
    public FootballZombie()
    {
        setImage(gif.getCurrentImage());
        setHealth(100);
    }

     /**
     *   Method act akan diselalu dijalankan sesudah class diinisiasi
     *   disini saya memanfaatkan method act untuk :
     *   1. Mengubah gambar object berdasarkan state / value dari kembalian method getCurrentImage
     *   2. Menggerakan Zombie ke arah rumah
     *   3. Mengecek apakah Zombie sudah mencapai rumah (method checkGameOver)
     *   4. mengatur kecepatan zombie menjadi -1 (kekiri)
     *   5. memanggil ZombieHit
    */
    public void act() 
    {
        setImage(gif.getCurrentImage());
        move(zombieSpeed);
        checkGameOver();
        setSpeed(-1);
        zombieHit(20, "zombie_football_dying.gif", 600, 20);       
    }
}