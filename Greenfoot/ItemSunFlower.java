import greenfoot.*;


public class ItemSunFlower extends Sidebar
{   

    public ItemSunFlower(int positionX, int positionY)
    {
        setCostOfPlant(50);
        setIconCoordinates(positionX, positionY);
        setActiveImage("active_sunflower.png");
        setInactiveImage("inactive_sunflower.png");
    }
    
    public void act() 
    {
        createPlant(new Sunflower());
    }    
}