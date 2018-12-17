import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class level1 extends World {

    private CollisionEngine ce;
    
    public String activeWorld = "Level 1";
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public level1() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");

        int[][] map = {
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,120,120,120,120,120,120,120,120,120,120,120,120,120,-1,-1,-1,-1,-1},
                {136,136,136,136,136,136,136,136,136,103,103,103,103,103,103,103,103,136,136,136,136,136,136,136,136},
                {135,135,135,135,135,135,135,135,135,103,103,103,103,103,103,103,103,135,135,135,135,135,135,135,135},
                {135,135,135,135,135,135,135,135,135,103,103,103,103,103,103,103,103,135,135,135,135,135,135,135,135},
                {135,135,135,135,135,135,135,135,135,103,103,103,103,103,103,103,103,135,135,135,135,135,135,135,135},
                {135,135,135,135,135,135,135,135,135,103,103,103,103,103,103,103,103,135,135,135,135,135,135,135,135},
                {135,135,135,135,135,135,135,135,135,103,103,103,103,103,103,103,103,135,135,135,135,135,135,135,135},
                {135,135,135,135,135,135,135,135,135,103,103,103,103,103,103,103,103,135,135,135,135,135,135,135,135},
            };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero Xardas = new Hero("p1_stand.png");
        Hero Talia = new Hero("p2_stand.png");
        Hero Percy = new Hero("p3_stand.png");

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(Xardas);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        addObject(Xardas, 530, 375);        

        CoinGold coinGold = new CoinGold();
        CoinZilver coinZilver = new CoinZilver();
        DoorKeyGreen doorKeyGreen = new DoorKeyGreen();
        CrystalRed crystalRed = new CrystalRed();
        
        Door door = new Door();
        addObject(door, 1100, 365);

        addObject(coinZilver, 745, 375);
        addObject(coinGold, 825, 375);
        addObject(doorKeyGreen, 920, 375);
        addObject(crystalRed, 825, 275);
       
        // CrystalHUD crystalHUD = new CrystalHUD();
        // KeyHUD  keyHUD = new KeyHUD();
        // LifeHUD  lifeHUD = new LifeHUD();

        // addObject(coinHUD, 100, 220);        // Deze moet rechts boven scherm
        // addObject(crystalHUD, 100, 160);     // Deze onder Key
        // addObject(keyHUD, 100, 100);         // Deze onder levens
        // addObject(lifeHUD, 165, 40);         // Deze moet links boven scherm

        Music Music = new Music();

        addObject(Music, 30, 30);

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(Xardas);

        prepare();
    }

    @Override
    public void act() {
        ce.update();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }
    
}
