package sanatutkimus;

import java.io.File;
import java.io.FileNotFoundException;

public class Paaohjelma {

    public static void main(String[] args) throws FileNotFoundException {
        // testaa luokkasi toimintaa täällä

        File tiedosto = new File("src/pienilista.txt");
        // kaikki sanat tiedostossa src/sanalista.txt
        Sanatutkimus s = new Sanatutkimus(tiedosto);
        System.out.println(s.kaikkiVokaalitSisaltavatSanat().size());

    }
}
