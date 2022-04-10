import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

public class GamePanel extends JPanel{

    private Player player;
    private Enemy[] enemies;
    private final static int ENEMY_AMOUNT = 4;
    public GamePanel(Player player) {
        this.player = player;
        this.initializeEnemies();
        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.white);
        gamePanel.setBounds(0, 0, 300, 420);
        

    }

    private void initializeEnemies() {
        Enemy[] enemies = new Enemy[ENEMY_AMOUNT];
        int startPos = 0;
        for(int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(3, startPos, 0);
            startPos += 200;
        }
        this.enemies = enemies;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(player.getxPos(), player.getyPos(), Player.WIDTH, Player.HEIGHT);
        g.setColor(Color.blue);
        for (Enemy enemy : enemies) {
            g.fillRect(enemy.getxPos(), enemy.getyPos(), Enemy.WIDTH, Enemy.HEIGHT);
        }
    }
    

    
}
