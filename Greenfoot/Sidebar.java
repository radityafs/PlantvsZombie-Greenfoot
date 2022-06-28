import greenfoot.*;

public class Sidebar extends Actor
{
    protected int costOfPlant;
    protected boolean isGrabbed, isActive = false;
    protected int iconX, iconY;
    protected GreenfootImage activeImage, inactiveImage;
    
    protected void setCostOfPlant(int cost)
    {
        costOfPlant = cost;
    }
    
    protected void setIconCoordinates(int x, int y)
    {
        iconX = x;
        iconY = y;
    }    
    
    protected void createPlant(Plants plant)
    {
        Arena world = (Arena)getWorld();
        Counter sunCounter = world.getSunCounter();
        
        if(costOfPlant <= sunCounter.getValue())
        {
            setImage(activeImage);
            createPlantDragAndDrop(plant, world, sunCounter);
        }
        else
        {
            setImage(inactiveImage);
        }
    }
    
    protected void createPlantDragAndDrop(Plants plant, Arena world, Counter sunCounter)
    {
 
        if (Greenfoot.mousePressed(this) && !isGrabbed)
        {
            isGrabbed = true;

            MouseInfo MouseInfo = Greenfoot.getMouseInfo();
            
            world.removeObject(this);
            
            world.addObject(this, MouseInfo.getX(), MouseInfo.getY());
            return;
        }

        if ((Greenfoot.mouseDragged(this)) && isGrabbed)
        {
            MouseInfo MouseInfo = Greenfoot.getMouseInfo();
            
            setLocation(MouseInfo.getX(), MouseInfo.getY());
            return;
        }

        if (Greenfoot.mouseDragEnded(this) && isGrabbed)
        {
            MouseInfo MouseInfo = Greenfoot.getMouseInfo();
            setLocation(iconX, iconY);
            
            int[] getEmptyPosition = world.getPositionItem(MouseInfo.getX(), MouseInfo.getY());
            
            if(getEmptyPosition[0] != -1 && getEmptyPosition[1] != -1)
            {
                if(world.getObjectsAt(getEmptyPosition[0], getEmptyPosition[1], Actor.class).isEmpty())
                {
                    world.addObject(plant, getEmptyPosition[0], getEmptyPosition[1]);
                    sunCounter.add(-costOfPlant);
                }
                
            }
            
            isGrabbed = false;
            return;
        }
    }
    

    protected void setActiveImage(String activeImageLink)
    {
        activeImage = new GreenfootImage(activeImageLink);
    }
    

    protected void setInactiveImage(String inactiveImageLink)
    {
        inactiveImage = new GreenfootImage(inactiveImageLink);
    }
    
}
