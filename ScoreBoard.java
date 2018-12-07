import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ScoreBoard extends Actor
{
    
    public static int leven = 2;
    private int score = 0;
    
    private int xPosLeven = 100;
    private int xPosZilverCoin = 950;
    private int xPosGoldCoin = 950;
    
    
    private int xPosCrystalRed = 100;
    
    
    private int xPosGreenKey = 100;
    private int xPosBlueKey = 100;
    private int xPosRedKey = 100;
    private int xPosYellowKey = 100;
    
    public void act() 
    {
        
    }
    
//    public void updateLeven()
//    {
//        if(score == 20)
//        {
//            leven ++;
//            getWorld().addObject(new Leven(), xPosLeven, 40);
//            xPosLeven += 50;
//            score = 0;            
//        }
//        
//    } 
    
    public void updateCoinZilver()
    {
        score += 1;
        // Methode is true dus in CoinZilver.class word applyVelocity(); uitgevoerd. Zelfde geld voor de rest.
        getWorld().addObject(new CoinZilver(true), xPosZilverCoin, 60); 
        xPosZilverCoin -= 20;
        // updateLeven();
    }
    
    public void updateCoinGold()
    {
        score += 2;
        getWorld().addObject(new CoinGold(true), xPosGoldCoin, 100);
        xPosGoldCoin -= 20;
        // updateLeven();
    }
    
    public void updateCrystalRed()
    {
        getWorld().addObject(new CrystalRed(true), xPosCrystalRed, 160);        
    }
    
    public void updateKeyGreen()
    {
        getWorld().addObject(new DoorKeyGreen(true), xPosGreenKey, 100);
    }
    
    public void updateKeyBlue()
    {
        getWorld().addObject(new DoorKeyGreen(true), xPosBlueKey, 100);
    }
    
    public void updateKeyRed()
    {
        getWorld().addObject(new DoorKeyGreen(true), xPosRedKey, 100);
    }
    
    public void updateKeyYellow()
    {
        getWorld().addObject(new DoorKeyGreen(true), xPosYellowKey, 100);
    }
    
}
