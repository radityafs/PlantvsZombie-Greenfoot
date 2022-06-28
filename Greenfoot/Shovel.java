import greenfoot.*;

public class Shovel extends Actor
{
    /**
     * Deklarasi nilai properti yang akan digunakan
     */
    protected boolean isGrabbed;
    protected int iconX , iconY;

    /**
     * Pada constructor Shovel menerima 2 parameter posX dan posY
     * yang digunakan untuk meletakan posisi Object ke tempat semula
     */
    public Shovel(int posX, int posY)
    {
        iconX = posX;
        iconY = posY;
    }

    /**
     * Method removePlant digunakan untuk menghapus tanaman 
     * jika diarahkan mengenai tanaman target
     */
    private void removePlant()
    {
        Arena world = (Arena)getWorld();

        if (Greenfoot.mousePressed(this) && !isGrabbed)
        {
            isGrabbed = true;

            MouseInfo mouseInfo = Greenfoot.getMouseInfo();
            world.removeObject(this);
            world.addObject(this, mouseInfo.getX(), mouseInfo.getY());
            return;
        }

        if ((Greenfoot.mouseDragged(this)) && isGrabbed)
        {
            MouseInfo mouseInfo = Greenfoot.getMouseInfo();
            setLocation(mouseInfo.getX(), mouseInfo.getY());
            return;
        }

        if (Greenfoot.mouseDragEnded(this) && isGrabbed)
        {
            MouseInfo mouseInfo = Greenfoot.getMouseInfo();

            int plantRow = (mouseInfo.getY());
            int plantColumn = (mouseInfo.getX());
            if(!world.getObjectsAt(plantColumn, plantRow, Actor.class).isEmpty())
            {
                removeTouching(Plants.class);
            }

            setLocation(iconX, iconY);
            isGrabbed = false;
            return;
        }
    }

    /**
     * karena Method act akan terus dijalankan selama game berjalan
     * maka method ini memanggil method removePlant, untuk selalu melakukan pengecekan.
     */
    public void act() 
    {
        removePlant();
    }

}
