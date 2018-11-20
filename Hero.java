
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;

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
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("w") && onGround() == true) {
            velocityY = -10;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -2;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 2;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
