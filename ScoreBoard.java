import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ScoreBoard extends Actor
{
    
    public static int leven = 2;
    private int score = 0;
    private int xPosLeven = 20;
    private int xPosGoldCoin = 750;
    private int xPosZilverCoin = 750;
    private int xPosCrystalRed = 750;
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
            getWorld().addObject(new Leven(), xPosLeven, 40);
            xPosLeven += 50;
            score = 0;            
        }
        
    } 
    
    public void updateCoinZilver()
    {
        score += 1;
        getWorld().addObject(new CoinZilver(),xPosZilverCoin, 60);
        xPosZilverCoin -= 20;
        update();
    }
    
    public void updateCoinGold()
    {
        score += 2;
        getWorld().addObject(new CoinZilver(),xPosGoldCoin, 100);
        xPosGoldCoin -= 20;
        update();
    }
    
    public void updateCrystalRed()
    {
        getWorld().addObject(new CrystalRed(), xPosCrystalRed, 140);
        update();
    }
    
}
