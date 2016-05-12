
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        ArrayList<Henkilo> h = new ArrayList<>();
        
        h.add(new Henkilo("Eka", 1.75, 67, 95));
        h.add(new Henkilo("Eka", 1.75, 67, 102));
        h.add(new Henkilo("Eka", 1.75, 67, 98));
        h.add(new Henkilo("Eka", 1.75, 67, 88));
        h.add(new Henkilo("Eka", 1.75, 67, 105));
        
        MittaustenTasoittaja2 m = new MittaustenTasoittaja2();
        
        System.out.println(m.tasoita(h));
        
    }

}
