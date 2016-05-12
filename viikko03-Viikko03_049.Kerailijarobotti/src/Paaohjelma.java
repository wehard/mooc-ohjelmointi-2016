
import robotti.Ohjain;

public class Paaohjelma {

    public static void main(String[] args) {

        Ohjain.kaynnista();

        // ohjelmoi liikkeet tänne
        // Huom! Älä luota testeihin -- kokeile, että ohjelma toimii
        // oikein ohjelmaa ajamalla.
        
        int y = 0;

        while (y < 14) {
            int x = 0;

            while (x < 13) {
                // tee jotain
                Ohjain.liiku();
                x++;
                
                if(y%2 == 0 && x % 2 != 0) {
                    Ohjain.nosta();
                }
                
                if(y%2 != 0 && x % 2 != 0) {
                    Ohjain.nosta();
                }
                    
                
                
            }
            if(y%2 == 0) {
                Ohjain.vasen();
                Ohjain.liiku();
                Ohjain.vasen();
            } else {
                Ohjain.oikea();
                Ohjain.liiku();
                Ohjain.oikea();
            }
            
            
            y++;
        }

        
        
        
        
        
        Ohjain.sammuta();
    }

}
