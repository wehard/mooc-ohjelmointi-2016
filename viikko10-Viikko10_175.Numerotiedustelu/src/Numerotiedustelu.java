
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Numerotiedustelu {

    private List<Henkilo> henkilot;
    private Kayttoliittyma kayttis;

    public Numerotiedustelu() {
        this.henkilot = new ArrayList<>();
        this.kayttis = new Kayttoliittyma();
    }

    public void kaynnista() {
        this.tulostaOhjeet();

        boolean lopeta = false;

        while (!lopeta) {
            String komento = this.kayttis.kysy("komento: ");
            switch (komento) {
                case "1":
                    this.lisaaNumero();
                    break;
                case "2":
                    this.haeHenkilonNumerot();
                    break;
                case "3":
                    this.haeNumerolla();
                    break;
                case "4":
                    this.lisaaOsoite();
                    break;
                case "5":
                    this.haeHenkilonTiedot();
                    break;
                case "6":
                    this.poistaHenkilo();
                    break;
                case "7":
                    this.filtteroityHaku();
                    break;
                case "x":
                    lopeta = true;
                    break;
            }
        }

    }

    public void lisaaNumero() {
        String kenelle = this.kayttis.kysy("kenelle: ");
        String numero = this.kayttis.kysy("numero: ");
        if (this.getHenkilo(kenelle) != null) {
            this.getHenkilo(kenelle).lisaaNumero(numero);
        } else {
            Henkilo uusi = new Henkilo(kenelle);
            this.henkilot.add(uusi);
            uusi.lisaaNumero(numero);
        }
    }

    public void haeHenkilonNumerot() {
        String kenelle = this.kayttis.kysy("kenen: ");
        if (this.getHenkilo(kenelle) == null) {
            System.out.println("ei löytynyt");
            return;
        } else {
            this.kayttis.tulostaLista(this.getHenkilo(kenelle).getNumerot());
        }
    }

    public void haeNumerolla() {
        String numero = this.kayttis.kysy("numero: ");
        for (Henkilo h : this.henkilot) {
            if (h.onkoNumero(numero)) {
                System.out.println(h.getNimi());
                return;
            }
        }
        System.out.println("ei löytynyt");
    }

    public void lisaaOsoite() {
        String kenelle = this.kayttis.kysy("kenelle: ");
        String katu = this.kayttis.kysy("katu: ");
        String kaupunki = this.kayttis.kysy("kaupunki: ");
        Henkilo kuka = this.getHenkilo(kenelle);
        if (kuka != null) {
            kuka.setOsoite(katu, kaupunki);
        } else {
            // Luodaan uusi henkilö joka tarvitsee osoitteen
            Henkilo uusi = new Henkilo(kenelle);
            uusi.setOsoite(katu, kaupunki);
            this.henkilot.add(uusi);
        }

    }

    public void haeHenkilonTiedot() {
        String kenen = this.kayttis.kysy("kenen: ");
        Henkilo h = this.getHenkilo(kenen);
        if (h != null) {
            System.out.println("  osoite: " + h.getOsoite());

            if (h.getNumerot() == null) {
                System.out.println("  ei puhelinta");
            } else {
                System.out.println("  puhelinnumerot: ");
                for (String s : h.getNumerot()) {
                    System.out.println("    " + s);
                }
            }

        } else {
            System.out.println("ei löytynyt");
        }
    }

    public void poistaHenkilo() {
        Henkilo poistettava = this.getHenkilo(this.kayttis.kysy("kenet: "));

        if (poistettava != null) {
            this.henkilot.remove(poistettava);

        }

    }

    public Henkilo getHenkilo(String nimi) {
        for (Henkilo h : this.henkilot) {
            if (h.getNimi().equals(nimi)) {
                return h;
            }
        }
        return null;
    }

    public void filtteroityHaku() {
        Collections.sort(henkilot);
        String filtteri = this.kayttis.kysy("hakusana (jos tyhjä, listataan kaikki): ");
        if (filtteri.equals("")) {
            for (Henkilo h : this.henkilot) {
                /* 
                 pekka
                  osoite: ida ekmanintie helsinki
                  puhelinnumerot:
                   040-123456
                   09-222333
                 */
                this.tulostaHenkilo(h);
            }
        } else {
            boolean loytyiFiltterilla = false;
            for (Henkilo h : this.henkilot) {
                if (h.getNimi().contains(filtteri) || h.getOsoite().contains(filtteri) || h.onkoNumeroFiltterilla(filtteri)) {
                    this.tulostaHenkilo(h);
                    loytyiFiltterilla = true;
                }
            }
            if(loytyiFiltterilla == false) {
                System.out.println(" ei löytynyt");
            }
        }
        System.out.println("");
    }

    public void tulostaOhjeet() {
        System.out.println("numerotiedustelu");
        System.out.println("käytettävissä olevat komennot:");
        System.out.println("1 lisää numero");
        System.out.println("2 hae numerot");
        System.out.println("3 hae puhelinnumeroa vastaava henkilö");
        System.out.println("4 lisää osoite");
        System.out.println("5 hae henkilön tiedot");
        System.out.println("6 poista henkilön tiedot");
        System.out.println("7 filtteröity listaus");
        System.out.println("x lopeta");
        System.out.println("");
    }

    private void tulostaHenkilo(Henkilo h) {
        System.out.println(" " + h.getNimi());
        System.out.println("  " + h.getOsoite());
        for (String n : h.getNumerot()) {
            System.out.println("   " + n);
        }
    }

}
