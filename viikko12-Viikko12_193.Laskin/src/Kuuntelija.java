
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Kuuntelija implements ActionListener {

    private JButton plus;
    private JButton minus;
    private JButton zbutton;

    private JTextField tulos;
    private JTextField syote;

    public Kuuntelija(JButton plus, JButton minus, JButton zbutton, JTextField tulos, JTextField syote) {
        this.plus = plus;
        this.minus = minus;
        this.zbutton = zbutton;
        this.tulos = tulos;
        this.syote = syote;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == plus) {
            if (!this.onNumero(this.syote.getText())) {
                this.syote.setText("");
                return;
            }

            int i = Integer.parseInt(this.tulos.getText()) + Integer.parseInt(this.syote.getText());
            this.tulos.setText("" + i);
            this.syote.setText("");
            this.zbutton.setEnabled(true);
            if (this.tulos.getText().equals("0")) {
                this.zbutton.setEnabled(false);
            }

        } else if (e.getSource() == minus) {
            if (!this.onNumero(this.syote.getText())) {
                this.syote.setText("");
                return;
            }
            int i = Integer.parseInt(this.tulos.getText()) - Integer.parseInt(this.syote.getText());
            this.tulos.setText("" + i);
            this.syote.setText("");
            this.zbutton.setEnabled(true);
            if (this.tulos.getText().equals("0")) {
                this.zbutton.setEnabled(false);
            }

        } else if (e.getSource() == zbutton) {
            this.tulos.setText("0");
            this.syote.setText("");
            this.zbutton.setEnabled(false);

        }
    }

    private boolean onNumero(String s) {
        boolean onnumero = true;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            onnumero = false;
        }
        return onnumero;
    }

}
