
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    
    private GreenfootImage frame1 = new GreenfootImage("p1_walk01.png");
    private GreenfootImage frame2 = new GreenfootImage("p1_walk02.png");
    private GreenfootImage frame3 = new GreenfootImage("p1_walk03.png");
    private GreenfootImage frame4 = new GreenfootImage("p1_walk04.png");
    private GreenfootImage frame5 = new GreenfootImage("p1_walk05.png");
    private GreenfootImage frame6 = new GreenfootImage("p1_walk06.png");
    private GreenfootImage frame7 = new GreenfootImage("p1_walk07.png");
    private GreenfootImage frame8 = new GreenfootImage("p1_walk08.png");
    private GreenfootImage frame9 = new GreenfootImage("p1_walk09.png");
    private GreenfootImage frame10 = new GreenfootImage("p1_walk10.png");
    private GreenfootImage frame11 = new GreenfootImage("p1_walk11.png");
    
    private int frame = 1;
    
    private int animateCounter = 0;

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
        animateStanding();
        if (spacebar() && onGround() == true) 
        {
            velocityY = -12;
        }

        if (keyLeft()) 
        {
            velocityX = -2;
        } 
        
        else if (keyRight()) 
        {
            velocityX = 2;
            if(animateCounter % 3 == 0)
            {                
                animateRight();                
            }
            
        }
        
    }
    
    public void animateStanding()
    {        
        if(spacebar() == false && keyRight() == false && keyLeft() == false 
        && velocityY == 0)
        {
            setImage("p1_stand.png");            
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
    
}
