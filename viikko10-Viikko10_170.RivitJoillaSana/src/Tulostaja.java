
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Tulostaja {

    private String tiedostonNimi;

    public Tulostaja(String tiedostonNimi) throws Exception {
        // ...
        this.tiedostonNimi = tiedostonNimi;
    }

    public void tulostaRivitJoilla(String sana) {
        ArrayList<String> rivit = new ArrayList<>();
        File tiedosto = new File(this.tiedostonNimi);
        try (Scanner lukija = new Scanner(tiedosto, "UTF-8")) {
            while (lukija.hasNextLine()) {
                rivit.add(lukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        if (sana.equals("")) {
            for (String rivi : rivit) {
                System.out.println(rivi);
            }
        } else {
            for (String rivi : rivit) {
                if (rivi.contains(sana)) {
                    System.out.println(rivi);
                }
            }
        }

    }

}
