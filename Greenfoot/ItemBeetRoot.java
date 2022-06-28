import greenfoot.*;

public class ItemBeetRoot extends Sidebar
{
    public ItemBeetRoot(int positionX, int positionY)
    {
        setCostOfPlant(125);
        setIconCoordinates(positionX, positionY);
        setActiveImage("active_beetroot.png");
        setInactiveImage("inactive_beetroot.png");
    }
    
    public void act()
    {
        createPlant(new Beetroot());
    }
}
