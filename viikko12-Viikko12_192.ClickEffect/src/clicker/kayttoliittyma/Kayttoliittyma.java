package clicker.kayttoliittyma;

import clicker.sovelluslogiikka.Laskuri;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Laskuri laskuri;
    
    
    
    public Kayttoliittyma(Laskuri laskuri) {
        this.laskuri = laskuri;
    }
    

    @Override
    public void run() {
        frame = new JFrame("The Effect");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        GridLayout gl = new GridLayout(2, 1);
        container.setLayout(gl);
        
        JLabel numero = new JLabel(""+this.laskuri.annaArvo());
        JButton button = new JButton("Click!");
        
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(laskuri, numero);
        button.addActionListener(kuuntelija);
        
        container.add(numero);
        container.add(button);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
