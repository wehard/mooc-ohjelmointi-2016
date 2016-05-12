
import java.util.ArrayList;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        Random rnd = new Random();
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        
        henkilot.add(new Henkilo("Alipaino", 1.75, 33, 120));
        henkilot.add(new Henkilo("Normaali", 1.75, 75, 120));
        henkilot.add(new Henkilo("Normaali", 1.65, 60, 120));
        henkilot.add(new Henkilo("Ylipaino", 1.75, 90, 120));
        henkilot.add(new Henkilo("Läski", 1.75, 150, 120));
        
        RaportinLuoja2 r2 = new RaportinLuoja2();
        PainoindeksiRaportti r = r2.painoindeksiRaportti(henkilot);
        
        
        System.out.println(r.getAlipainoiset());
        System.out.println(r.getNormaalipainoiset());
        System.out.println(r.getYlipainoiset());
        System.out.println(r.getMerkittavastiYlipainoiset());
    }

}
