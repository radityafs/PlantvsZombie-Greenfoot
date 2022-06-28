import greenfoot.*;

public class Shovel extends Actor
{
    protected boolean isGrabbed;
    protected int iconX , iconY;


    public Shovel(int posX, int posY)
    {
        iconX = posX;
        iconY = posY;
    }


    public void act() 
    {
        removePlant();
    }


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
}

