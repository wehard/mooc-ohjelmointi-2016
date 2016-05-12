/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Sanatulostin {

    public String sana;

    public Sanatulostin(String sana) {
        this.sana = sana;
    }

    public void sanaporras(int luku) {

        int index = 0;

        for (int y = 1; y <= luku; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(sana.charAt(index));
                index++;
                if (index > sana.length()-1) {
                    index = 0;
                }
            }
            System.out.println("");
        }
    }
    
    
    public void laskevaSanaporras(int luku) {
        int index = 0;

        for (int y = 1; y <= luku; y++) {
            for (int x = luku; x >= y; x--) {
                System.out.print(sana.charAt(index));
                index++;
                if (index > sana.length()-1) {
                    index = 0;
                }
            }
            System.out.println("");
        }
    }
    
    
    public void sanapyramidi(int luku) {
        int index = 0;
        for (int y = 1; y <= luku; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(sana.charAt(index));
                index++;
                if (index > sana.length()-1) {
                    index = 0;
                }
            }
            System.out.println("");
        }
        for (int y = 1; y <= luku-1; y++) {
            for (int x = luku-1; x >= y; x--) {
                System.out.print(sana.charAt(index));
                index++;
                if (index > sana.length()-1) {
                    index = 0;
                }
            }
            System.out.println("");
        }
    }

}
