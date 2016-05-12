/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedosto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willehard
 */
public class Analyysi {
    
    private File tiedosto;
    
    public Analyysi(File tiedosto){
        this.tiedosto = tiedosto;
    }
    
    public int rivimaara() {
        
        int rivimaara = 0;
        
        try (Scanner lukija = new Scanner(tiedosto)) {
            while(lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                rivimaara++;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Analyysi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rivimaara;
    }
    
    public int merkkeja() {
        int merkkeja = 0;
        
        try (Scanner lukija = new Scanner(tiedosto)) {
            while(lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                merkkeja++; // Koska rivinvaihto on merkki
                merkkeja+=rivi.length();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Analyysi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return merkkeja;
    }
    
}
