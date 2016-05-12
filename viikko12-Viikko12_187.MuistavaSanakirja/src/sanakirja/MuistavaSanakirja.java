/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author willehard
 */
public class MuistavaSanakirja {

    private Map<String, String> sanat = new HashMap<>();
    private String tiedosto;

    public MuistavaSanakirja() {

    }

    public MuistavaSanakirja(String tiedosto) {
        this.tiedosto = tiedosto;
    }

    public boolean lataa() {
        File file = new File(this.tiedosto);
        try {
            Scanner lukija = new Scanner(file);
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] osat = rivi.split(":");   // pilkotaan rivi :-merkkien kohdalta
                this.sanat.put(osat[0], osat[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean tallenna() {

        try {
            FileWriter fw = new FileWriter(this.tiedosto);
            
            for(Entry e : this.sanat.entrySet()) {
                fw.write(e.getKey() + ":" + e.getValue() + "\n");
            }
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

    }

    public void lisaa(String sana, String kaannos) {
        if (this.sanat.containsKey(sana)) {
            return;
        }
        this.sanat.put(sana, kaannos);
    }

    public String kaanna(String sana) {
        if (this.sanat.containsKey(sana)) {
            return this.sanat.get(sana);
        }

        for (Entry e : this.sanat.entrySet()) {
            if (e.getValue().equals(sana)) {
                return e.getKey().toString();
            }
        }

        return null;
    }

    public void poista(String sana) {
        Entry tmp = null;
        for (Entry e : this.sanat.entrySet()) {
            if (e.getKey().equals(sana) || e.getValue().equals(sana)) {
                tmp = e;
            }
        }
        if (tmp != null) {
            this.sanat.remove(tmp.getKey().toString());
        }

    }

}
