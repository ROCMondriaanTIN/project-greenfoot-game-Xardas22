import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ScoreBoard extends Actor
{
    
    public static int leven = 2;
    public static int score = 0;
    
    private int xPosLeven = 100;
    private int xPosZilverCoin = 950;
    private int xPosGoldCoin = 950;
    
    
    private int xPosCrystal = 100;
    
      
    private int xPosKey = 100;
    
    public void act() 
    {
        
    }
    
    public void updateLeven()
    {
        if(score == 20)
        {
            leven ++;
            getWorld().addObject(new Leven(true), xPosLeven, 40);
            xPosLeven += 50;
            score = 0;            
        }
        
    } 
    
    public void updateCoinZilver()
    {
        score += 10;
        // Methode is true dus in CoinZilver.class word applyVelocity(); uitgevoerd. Zelfde geld voor de rest.
        getWorld().addObject(new CoinZilver(true), xPosZilverCoin, 60); 
        xPosZilverCoin -= 20;
        updateLeven();
    }
    
    public void updateCoinGold()
    {
        score += 20;
        getWorld().addObject(new CoinGold(true), xPosGoldCoin, 100);
        xPosGoldCoin -= 20;
        updateLeven();
    }
    
    public void updateCrystalRed()
    {
        getWorld().addObject(new CrystalRed(true), xPosCrystal, 160);        
    }
    
    public void updateCrystalBlue()
    {
        getWorld().addObject(new crystalBlue(true), xPosCrystal, 160);        
    }
    
    public void updateCrystalGreen()
    {
        getWorld().addObject(new crystalGreen(true), xPosCrystal, 160);        
    }
    
    public void updateCrystalYellow()
    {
        getWorld().addObject(new crystalYellow(true), xPosCrystal, 160);        
    }
            
    public void updateKeyGreen()
    {
        getWorld().addObject(new DoorKeyGreen(true), xPosKey, 100);
    }
    
    public void updateKeyBlue()
    {
        getWorld().addObject(new DoorKeyGreen(true), xPosKey, 100);
    }
    
    public void updateKeyRed()
    {
        getWorld().addObject(new DoorKeyGreen(true), xPosKey, 100);
    }
    
    public void updateKeyYellow()
    {
        getWorld().addObject(new DoorKeyGreen(true), xPosKey, 100);
    }        
    
}
