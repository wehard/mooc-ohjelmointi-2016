package piirtaminen.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {

    public Piirtoalusta() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        graphics.setColor(Color.black);
        
        graphics.fillRect(100, 50, 50, 50);
        graphics.fillRect(250, 50, 50, 50);
        graphics.fillRect(50, 200, 50, 50);
        graphics.fillRect(100, 250, 200, 50);
        graphics.fillRect(300, 200, 50, 50);

    }
}
