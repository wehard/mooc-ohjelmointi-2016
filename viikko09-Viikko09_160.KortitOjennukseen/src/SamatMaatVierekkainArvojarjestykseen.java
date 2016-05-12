
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class SamatMaatVierekkainArvojarjestykseen implements Comparator<Kortti> {

    @Override
    public int compare(Kortti o1, Kortti o2) {
        if (o1.getMaa() == o2.getMaa()) {
            return o1.getArvo() - o2.getArvo();
        } else {
            return o1.getMaa() - o2.getMaa();
        }
    }

}
