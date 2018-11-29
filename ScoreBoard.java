import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ScoreBoard extends Actor
{
    
    public static int leven = 2;
    private int score = 0;
    private int xPosLeven = 20;
    private int xPosGoldCoin = 950;
    private int xPosZilverCoin = 950;
    private int xPosGemBlue = 950;
    private boolean xPosGreenKey = false;
    
    public void act() 
    {
        update();
    }
    
    public void update()
    {
        if(score == 20)
        {
            leven ++;
            getWorld().addObject(new Leven(),xPosLeven,40);
            xPosLeven+=50;
            score=0;
        }
        
    }
    
}
