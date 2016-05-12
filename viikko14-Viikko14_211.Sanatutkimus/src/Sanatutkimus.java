
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Sanatutkimus {

    private List<String> sanat = new ArrayList<>();

    public Sanatutkimus(String tiedostonimi) {
        
        try (Scanner lukija = new Scanner(new File(tiedostonimi))) {
            while (lukija.hasNextLine()) {
                sanat.add(lukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }

    public int sanojenMaara() {
        return this.sanat.size();
    }

    public boolean onkoSanaa(String sana) {
        return this.sanat.contains(sana);
    }
    
    public int laskeSanat(int pituus) {
        int montako = 0;
        for(String s : this.sanat) {
            if(s.length() == pituus) {
                montako++;
            }
        }
        return montako;
    }
    
    public void pituustilasto() {
        
        for (int i = 1; i < 31; i++) {
            System.out.print(i);
            System.out.println(" " + this.laskeSanat(i));
        }
    }
    
    public int laskeKirjaimet(char kirjain) {
        int montako = 0;
        for(String s : this.sanat) {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == kirjain) {
                    montako++;
                }
            }
        }
        return montako;
    }
    
    public void kirjaintilasto() {
        String kirjaimet = "abcdefghijklmnopqrstuvxyzåäö";
        for (int i = 0; i < kirjaimet.length(); i++) {
            System.out.println(kirjaimet.charAt(i) + " " + this.laskeKirjaimet(kirjaimet.charAt(i)));
        }
    }
    
    public ArrayList<String> haePituudella(int pituus) {
        ArrayList<String> lista = new ArrayList<>();
        for(String s : this.sanat) {
            if(s.length() == pituus) {
                lista.add(s);
            }
        }
        return lista;
    }
    
    public ArrayList<String> haeOsalla(String osa) {
        ArrayList<String> lista = new ArrayList<>();
        for(String s : this.sanat) {
            if(s.contains(osa)) {
                lista.add(s);
            }
        }
        return lista;
    }
    
    public ArrayList<String> haePalindromit() {
        ArrayList<String> lista = new ArrayList<>();
        for(String s : this.sanat) {
            boolean on = true;
            for (int i = 0; i < s.length(); i++) { 
                if(s.charAt(i) != s.charAt(s.length()-1-i)) {
                    on = false;
                }
            }
            if(on) {
                lista.add(s);
            }
            
        }
        return lista;
    }
    
    public ArrayList<String> haeRistikkoon(String pohja) {
        ArrayList<String> lista = new ArrayList<>();
        for(String s : this.sanat) {
            if(s.length() != pohja.length()) {
                continue;
            }
            boolean sopii = true;
            for (int i = 0; i < s.length(); i++) {
                if(pohja.charAt(i) != '?' && s.charAt(i) != pohja.charAt(i)) {
                    sopii = false;
                    break;
                }
            }
            if(sopii) {
                lista.add(s);
            }
            
        }
        return lista;
    }
    
}
