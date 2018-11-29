import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    
    private int direction = 2;      // 1 = links, 2 = rechts
    
    private int frame = 1;
    
    private int animateCounter = 0;
    
    private static int score;
    
    public boolean hasKey;
    
    private boolean hasCrystalRed;
    // boolean hasCrystalGreen;         Dit is voor eventueele easter egg
    // boolean hasCrystalBlue;
    // boolean hasCrystalYellow

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
        lookForObjects();
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
    
    public void lookForObjects()
    {
        if(isTouching(CoinZilver.class))
        {
            removeTouching(CoinZilver.class);
            Greenfoot.playSound("PickUpCoin.mp3");
            score += 1;
        }
        
        if(isTouching(CoinGold.class))
        {
            removeTouching(CoinGold.class);
            Greenfoot.playSound("PickUpCoin.mp3");            
            score += 2;
        }
        
        if(isTouching(DoorKey.class))
        {
            removeTouching(DoorKey.class);
            boolean hasKey = true;
        }
        
        if(isTouching(CrystalRed.class))
        {
            removeTouching(CrystalRed.class);
            boolean hasCrystalRed = true;
        }
        
    }
    
}
