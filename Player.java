

public class Player {
    
    //current player position
    private int xPos;
    private int yPos;
    private int cooldown;

    public final static int WIDTH = 100;
    public final static int HEIGHT = 100;
    public final static int SPEED = 15;
    public final static int COOLDOWN = 1;
    public final static int startX_Pos = 500 - Player.WIDTH;
    public final static int startY_Pos = 700 - Player.WIDTH;
    public static int maxPoints = 0;

    private int points;
    
    public Player(int health, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.points = 0;
        this.cooldown = 0; 
    }

    public void resetCooldown() {
        this.cooldown = COOLDOWN;
    }
    public void decreseCooldown() {
        this.cooldown -= 1;
    }
    public int getCooldown() {
        return cooldown;
    }
    public void shoot(Egg egg) {

        new Thread(() -> {
            while(egg != null) {
                try {
                    Thread.sleep(5);
                    egg.takeFromY();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
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

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void addxPos(int direction) {
        this.xPos += SPEED * direction;
    }

    public void addyPos(int direction) {
        this.yPos += SPEED * direction;
    }

    public void addPoints() {
        this.points++;
    }

    public int getPoints() {
        return points;
    }
}
