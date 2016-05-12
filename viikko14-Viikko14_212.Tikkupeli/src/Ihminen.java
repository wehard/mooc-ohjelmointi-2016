
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Ihminen implements Pelaaja {

    private PelaajaTyyppi tyyppi = PelaajaTyyppi.Ihminen;
    private String nimi;

    private Tikkupeli tp;
    private Kayttoliittyma kl;
    private boolean voitto = false;

    public Ihminen(String nimi, Tikkupeli tp, Kayttoliittyma kl) {
        this.tp = tp;
        this.kl = kl;
        this.nimi = nimi;
    }

    @Override
    public void pelaa() {
        this.tp.otaTikkuja(kl.kysyLukuaValilta(this.getNimi() + ": Kuinka monta tikkua nostat (1-3)? ", 1, 3));
        this.tp.setLastPlayer(this);
    }

    @Override
    public PelaajaTyyppi getTyyppi() {
        return this.tyyppi;
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ihminen other = (Ihminen) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        if (this.tyyppi != other.tyyppi) {
            return false;
        }
        return true;
    }

    @Override
    public void setVoitto(boolean b) {
        this.voitto = b;
    }

    
    
}
