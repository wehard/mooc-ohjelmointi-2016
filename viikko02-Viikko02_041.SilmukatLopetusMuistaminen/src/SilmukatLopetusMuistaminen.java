
import java.util.Scanner;

public class SilmukatLopetusMuistaminen {

    public static void main(String[] args) {
        // tee tähän projektiin tehtävät 41.1-41.5
        // kyseessä on oikeastaan yksi iso tehtävä jota koko ajan laajennetaan

        // voit myös lähettää osittain tehdyn tehtäväsarjan tarkastettavaksi palvelimelle
        // palvelin valittaa tällöin niistä testeistä joita vastaava koodi ei ole vielä
        // kirjoitettu. jo tehdyt osat kuitenkin kirjautuvat tehdyiksi
        Scanner lukija = new Scanner(System.in);

        System.out.print("Syötä luvut: ");
        
        int luku = Integer.parseInt(lukija.nextLine());
        int summa = 0;
        int lukuja = 0;
        int parillisia = 0;
        int parittomia = 0;
        double keskiarvo;
        
        while(luku != -1) {
            if(luku % 2 == 0) {
                parillisia++;
            } else {
                parittomia++;
            }
            
                
            lukuja++;
            summa += luku;
            luku = Integer.parseInt(lukija.nextLine());
        }
        System.out.println("Kiitos ja näkemiin!");
        
        if(summa > 0 ) {
            System.out.println("Summa: " + summa);
            System.out.println("Lukuja: " + lukuja);
            keskiarvo = summa / (double)lukuja; 
            System.out.println("Keskiarvo: " + keskiarvo);
            System.out.println("Parillisia: " + parillisia);
            System.out.println("Parittomia: " + parittomia);
        }
        
        
        
            
        
    }
}
