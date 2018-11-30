import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class DoorKeyGreen extends Mover

/* 
Dit zorgt er voor dat een Coin/collectable op z'n plek blijft staan als je het oppakt.
Je geeft de methode de waarde true aan in ScoreBoard.class zodat applyVelocity(); word toegepast. 
*/

{
    boolean alwaysOnScreen = false;
          
    public DoorKeyGreen()
    {
        super();
        setImage("keyGreen.png");
    }
    
    public DoorKeyGreen(boolean onScreen)
    {
        this.alwaysOnScreen = onScreen;
    }
    
    public void act() 
    {
        if(alwaysOnScreen == false)
        {
            applyVelocity();
        }
        
    }
    
}
