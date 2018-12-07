import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    
    private int zilverCoin;
    private int goldCoin;
        
    public static int levens = 2;
    
    private int direction = 2;      // 1 = links, 2 = rechts
    
    private int frame = 1;
    
    private int animateCounter = 0;
    
    public static boolean hasKeyGreen = false;
    public static boolean hasKeyBlue = false;
    public static boolean hasKeyRed = false;
    public static boolean hasKeyYellow = false;
    
    // private Hero hero1;
    
    ScoreBoard scb;
    
    private static boolean hasCrystalRed;
    private static boolean hasCrystalGreen;         
    private static boolean hasCrystalBlue;
    private static boolean hasCrystalYellow;

    public Hero(String image) {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage(image);
    }

    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getHeight()/2, Tile.class);
        Tile tile = (Tile) under;
        return tile != null && tile.isSolid == true;
    }
    
    
    
    
    @Override
    public void act() {
        handleInput(); 
        grabZilverCoin();
        grabGoldCoin();
        
        grabCrystalRed();
        grabCrystalGreen();
        grabCrystalYellow();
        grabCrystalBlue();
        
        grabKeyGreen();
        grabKeyBlue();
        grabKeyRed();
        grabKeyYellow();
        
        grabLeven();
        
        if(scb == null)
        {
        scb = new ScoreBoard();
        getWorld().addObject(scb, -10,-10);        
        }
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                return;
            }
        }
        
        for (Actor waterTile : getIntersectingObjects(WaterTile.class)) {
            if (waterTile != null) {
                getWorld().removeObject(this);
                return;
            }
        } 
        animateCounter ++;
    }

    public void handleInput() {
        animateStandingRight(); 
        animateStandingLeft();
        if (spacebar() && onGround() == true) 
        {
            velocityY = -12;
            setImage("p1_jump.png");
        }

        if (keyLeft()) 
        {
            velocityX = -2;
            direction = 1;
            if(animateCounter % 3 == 0)
            {
                animateLeft();
                animateStandingLeft();
            }
            
        } 
        
        else if (keyRight()) 
        {
            velocityX = 2;
            direction = 2;
            if(animateCounter % 3 == 0)
            {                
                animateRight();
                animateStandingRight();
            }
            
        }
        
    }
    
    public void animateStandingRight()
    {        
        if(spacebar() == false && keyRight() == false && keyLeft() == false 
        && velocityY == 0 && direction == 2)
        {
            setImage("p1_stand.png");            
        }
        
    }
    
    public void animateStandingLeft()
    {        
        if(spacebar() == false && keyRight() == false && keyLeft() == false 
        && velocityY == 0 && direction == 1)
        {
            setImage("p1_stand.png");
            getImage().mirrorHorizontally();
        }
        
    }
           
    public void animateRight()
    {
        if(frame == 1)
        {
            setImage("p1_walk01.png");
        }
        else if(frame == 2)
        {
            setImage("p1_walk02.png");
        }
         else if(frame == 3)
        {
            setImage("p1_walk03.png");
        } 
         else if(frame == 4)
        {
            setImage("p1_walk04.png");
        } 
         else if(frame == 5)
        {
            setImage("p1_walk05.png");
        } 
         else if(frame == 6)
        {
            setImage("p1_walk06.png");
        } 
        else if(frame == 7)
        {
            setImage("p1_walk07.png");
        }
         else if(frame == 8)
        {
            setImage("p1_walk08.png");
        }
         else if(frame == 9)
        {
            setImage("p1_walk09.png");
        }
         else if(frame == 10)
        {
            setImage("p1_walk10.png");
        }
         else if(frame == 11)
        {
            setImage("p1_walk11.png");
            frame = 1;
            return;
        }   
        
        frame ++;
    }
    
    public void animateLeft()
    {
        if(frame == 1)
        {
            setImage("p1_walk01.png");
            getImage().mirrorHorizontally();
        }
        else if(frame == 2)
        {
            setImage("p1_walk02.png");
            getImage().mirrorHorizontally();
        }
         else if(frame == 3)
        {
            setImage("p1_walk03.png");
            getImage().mirrorHorizontally();
        } 
         else if(frame == 4)
        {
            setImage("p1_walk04.png");
            getImage().mirrorHorizontally();
        } 
         else if(frame == 5)
        {
            setImage("p1_walk05.png");
            getImage().mirrorHorizontally();
        } 
         else if(frame == 6)
        {
            setImage("p1_walk06.png");
            getImage().mirrorHorizontally();
        } 
         else if(frame == 7)
        {
            setImage("p1_walk07.png");
            getImage().mirrorHorizontally();
        }
         else if(frame == 8)
        {
            setImage("p1_walk08.png");
            getImage().mirrorHorizontally();
        }
         else if(frame == 9)
        {
            setImage("p1_walk09.png");
            getImage().mirrorHorizontally();
        }
         else if(frame == 10)
        {
            setImage("p1_walk10.png");
            getImage().mirrorHorizontally();
        }
         else if(frame == 11)
        {
            setImage("p1_walk11.png");
            getImage().mirrorHorizontally();
            frame = 1;
            return;
        }   
        
        frame ++;
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    
    public boolean spacebar()
    {
        boolean spacebar = Greenfoot.isKeyDown("space");
        return spacebar;        
    }
    
    public boolean keyRight()
    {
        boolean keyRight = Greenfoot.isKeyDown("right");
        return keyRight;        
    }
    
    public boolean keyLeft()
    {
        boolean keyLeft = Greenfoot.isKeyDown("left");
        return keyLeft;        
    }
    
    public void grabZilverCoin()
    {
        if(isTouching(CoinZilver.class))
        {            
            removeTouching(CoinZilver.class);
            scb.updateCoinZilver();
            Greenfoot.playSound("PickUpCoin.mp3");
            zilverCoin ++;
        }
        
    }
    
    public void grabGoldCoin()
    {
        if(isTouching(CoinGold.class))
        {            
            removeTouching(CoinGold.class);
            scb.updateCoinGold(); 
            Greenfoot.playSound("PickUpCoin.mp3");
            goldCoin += 2;
        }
        
    } 
    
    public void grabCrystalRed()
    {
        if(isTouching(CrystalRed.class))
        {
            removeTouching(CrystalRed.class);
            scb.updateCrystalRed();
            Greenfoot.playSound("CrystalPickUp.mp3");
            hasCrystalRed = true;            
        }
        
    }    

    public void grabCrystalGreen()
    {
        if(isTouching(crystalGreen.class))
        {
            removeTouching(crystalGreen.class);
            scb.updateCrystalGreen();
            Greenfoot.playSound("CrystalPickUp.mp3");
            hasCrystalGreen = true;
        }
        
    }
    
    public void grabCrystalBlue()
    {
        if(isTouching(crystalBlue.class))
        {
            removeTouching(crystalGreen.class);
            scb.updateCrystalBlue();
            Greenfoot.playSound("CrystalPickUp.mp3");
            hasCrystalGreen = true;
        }
        
    }
    
    public void grabCrystalYellow()
    {
        if(isTouching(crystalYellow.class))
        {
            removeTouching(crystalGreen.class);
            scb.updateCrystalYellow();
            Greenfoot.playSound("CrystalPickUp.mp3");
            hasCrystalGreen = true;
        }
        
    }
    
    public void grabKeyGreen()
    {
        if(isTouching(DoorKeyGreen.class))
        {
        removeTouching(DoorKeyGreen.class);        
        scb.updateKeyGreen();
        Greenfoot.playSound("DOOM.mp3");
        hasKeyGreen = true;
        }
        
    }   
    
    public void grabKeyBlue()
    {
        if(isTouching(doorKeyBlue.class))
        {
        removeTouching(doorKeyBlue.class);        
        scb.updateKeyGreen();
        Greenfoot.playSound("DOOM.mp3");
        hasKeyBlue = true;
        }
        
    }   
    
    public void grabKeyRed()
    {
        if(isTouching(doorKeyRed.class))
        {
        removeTouching(doorKeyRed.class);        
        scb.updateKeyGreen();
        Greenfoot.playSound("DOOM.mp3");
        hasKeyRed = true;
        }
        
    }   
    
    public void grabKeyYellow()
    {
        if(isTouching(doorKeyYellow.class))
        {
        removeTouching(doorKeyYellow.class);        
        scb.updateKeyGreen();
        Greenfoot.playSound("DOOM.mp3");
        hasKeyYellow = true;
        }
        
    }   
    
    public void grabLeven()
    {
        if(isTouching(Leven.class))
        {
            removeTouching(Leven.class);
            scb.updateLeven();
            Greenfoot.playSound("1UP.mp3");            
        }
        
    }
    
} 
