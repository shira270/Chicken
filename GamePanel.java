import java.awt.*;

import java.util.ArrayList;

import javax.swing.*;


public class GamePanel extends JPanel{

    private Player player;
    private Enemy[] enemies;
    private ArrayList<Egg> eggs;
    private ImageIcon spaceship;
    private ImageIcon chicken;
    private ImageIcon space;
    private JLabel text;

    private final static int ENEMY_AMOUNT = 5;
    private final static int ENEMY_HRT = 3;
    private final static int ENEMY_SPACING = 20;

    public GamePanel(Player player) {

        this.player = player;
        this.initializeEnemies();
        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.white);
        gamePanel.setBounds(0, 0, 300, 420);
        this.eggs = new ArrayList<>();

        this.spaceship = new ImageIcon("spaceship.jpg");
        this.chicken = new ImageIcon("R.jpg");

    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public int checkCollision(Enemy[] enemies, Egg egg) {
        int enemyNumber = -1;
        for(int i = 0; i < enemies.length; i++) {
            if((enemies[i] != null) && (egg.getxPos() > enemies[i].getxPos() && egg.getxPos() < enemies[i].getxPos() + Enemy.WIDTH) && (egg.getyPos() > enemies[i].getyPos() && egg.getyPos() < enemies[i].getyPos() + Enemy.WIDTH)) {
                enemyNumber = i;
                System.out.println("collision!");
                break;
            }
        }
        return enemyNumber;
    }

    private void checkPlayerCollision() {
        for (Enemy enemy : enemies) {
            if(enemy != null){
                boolean checkX = (player.getxPos() >= enemy.getxPos() && player.getxPos() <= enemy.getxPos() + Enemy.WIDTH) || (player.getxPos() + Player.WIDTH >= enemy.getxPos() && player.getxPos() + Player.WIDTH <= enemy.getxPos() + Enemy.WIDTH);
                boolean checkY = (player.getyPos() >= enemy.getyPos() && player.getyPos() <= enemy.getyPos() + Enemy.WIDTH) || (player.getyPos() + Player.WIDTH >= enemy.getyPos() && player.getyPos() + Player.WIDTH <= enemy.getyPos() + Enemy.WIDTH);
                if(checkX && checkY) {
                    this.gameOver();
                }
            }
        }
    }

    private void checkWin() {
        for (Enemy enemy : enemies) {
            if(enemy != null){
                return;
            }
        }
        this.gameOver();
    }

    private void gameOver() {


        for (int i = 0; i < this.enemies.length; i++) {
            this.enemies[i] = null;
        }
        initializeEnemies();
        this.player.setxPos(Player.startX_Pos);
        this.player.setyPos(Player.startY_Pos);

        if(this.player.getPoints() > Player.maxPoints) {
            Player.maxPoints = this.player.getPoints();

        }
    }

    public void addToList(Egg egg) {
        eggs.add(egg);
    }

    private void initializeEnemies() {
        Enemy[] enemies = new Enemy[ENEMY_AMOUNT];
        int startX_Pos = 0;
        int startY_Pos = 0;
        for(int i = 0; i < enemies.length; i++) {
            if(startX_Pos + Enemy.WIDTH > Main.WIND_WIDTH) {
                startY_Pos += Enemy.HEIGHT + ENEMY_SPACING;
                startX_Pos = 0;
            }
            enemies[i] = new Enemy(ENEMY_HRT, startX_Pos, startY_Pos);
            startX_Pos += 80;
        }
        this.enemies = enemies;
    }

    @Override
    protected void paintComponent(Graphics g) {
        checkPlayerCollision();
        checkWin();
        super.paintComponent(g);
        this.space = new ImageIcon("M.jpg");
        this.space.paintIcon(this , g , 0 , -50);

        this.spaceship.paintIcon(this, g , player.getxPos() , player.getyPos());
        for (Enemy enemy : enemies) {
            if(enemy != null){
                this.chicken.paintIcon(this, g , enemy.getxPos() , enemy.getyPos());
            }
        }
        for (int i = 0; i < this.eggs.size(); i++) {
            if(this.eggs.get(i) != null) {
                g.setColor(Color.black);
                g.fillRect(this.eggs.get(i).getxPos(), this.eggs.get(i).getyPos(), Egg.WIDTH, Egg.HEIGHT);
                int enemyIndex = this.checkCollision(this.enemies, this.eggs.get(i));
                if(enemyIndex != -1) {
                    this.enemies[enemyIndex].takeDamage();
                    this.eggs.set(i, null);
                    if(this.enemies[enemyIndex].getHealth() <= 0) {
                        this.enemies[enemyIndex] = null;
                        this.player.addPoints();
                    }
                }
            }

        }



    }

    public JLabel getText() {
        return text;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

}
