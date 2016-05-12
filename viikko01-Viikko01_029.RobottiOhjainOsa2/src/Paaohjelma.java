
import java.util.Scanner;
import robotti.Ohjain;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Ohjain.asetaLaatikkoSatunnaisesti();
        Ohjain.kaynnista();

        // toteuta ohjelma tänne
        
        String komento = "";
        boolean robottiKay = true;
        
        while(robottiKay == true) {
            System.out.print("komento (sammuta, vasen, oikea, liiku, liikuMonta, viereen, ratkaise): ");
            komento = lukija.nextLine();
            switch(komento) {
                case "sammuta" : 
                    Ohjain.sammuta(); 
                    robottiKay = false; 
                    break;
                case "vasen" : 
                    Ohjain.vasen(); break;
                case "oikea" : 
                    Ohjain.oikea(); break;
                case "liiku" : 
                    Ohjain.liiku(); break;
                case "liikuMonta" :
                    System.out.print("Kuinka monta askelta: ");
                    int askelta = Integer.parseInt(lukija.nextLine());
                    Ohjain.liikuMonta(askelta);
                    break;
                case "viereen" :
                    // kertoo robotin x- ja y-koordinaatit
                    int robottiX = Ohjain.robottiX();
                    int robottiY = Ohjain.robottiY();

                    // kertoo laatikon x- ja y-koordinaatit
                    int laatikkoX = Ohjain.laatikkoX();
                    int laatikkoY = Ohjain.laatikkoY();

                    // kertoo rahtialueen x- ja y-koordinaatit
                    int tavoiteX = Ohjain.tavoiteX();
                    int tavoiteY = Ohjain.tavoiteY();
                    
                    Ohjain.vasen();
                    Ohjain.liikuMonta(laatikkoY-robottiY);
                    Ohjain.oikea();
                    Ohjain.liikuMonta(laatikkoX-robottiX-1);
                    
                    break;
                case "ratkaise" : 
                    // kertoo robotin x- ja y-koordinaatit
                    robottiX = Ohjain.robottiX();
                    robottiY = Ohjain.robottiY();

                    // kertoo laatikon x- ja y-koordinaatit
                    laatikkoX = Ohjain.laatikkoX();
                    laatikkoY = Ohjain.laatikkoY();

                    // kertoo rahtialueen x- ja y-koordinaatit
                    tavoiteX = Ohjain.tavoiteX();
                    tavoiteY = Ohjain.tavoiteY();
                    
                    Ohjain.vasen();
                    Ohjain.liikuMonta(laatikkoY-robottiY);
                    Ohjain.oikea();
                    Ohjain.liikuMonta(laatikkoX-robottiX-1);
                    
                    Ohjain.liikuMonta(tavoiteX - laatikkoX);
                    
                    Ohjain.vasen();
                    Ohjain.liiku();
                    Ohjain.oikea();
                    Ohjain.liiku();
                    Ohjain.oikea();
                    
                    Ohjain.liikuMonta(laatikkoY - tavoiteY);
                    
                    
            }
            
        }

        
    }
}
