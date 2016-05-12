package liikkuvakuvio;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // testaa ohjelmasi toimintaa täällä
        Koostekuvio rekka = new Koostekuvio();

        rekka.liita(new Laatikko(220, 110, 75, 100));
        rekka.liita(new Laatikko(80, 120, 200, 100));
        rekka.liita(new Ympyra(100, 200, 50));
        rekka.liita(new Ympyra(220, 200, 50));

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(rekka);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
