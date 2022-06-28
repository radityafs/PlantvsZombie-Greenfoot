import greenfoot.*;

public class ItemWalnut extends Sidebar
{
    public ItemWalnut(int positionX, int positionY)
    {
        setCostOfPlant(25);
        setIconCoordinates(positionX, positionY);
        setActiveImage("active_walnut.png");
        setInactiveImage("inactive_walnut.png");
    }
    
    public void act()
    {
        createPlant(new Walnut());
    }    
}
