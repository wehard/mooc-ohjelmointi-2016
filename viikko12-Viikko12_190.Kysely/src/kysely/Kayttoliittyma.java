package kysely;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Luo sovelluksesi tänne
        frame = new JFrame("Ikkuna");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        container.add(new JLabel("Oletko?"));
        container.add(new JCheckBox("Kyllä"));
        container.add(new JCheckBox("En"));
        container.add(new JLabel("Miksi?"));
        
        JRadioButton siksi = new JRadioButton("Siksi.");
        JRadioButton koska = new JRadioButton("Koska se on kivaa!");
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(siksi);
        buttonGroup.add(koska);
        
        container.add(siksi);
        container.add(koska);
        
        container.add(new JButton("Valmis"));
    }

    public JFrame getFrame() {
        return frame;
    }
}
