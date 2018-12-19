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
    
    private int direction = 2;      // 1 = links, 2 = rechts
       
    
    private int animateCounter = 0;
    
    private int maxImages = 11;
    private int maxAnimateSpeed = 3;
    private int frame = 1;
    private int animationSpeed = 0;
    
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
        Actor underLeft = getOneObjectAtOffset(-getImage().getWidth() / 2, getImage().getHeight() / 2, Tile.class);
        Actor underRight = getOneObjectAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2, Tile.class);
        Tile tile1 = (Tile) underLeft;
        Tile tile2 = (Tile) underRight;
        return (tile1 != null && tile1.isSolid) || (tile2 != null && tile2.isSolid);
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
        
        if(isTouching(WaterTile.class) || isTouching(Enemy.class))        
        {
            setLocation(530, 375);            
        }
                
        
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
        
        animationSpeed ++;
    }
    
    public void animator()
    {
        setImage("p1_walk" + frame + ".png");
        
        if(direction == 1)
        {
            getImage().mirrorHorizontally();
        }
        
        if(animationSpeed > maxAnimateSpeed)
        {
           animationSpeed = 0;
           
           frame ++;
           
           if(frame > maxImages)
           {
               frame = 1;
           }
           
        }
        
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
            animator();
        } 
        
        else if (keyRight()) 
        {
            velocityX = 2;
            direction = 2;
            animator();
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
        Greenfoot.playSound("PickUpKey.mp3");
        hasKeyGreen = true;
        }
        
    }   
    
    public void grabKeyBlue()
    {
        if(isTouching(doorKeyBlue.class))
        {
        removeTouching(doorKeyBlue.class);        
        scb.updateKeyGreen();
        Greenfoot.playSound("PickUpKey.mp3");
        hasKeyBlue = true;
        }
        
    }   
    
    public void grabKeyRed()
    {
        if(isTouching(doorKeyRed.class))
        {
        removeTouching(doorKeyRed.class);        
        scb.updateKeyGreen();
        Greenfoot.playSound("PickUpKey.mp3");
        hasKeyRed = true;
        }
        
    }   
    
    public void grabKeyYellow()
    {
        if(isTouching(doorKeyYellow.class))
        {
        removeTouching(doorKeyYellow.class);        
        scb.updateKeyGreen();
        Greenfoot.playSound("PickUpKey.mp3");
        hasKeyYellow = true;
        }
        
    }  
    
    public void grabCollectable()
    {
        if(isTouching(Collectables.class))
        {
            removeTouching(Collectables.class);
        }
        
    }
    
} 
