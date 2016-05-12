
import java.util.List;

public class MittaustenTasoittaja2 implements Tasoittava {

    MittaustenTasoittaja2() {
    }

    @Override
    public List<Double> tasoita(List<Henkilo> henkilotiedot) {

        return new MittaustenTasoittaja1().tasoita(henkilotiedot);
    }
}
