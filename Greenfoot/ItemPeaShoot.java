import greenfoot.*;

public class ItemPeaShoot extends Sidebar
{
    public ItemPeaShoot(int positionX, int positionY)
    {
        setCostOfPlant(100);
        setIconCoordinates(positionX, positionY);
        setActiveImage("active_peashooter.png");
        setInactiveImage("inactive_peashooter.png");
    }
    
    public void act() 
    {
        createPlant(new PeaShooter());
    }    
}
