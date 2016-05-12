
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Lentokentta {

    private ArrayList<Lentokone> lentokoneet = new ArrayList<>();
    private ArrayList<Lento> lennot = new ArrayList<>();
    private Lukija lukija = new Lukija();

    public Lentokentta() {

    }

    public void kaynnistaHallinta() {
        boolean lopeta = false;
        System.out.println("Lentokentän hallinta");
        System.out.println("--------------------");
        System.out.println("");
        while (!lopeta) {
            tulostaHallintaOhjeet();
            String komento = lukija.lueMerkkijono();
            switch (komento) {
                case "1": // Lisaa lentokone
                    lisaaLentokone();
                    break;
                case "2": // Lisaa lento
                    lisaaLento();
                    break;
                case "x": // Lopeta
                    lopeta = true;
                    break;
                default:
            }
        }
    }

    public void kaynnistaPalvelu() {
        boolean lopeta = false;
        System.out.println("Lentopalvelu");
        System.out.println("------------");
        System.out.println("");
        while (!lopeta) {
            tulostaPalveluOhjeet();
            String komento = lukija.lueMerkkijono();
            switch (komento) {
                case "1": // Tulosta lentokoneet
                    this.tulostaLentokoneet();
                    break;
                case "2": // Tulosta lennot
                    this.tulostaLennot();
                    break;
                case "3": // Tulosta lentokoneen tiedot
                    this.tulostaLentokoneenTiedot();
                    break;
                case "x": // Lopeta
                    lopeta = true;
                    break;
                default:
            }
        }

    }

    private void lisaaLentokone() {
        System.out.print("Anna lentokoneen tunnus: ");
        String tunnus = lukija.lueMerkkijono();
        System.out.print("Anna lentokoneen kapasiteetti: ");
        int kapasiteetti = lukija.lueKokonaisluku();
        lentokoneet.add(new Lentokone(tunnus, kapasiteetti));
    }

    private void lisaaLento() {
        System.out.print("Anna lentokoneen tunnus: ");
        String tunnus = lukija.lueMerkkijono();
        System.out.print("Anna lähtöpaikan tunnus: ");
        String lahtopaikka = lukija.lueMerkkijono();
        System.out.print("Anna kohdepaikan tunnus: ");
        String kohdepaikka = lukija.lueMerkkijono();
        Lentokone l = null;
        for (Lentokone kone : lentokoneet) {
            if (kone.getTunnus().equals(tunnus)) {
                l = kone;
            }
        }
        if (l != null) {
            lennot.add(new Lento(l, lahtopaikka, kohdepaikka));
        }
    }

    private void tulostaLentokoneet() {
        for (Lentokone l : lentokoneet) {
            System.out.println(l.toString());
        }
    }

    private void tulostaLennot() {
        for (Lento l : lennot) {
            System.out.println(l.toString());
        }
    }
    
    private void tulostaLentokoneenTiedot() {
        System.out.print("Mikä kone: ");
        String kone = lukija.lueMerkkijono();
        for(Lentokone l : lentokoneet) {
            if(l.getTunnus().equals(kone)) {
                System.out.println(l.toString());
            }
        }
    }

    private void tulostaHallintaOhjeet() {
        System.out.println("Valitse toiminto:");
        System.out.println("[1] Lisää lentokone");
        System.out.println("[2] Lisää lento");
        System.out.println("[x] Poistu hallintamoodista");
        System.out.print("> ");
    }

    private void tulostaPalveluOhjeet() {
        System.out.println("Valitse toiminto:");
        System.out.println("[1] Tulosta lentokoneet");
        System.out.println("[2] Tulosta lennot");
        System.out.println("[3] Tulosta lentokoneen tiedot");
        System.out.println("[x] Lopeta");
        System.out.print("> ");
    }

}
