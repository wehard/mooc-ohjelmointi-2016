/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

/**
 *
 * @author willehard
 */
public class MuistavaTuotevarasto extends Tuotevarasto {

    private Muutoshistoria muutosHistoria = new Muutoshistoria();

    public MuistavaTuotevarasto(String tuotenimi, double tilavuus, double alkuSaldo) {
        super(tuotenimi, tilavuus);
        super.lisaaVarastoon(alkuSaldo);
        this.muutosHistoria.lisaa(alkuSaldo);
    }

    public String historia() {
        return this.muutosHistoria.toString();
    }

    @Override
    public void lisaaVarastoon(double maara) {
        if (maara > 0) {
            super.lisaaVarastoon(maara);
            this.muutosHistoria.lisaa(getSaldo());
        }

    }

    @Override
    public double otaVarastosta(double maara) {
        if (maara > 0) {
            double tmp = super.otaVarastosta(maara);
            this.muutosHistoria.lisaa(getSaldo());
            return tmp;
        }
        return 0;
    }

    public void tulostaAnalyysi() {
        System.out.println("Tuote: " + this.getNimi());
        System.out.println("Historia: " + this.historia());
        System.out.println("Suurin tuotemäärä: " + this.muutosHistoria.maxArvo());
        System.out.println("Pienin tuotemäärä: " + this.muutosHistoria.minArvo());
        System.out.println("Keskiarvo: " + this.muutosHistoria.keskiarvo());
        System.out.println("Suurin muutos: " + this.muutosHistoria.suurinMuutos());
        System.out.println("Varianssi: " + this.muutosHistoria.varianssi());
    }

}
