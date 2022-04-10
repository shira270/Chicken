import java.awt.Color;

import javax.swing.*;
public class Main extends JFrame{
    private static final String TITLE = "Chicken Invaders";
    private static final int WIND_HEIGHT = 1000;
    private static final int WIND_WIDTH = 1000;
    public Main() {
        this.setTitle(TITLE);
        this.setResizable(false);
        this.setSize(WIND_WIDTH, WIND_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       Player player = new Player(10, 100, 100);

       GamePanel gPanel = new GamePanel(player);

       this.add(gPanel);
        
    }
    public static void main(String[] args) {
        Main window = new Main();
    }
}