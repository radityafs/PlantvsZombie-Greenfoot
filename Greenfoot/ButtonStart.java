import greenfoot.*;

public class ButtonStart extends Actor
{
    private GifImage gambarStart = new GifImage("click_to_start.gif");
    
    /**
     *   Method act akan diselalu dijalankan sesudah class diinisiasi
     *   disini saya memanfaatkan method act untuk memunculkan gambar Start
     *   dan mengecek apakah class ini dipencet, jika dipencet maka akan memulai permainan
     */
    public void act() 
    {
        setImage(gambarStart.getCurrentImage());
        
        //jika class ini dipencet maka akan beralih ke menu arena dan menghentikan musik background menu
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Arena());
            
            Start world = (Start)getWorld();
            world.stopBackgroundMusic();
        }
    }    
}
