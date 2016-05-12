package hirsipuu;

import java.util.ArrayList;
import java.util.List;

public class Sanalista {

    private List<String> sanat;

    public Sanalista(List<String> sanat) {
        this.sanat = sanat;
    }

    public List<String> sanat() {
        return this.sanat;
    }

    public Sanalista sanatJoidenPituusOn(int pituus) {
        List<String> lista = new ArrayList<>();
        for (String s : this.sanat) {
            if (s.length() == pituus) {
                lista.add(s);
            }
        }
        return new Sanalista(lista);
    }

    public Sanalista sanatJoissaEiEsiinnyKirjainta(char kirjain) {
        List<String> lista = new ArrayList<>();
        for (String s : this.sanat) {
            if (!s.contains(Character.toString(kirjain))) {
                lista.add(s);
            }
        }
        return new Sanalista(lista);
    }
    // -a--a kakka

    public Sanalista sanatJoissaMerkit(String merkkijono) {
        List<String> lista = new ArrayList<>();

        for (String s : this.sanat) {
            if (s.length() == merkkijono.length()) {

                boolean tasmaa = true;
                for (int i = 0; i < merkkijono.length(); i++) {
                    char mkirjain = merkkijono.charAt(i);
                    char skirjain = s.charAt(i);
                    if (mkirjain == '-') {
                        continue;
                    } else if (mkirjain != skirjain) {
                        tasmaa = false;
                        break;
                    }
                }
                if (tasmaa) {
                    lista.add(s);
                }
            }

        }
        return new Sanalista(lista);
    }

    public int koko() {
        return this.sanat.size();
    }
}
