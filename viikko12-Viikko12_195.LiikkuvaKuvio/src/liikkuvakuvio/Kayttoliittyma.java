package liikkuvakuvio;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Kuvio kuvio;

    public Kayttoliittyma(Kuvio kuvio) {
        this.kuvio = kuvio;
    }
    
    

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        lisaaKuuntelijat();

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        Piirtoalusta piirtoAlusta = new Piirtoalusta(this.kuvio);
        container.add(piirtoAlusta);
    }

    private void lisaaKuuntelijat() {
        NappaimistonKuuntelija kuuntelija = new NappaimistonKuuntelija(frame, kuvio);
        frame.addKeyListener(kuuntelija);
    }

    public JFrame getFrame() {
        return frame;
    }
}
