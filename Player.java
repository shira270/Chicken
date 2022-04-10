

public class Player {
    private int health;
    
    //current player position
    private int xPos;
    private int yPos;
    public final static int WIDTH = 100;
    public final static int HEIGHT = 100;

    private int points;
    public Player(int health, int xPos, int yPos) {
        this.health = health;
        this.xPos = xPos;
        this.yPos = yPos;
        this.points = 0; 
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    
}
