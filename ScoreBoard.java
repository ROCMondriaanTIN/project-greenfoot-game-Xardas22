import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ScoreBoard extends Actor
{
    
    public static int leven = 2;
    private int score = 0;
    private int xPosLeven = 20;
    private int xPosZilverCoin = 950;
    private int xPosGoldCoin = 950;
    private int xPosCrystalRed = 100;
    private boolean xPosGreenKey = false;
    
    public void act() 
    {
        
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
        // Methode is true dus in CoinZilver.class word applyVelocity(); uitgevoerd. Zeflde geld voor de rest.
        getWorld().addObject(new CoinZilver(true), xPosZilverCoin, 60); 
        xPosZilverCoin -= 20;
        update();
    }
    
    public void updateCoinGold()
    {
        score += 2;
        getWorld().addObject(new CoinGold(true), xPosGoldCoin, 100);
        xPosGoldCoin -= 20;
        update();
    }
    
    public void updateCrystalRed()
    {
        getWorld().addObject(new CrystalRed(true), xPosCrystalRed, 160);
        update();
    }
    
}
