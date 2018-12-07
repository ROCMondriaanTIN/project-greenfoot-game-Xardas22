import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class doorKeyRed extends Mover

/* 
Dit zorgt er voor dat een Coin/collectable op z'n plek blijft staan als je het oppakt.
Je geeft de methode de waarde true aan in ScoreBoard.class zodat applyVelocity(); word toegepast. 
*/

{
    boolean alwaysOnScreen = false;
          
    public doorKeyRed()
    {
        super();
        setImage("keyRed.png");
    }
    
    public doorKeyRed(boolean onScreen)
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
