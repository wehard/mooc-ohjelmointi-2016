
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraafinenLaskin implements Runnable {

    private JFrame frame;

    private JButton plus;
    private JButton minus;
    private JButton zbutton;

    private JTextField tulos;
    private JTextField syote;

    @Override
    public void run() {
        frame = new JFrame("Laskin");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        GridLayout gl = new GridLayout(3, 1);
        frame.setLayout(gl);

        tulos = new JTextField("0");
        tulos.setEnabled(false);

        syote = new JTextField("");
        JPanel panel = luoNapit();

        Kuuntelija kuuntelija = new Kuuntelija(plus, minus, zbutton, tulos, syote);

        plus.addActionListener(kuuntelija);
        minus.addActionListener(kuuntelija);
        zbutton.addActionListener(kuuntelija);

        container.add(tulos);
        container.add(syote);
        container.add(panel);

    }

    private JPanel luoNapit() {
        JPanel panel = new JPanel();
        GridLayout gl = new GridLayout(1, 3);
        panel.setLayout(gl);

        plus = new JButton("+");
        minus = new JButton("-");
        zbutton = new JButton("Z");
        zbutton.setEnabled(false);

        panel.add(plus);
        panel.add(minus);
        panel.add(zbutton);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
