
import java.util.ArrayList;
import java.util.Scanner;
import tktl.Soitin;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Soitin soitin = new Soitin();

//        Aani aani = new Aani(261.6, 2);
//        System.out.println("Äänen taajuus on " + aani.getTaajuus() + " hertsiä.");
//      System.out.println("Äänen kesto on " + aani.getKesto() + " sekuntia.");
//      System.out.println(aani);
        ArrayList<Aani> aanet = new ArrayList<>();

        // luetaan käyttäjältä äänet ja tehdään niistä ääni-olioita, joita
        // lisätään aanet-listalle
        System.out.println("Kirjoita soitettavat äänet");

        String merkkijono = lukija.nextLine();
        if(merkkijono.equals("TKO-ALY")) {
            merkkijono = "CDEFGAHCHAGFEDC";
        }
        
        for (int i = 0; i < merkkijono.length(); i++) {

            //Aani temp = new Aani(0.0, 0.0);

            switch (merkkijono.substring(i, i + 1)) {
                case "C":
                    aanet.add(new Aani(261.626, 0.5));
                    break;
                case "D":
                    aanet.add(new Aani(293.665, 0.5));
                    break;
                case "E":
                    aanet.add(new Aani(329.628, 0.5));
                    break;
                case "F":
                    aanet.add(new Aani(349.228, 0.5));
                    break;
                case "G":
                    aanet.add(new Aani(391.995, 0.5));
                    break;
                case "A":
                    aanet.add(new Aani(440.000, 0.5));
                    break;
                case "H":
                    aanet.add(new Aani(493.883, 0.5));
                    break;
                case " ":
                    aanet.add(new Aani(0.0, 0.1f));
                    break;
            }
            

        }

        soitin.soita(aanet);

    }
}
