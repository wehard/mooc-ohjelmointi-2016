package matopeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import matopeli.Suunta;
import matopeli.domain.Mato;
import matopeli.domain.Omena;
import matopeli.domain.Pala;
import matopeli.gui.Paivitettava;

public class Matopeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private boolean jatkuu;
    private Paivitettava paivitettava;

    private Mato mato;
    private Omena omena;

    public Matopeli(int leveys, int korkeus) {
        super(1000, null);

        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;

        this.mato = new Mato(leveys / 2, korkeus / 2, Suunta.ALAS);
        this.omena = this.luoUusiOmena();

        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean jatkuu() {
        return jatkuu;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!jatkuu) {
            return;
        }

        this.mato.liiku();
        this.tarkistaOmenanSyonti();

        if (this.mato.osuuItseensa()) {
            this.jatkuu = false;
        }

        this.tarkistaOnkoMatoPelialueella();
        this.paivitettava.paivita();
        this.setDelay(1000 / mato.getPituus());
    }

    private void tarkistaOmenanSyonti() {
        if (!this.mato.osuu(this.omena)) {
            return;
        }
        this.omena = this.luoUusiOmena();
        this.mato.kasva();
    }

    private void tarkistaOnkoMatoPelialueella() {
        Pala matoPaa = mato.getPalat().get(mato.getPalat().size() - 1);
        if (matoPaa.getX() < 0 || matoPaa.getX() > leveys - 1 || matoPaa.getY() < 0 || matoPaa.getY() > korkeus - 1) {
            this.jatkuu = false;
        }
    }

    private Omena luoUusiOmena() {
        Random rnd = new Random();
        int ox = rnd.nextInt(leveys);
        int oy = rnd.nextInt(korkeus);
        Omena o = new Omena(ox, oy);

        while (this.mato.osuu(o)) {
            ox = rnd.nextInt(leveys);
            oy = rnd.nextInt(korkeus);
            o = new Omena(ox, oy);
        }

        return o;
    }

    public Mato getMato() {
        return this.mato;
    }

    public void setMato(Mato mato) {
        this.mato = mato;
    }

    public Omena getOmena() {
        return this.omena;
    }

    public void setOmena(Omena omena) {
        this.omena = omena;
    }

}
