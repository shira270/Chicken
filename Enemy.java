public class Enemy {
    private int health;
    private int xPos;
    private int yPos;
    public final static int WIDTH = 100;
    public final static int HEIGHT = 100;
    public Enemy(int health, int xPos, int yPos) {
        this.health = health;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
