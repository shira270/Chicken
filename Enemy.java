public class Enemy {
    private int health;
    private int xPos;
    private int yPos;
    public final static int WIDTH = 50;
    public final static int HEIGHT = 50;
    private int cooldown;
    public final static int COOLDOWN = 3;
    public final static int SPEED = 30;

    public Enemy(int health, int xPos, int yPos) {
        this.health = health;
        this.xPos = xPos;
        this.yPos = yPos;
        this.cooldown = 0;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
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

    public void addxPos(int direction) {
        this.xPos += SPEED * direction;
    }
    public void addyPos(int direction) {
        this.yPos += SPEED * direction;
    }
    public int getyPos() {
        return yPos;
    }

    public int getHealth() {
        return health;
    }



    public void resetCooldown() {
        this.cooldown = COOLDOWN;
    }
    public void decreseCooldown() {
        this.cooldown -= 1;
        System.out.println(this.cooldown);
    }
    public int getCooldown() {
        return cooldown;
    }

    


    public void shoot(Egg egg) {

        new Thread(() -> {
            while(egg != null) {
                try {
                    Thread.sleep(5);
                    egg.addTOy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void takeDamage() {
        this.health -= 1;
        System.out.println("took a hit");
    }
}
