import greenfoot.*;

/**
 * Class Parent Bullet
 * Digunakan untuk mengatur kecepatan bergerak
 */
public class Bullet extends Actor
{
    protected int speed = 4;

    /**
     * Method mutator / setter
     * untuk mengganti nilai properti dari kecepatan
     */
    protected void setSpeed(int bulletSpeed)
    {
        speed = bulletSpeed;
    }

    /**
     * Method checkBoundaries untuk mengecek apakah 
     * class Bullet sudah sampai pojok kanan
     * jika sudah maka akan langsung dihapus
     */
    protected void checkBoundaries()
    {
        if(getX() > getWorld().getWidth() - 10){
            getWorld().removeObject(this);
        }    
    }

    /**
     *   Method act akan diselalu dijalankan sesudah class diinisiasi
     *   disini saya memanfaatkan method act untuk :
     *   1. Menggerakan class object dengan kecepatan sesuai nilai properti speed
     *   2. Mengecek apakah sudah sampai pojok menggunakan method checkBoundaries
     */
    public void act(){
        move(this.speed);
        checkBoundaries();
    }

}
