
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
public class Lukija {
    
    private Scanner lukija = new Scanner(System.in);
    
    
    
    
    public String lueMerkkijono() {
        return lukija.nextLine();
    }
    
    public int lueKokonaisluku() {
        return Integer.parseInt(lukija.nextLine());
    }
}
