package ilmoitin;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Ilmoitin implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Frame");
        frame.setPreferredSize(new Dimension(500,300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        GridLayout gridLayout = new GridLayout(3, 1);
        container.setLayout(gridLayout);
        JTextField textField = new JTextField("Teksti kopioituu alas");
        JButton button = new JButton("Päivitä");
        JLabel label = new JLabel();
        
        TapahtumanKuuntelija kuuntelija = new TapahtumanKuuntelija(textField, label);
        button.addActionListener(kuuntelija);
        
        
        
        container.add(textField);
        container.add(button);
        container.add(label);
        
    }
}
