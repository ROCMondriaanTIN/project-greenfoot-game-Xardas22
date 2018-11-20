import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class test extends World {

    private CollisionEngine ce;
    
    
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public test() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg_castle.png");

        int[][] map = {
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,79,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,102,102,102,102,102,102,102,102,102,102,102,-1,-1,102,102,102,102,102,102,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,104,104,104,104,104,104,104,104,104,104,104,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {137,137,137,137,137,137,137,137,137,137,104,104,104,104,104,104,104,104,104,104,104,136,136,136,136,136,136,136,136,136,136,136,136,136,136},
                        {135,135,135,135,135,135,135,135,135,135,104,104,104,104,104,104,104,104,104,104,104,135,135,135,135,135,135,135,135,135,135,135,135,135,135},
                        {135,135,135,135,135,135,135,135,135,135,104,104,104,104,104,104,104,104,104,104,104,135,135,135,135,135,135,135,135,135,135,135,135,135,135},
                        {135,135,135,135,135,135,135,135,135,135,104,104,104,104,104,104,104,104,104,104,104,135,135,135,135,135,135,135,135,135,135,135,135,135,135},
                        {135,135,135,135,135,135,135,135,135,135,104,104,104,104,104,104,104,104,104,104,104,135,135,135,135,135,135,135,135,135,135,135,135,135,135},
                        {135,135,135,135,135,135,135,135,135,135,104,104,104,104,104,104,104,104,104,104,104,135,135,135,135,135,135,135,135,135,135,135,135,135,135},
        };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero("p1_stand.png");

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(hero, 300, 200);
        addObject(new Enemy(), 1170, 410);
        
        Music Music = new Music();
        
        addObject(Music, 978, 779);
        
        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
    }
        
    @Override
    public void act() {
        ce.update();
    }
}
