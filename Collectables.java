import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Collectables extends Mover

/* 
Dit zorgt er voor dat een collectable op z'n plek blijft staan als je het oppakt.
Je geeft de methode de waarde (die ergens in Scoreboard.java staat) true aan in ScoreBoard.class zodat applyVelocity(); word toegepast. 
*/

{
    
    
//    public enum collectables
//    {
//        crystalRed, 
//        crystalGreen, 
//        crystalBlue, 
//        crystalYellow,
//        
//        keyRed,
//        keyGreen,
//        keyBlue,
//        keyYellow,    
//    }
    
    boolean alwaysOnScreen =  false;
    
    public Collectables()
    {
        super();
    }
    
    public Collectables(boolean onScreen)
    {
        this.alwaysOnScreen = onScreen;
    }
    
    public Collectables(String image)
    {
        setImage(image);
    }
    
    
    
    public void act() 
    {
        if(alwaysOnScreen == false)
        {
            applyVelocity();
        }
        
    }   
    
}
