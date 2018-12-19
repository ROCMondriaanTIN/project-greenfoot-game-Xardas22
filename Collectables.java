import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Collectables extends Mover
{
    
    
//    public enum collectables
//    {
//        coinZilver,
//        coinGold,
//        
//        crystalRed, 
//        crystalGreen, 
//        crystalBlue, 
//        crystalYellow,
//        
//        keyRed,
//        keyGreen,
//        keyBlue,
//        keyYellow,
//        
//        levens,
//    }
    
    
    public Collectables()
    {
        super();
    }
    
    public Collectables(String image)
    {
        setImage(image);
    }
    
    
    
    public void act() 
    {
        applyVelocity();
    }   
    
}
