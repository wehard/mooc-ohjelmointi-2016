import java.util.Comparator;

public class JarjestaHyppaajatPisteidenMukaan implements Comparator<Hyppaaja> {
    
    @Override
    public int compare(Hyppaaja o1, Hyppaaja o2) {
        return (o1.getPisteet() - o2.getPisteet());
    }
}