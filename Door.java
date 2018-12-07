import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Door extends Mover
{
    
    public Door()
    {
        super();
        setImage("DoorClosed.png");
    }
    
    
    public void act() 
    {
        applyVelocity(); 
//        if(Hero.hasKeyGreen == true && isTouching(Door.class))
//        {
//            Greenfoot.setWorld(new level);
//        }
//        
    }   
    
}
