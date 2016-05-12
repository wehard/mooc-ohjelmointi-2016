package hirsipuu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Hirsipuu {

    private Sanalista sanalista;
    private List<Character> tehdytArvaukset;
    private int arvauksiaJaljella;
    private String arvattava;

    public Hirsipuu(Sanalista sanalista, int arvauksiaAlussa) {
        this.sanalista = sanalista;
        this.arvauksiaJaljella = arvauksiaAlussa;
        this.tehdytArvaukset = new ArrayList<>();

        Collections.shuffle(this.sanalista.sanat());
        this.arvattava = this.sanalista.sanat().get(0);
    }

    public List<Character> arvaukset() {
        return this.tehdytArvaukset;
    }

    public int arvauksiaJaljella() {
        return this.arvauksiaJaljella;
    }

    public boolean arvaa(Character kirjain) {
        this.tehdytArvaukset.add(kirjain);
        if (this.oikeaSana().contains(kirjain.toString())) {
            
            this.sanalista = this.sanalista.sanatJoidenPituusOn(this.oikeaSana().length());
            this.sanalista = this.sanalista.sanatJoissaMerkit(this.sana());
            this.arvattava = this.sanalista.sanat().get(new Random().nextInt(this.sanalista.sanat().size()));
            
            return true;
        } else {
            this.arvauksiaJaljella--;
            return false;
        }
    }

    public String sana() {
        StringBuilder sb = new StringBuilder(this.oikeaSana());
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, '-');
        }

        //System.out.println("oikea sana: " + this.oikeaSana());
        for (int i = 0; i < this.oikeaSana().length(); i++) {

            for (Character c : this.arvaukset()) {
                if (this.oikeaSana().charAt(i) == c) {
                    sb.setCharAt(i, this.oikeaSana().charAt(i));
                    break;
                } else {
                    sb.setCharAt(i, '-');

                }
            }

        }
        return sb.toString();
    }

    public String oikeaSana() {
        return this.arvattava;
    }

    public boolean onLoppu() {
        int oikein = 0;
        for (int i = 0; i < this.arvattava.length(); i++) {
            for (Character c : this.arvaukset()) {
                if (this.arvattava.charAt(i) == c) {
                    oikein++;
                }
            }
        }
        return oikein == this.arvattava.length();
    }

}
