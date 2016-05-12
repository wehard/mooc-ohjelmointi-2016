/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class StringUtils {
    
    public static boolean sisaltaa(String sana, String haettava) {
        String tsana = sana.trim();
        String thaettava = haettava.trim();
        if(tsana.toUpperCase().contains(thaettava.toUpperCase())) {
            return true;
        } 
        return false;
    }
    
}
