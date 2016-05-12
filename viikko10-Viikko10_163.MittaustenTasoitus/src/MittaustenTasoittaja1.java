
import java.util.ArrayList;
import java.util.List;

public class MittaustenTasoittaja1 implements Tasoittava {

    MittaustenTasoittaja1() {
    }

    @Override
    public List<Double> tasoita(List<Henkilo> henkilotiedot) {
        List<Double> lista = new ArrayList<>();

        for (int i = 0; i < henkilotiedot.size(); i++) {
            if (i > 0 && i < henkilotiedot.size() - 1) {
                double keskiarvo = (henkilotiedot.get(i-1).getSyke()
                        + henkilotiedot.get(i).getSyke()
                        + henkilotiedot.get(i+1).getSyke()) / 3.0;
                lista.add(keskiarvo);
            } else {
                lista.add((double)henkilotiedot.get(i).getSyke());
            }
            
        }
        return lista;
    }
}
