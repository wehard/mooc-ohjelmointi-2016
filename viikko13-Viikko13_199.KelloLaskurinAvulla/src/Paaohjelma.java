
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        YlhaaltaRajoitettuLaskuri sekunnit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri minuutit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri tunnit = new YlhaaltaRajoitettuLaskuri(23);

        System.out.print("sekunnit: ");
        int sek = Integer.parseInt(lukija.nextLine()); // kysy sekuntien alkuarvo käyttäjältä
        System.out.print("minuutit: ");
        int min = Integer.parseInt(lukija.nextLine());// kysy minuuttien alkuarvo käyttäjältä
        System.out.print("tunnit: ");
        int tun = Integer.parseInt(lukija.nextLine());// kysy tuntien alkuarvo käyttäjältä

        sekunnit.asetaArvo(sek);
        minuutit.asetaArvo(min);
        tunnit.asetaArvo(tun);

        int i = 0;
        while (i < 121) {
            System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);   // tulostetaan nykyinen aika
            sekunnit.seuraava();
            if (sekunnit.arvo() == 0) {
                // minuuttimäärä kasvaa
                minuutit.seuraava();

                // jos minuuttimäärä menee nollaan, tuntimäärä kasvaa
                if (minuutit.arvo() == 0) {
                    tunnit.seuraava();
                }
                i++;
            }
        }

    }
}
