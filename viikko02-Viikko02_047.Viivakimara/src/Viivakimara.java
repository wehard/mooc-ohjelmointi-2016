
import robotti.Ohjain;

public class Viivakimara {

    public static void main(String[] args) {
        Ohjain.kaynnista();

        // testaa metodejasi täällä

        viivakimara(12);
        
        Ohjain.sammuta();
    }

    // toteuta metodisi tänne
    
    public static void liikuMonta(int montakoAskelta) {
        
        for (int i = 0; i < montakoAskelta; i++) {
            Ohjain.liiku();
        }
        
    }
    
    
    public static void piirraNelio(int sivunPituus) {
        
        for (int i = 0; i < 4; i++) {
            liikuMonta(sivunPituus);
            Ohjain.oikea();
        }
    }
    
    public static void sisakkaisetNeliot(int montako) {
        
        //for (int i = 0; i < montako; i++) {
        //    piirraNelio(montako - i);
        //}
        rajatutSisakkaisetNeliot(montako, 1);
        
    }
    
    public static void rajatutSisakkaisetNeliot(int suurin, int pienin) {
        
        for (int i = suurin; i >= pienin; i--) {
            piirraNelio(i);
        }
        
    }
    
    
    public static void viivakimara(int koko) {
        rajatutSisakkaisetNeliot(koko, koko/2);
        for (int i = 0; i < koko; i++) {
            Ohjain.liiku();
        }
        Ohjain.oikea();
        for (int i = 0; i < koko; i++) {
            Ohjain.liiku();
        }
        Ohjain.oikea();
        rajatutSisakkaisetNeliot(koko, koko/2);
        
    }
    
}
