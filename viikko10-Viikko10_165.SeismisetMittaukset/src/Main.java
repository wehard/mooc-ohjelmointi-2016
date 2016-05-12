
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        List<Double> lista = new ArrayList<>();
        lista.add(20151004d);
        lista.add(200d);
        lista.add(new Double(150));
        lista.add(new Double(175));
        lista.add(new Double(20151005));
        lista.add(0.002);
        lista.add(0.03);
        lista.add(new Double(20151007));
        lista.add(1.4);
        lista.add(3.5);
        
        lista.add(new Double(20151010));
        lista.add(86.4);
        lista.add(3.5);
        
        
        
        MittausRaportoija2 mr = new MittausRaportoija2();
        for(SuurinTaajuusRaportti r : mr.paivittaisetMaksimit(lista, 10)) {
            //System.out.println(r.getPaiva());
            System.out.println(r.getSuurinArvo());
        }
        
        
        
    }

}
