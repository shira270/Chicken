import java.awt.Color;
import java.awt.event.*;  

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;
public class Main extends JFrame implements KeyListener{
    private static final String TITLE = "Chicken Invaders";
    private static final int WIND_HEIGHT = 1000;
    private static final int WIND_WIDTH = 1000;
    private Player player;

    public Main() {
        this.setTitle(TITLE);
        this.setResizable(false);
        this.setSize(WIND_WIDTH, WIND_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);


        this.player = new Player(10, 100, 100);

        GamePanel gPanel = new GamePanel(player);
        
        this.add(gPanel);
        while(true) {
            gPanel.revalidate();
            gPanel.repaint();
        }
    }

    
    public static void main(String[] args) {
        Main window = new Main();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyChar()) {
            case 'd':
                this.player.addxPos(Player.SPEED);
                break;
            case 'a':
                this.player.addxPos(-Player.SPEED);
                break;
            case 'w':
                this.player.addyPos(-Player.SPEED);
                break;
            case 's':
                this.player.addyPos(Player.SPEED);
                break;
        }
        
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}