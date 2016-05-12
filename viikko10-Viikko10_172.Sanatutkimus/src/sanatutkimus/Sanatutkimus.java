/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanatutkimus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author willehard
 */
public class Sanatutkimus {
    
    private Scanner lukija;
    private ArrayList<String> rivit = new ArrayList<>();
    
    public Sanatutkimus(File tiedosto) throws FileNotFoundException {
        this.lukija = new Scanner(tiedosto, "UTF-8");
        while (lukija.hasNextLine()) {
            rivit.add(lukija.nextLine());
        }
    }
    
    public int sanojenMaara() {
        /*
        int sanamaara = 0;
        for (String s : rivit) {
            sanamaara++;
        }
         */
        return rivit.size();
    }
    
    public List<String> kirjaimenZSisaltavatSanat() {
        List<String> lista = new ArrayList<>();
        
        for (String s : rivit) {
            if (s.contains("z") || s.contains("Z")) {
                lista.add(s);
            }
        }
        return lista;
    }
    
    public List<String> kirjaimeenLPaattyvatSanat() {
        List<String> lista = new ArrayList<>();
        for (String s : rivit) {
            if (s.endsWith("l") || s.endsWith("L")) {
                lista.add(s);
            }
        }
        
        return lista;
    }
    
    public List<String> palindromit() {
        List<String> lista = new ArrayList<>();
        for (String s : rivit) {
            String t = s.substring(0, s.length() / 2);
            String rev = new StringBuilder(t).reverse().toString();
            if (s.endsWith(rev)) {
                lista.add(s);
            }
        }
        return lista;
    }
    
    public List<String> kaikkiVokaalitSisaltavatSanat() {
        List<String> lista = new ArrayList<>();
        String[] vokaalit = {"a", "e", "i", "o", "u", "y", "ä", "ö"};
        boolean onVokaali = false;
        for (String s : rivit) {
            for (int i = 0; i < vokaalit.length; i++) {
                onVokaali = s.contains(vokaalit[i]);
                if(!onVokaali) {
                    break;
                }
            }
            if(onVokaali) {
                lista.add(s);
            }
        }
        return lista;
    }
    
}
