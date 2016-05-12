package arviot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TunteikkaatArviot {

    private Map<String, SanaTiedot> sanat = new HashMap<>();

    // Huom! Älä muuta konstruktorin parametrien määrää -- konstruktoria
    // saa toki muuten muuttaa
    public TunteikkaatArviot(List<String> rivit) {

        // Luo kaikille sanoille tiedot
        for (String s : rivit) {

            String[] rivinSanat = s.split(" ");
            for (int i = 0; i < rivinSanat.length; i++) {

                String currentSana = rivinSanat[i].toLowerCase();

                if (!this.sanat.containsKey(currentSana)) {
                    SanaTiedot st = new SanaTiedot();
                    st.esiintymisKerrat = 1;
                    st.arvioidenTunne.add(Integer.parseInt(rivinSanat[0]));
                    this.sanat.put(currentSana, st);
                } else {
                    SanaTiedot st = this.sanat.get(currentSana);
                    st.arvioidenTunne.add(Integer.parseInt(rivinSanat[0]));
                    st.esiintymisKerrat++;
                    this.sanat.put(currentSana, st);
                }
            }
        }

    }

    public int sanojenLukumaara(String sana) {

        SanaTiedot st = this.sanat.get(sana);
        if (st == null) {
            return 0;
        }
        return st.esiintymisKerrat;
    }

    public double sananTunne(String sana) {

        SanaTiedot st = this.sanat.get(sana);
        if (st == null) {
            return 2.0;
        }

        double keskiarvo = 0.0;

        for (Integer i : st.arvioidenTunne) {
            keskiarvo += i;
        }
        keskiarvo /= st.esiintymisKerrat; //st.arvioidenTunne.size();

        return keskiarvo;
    }

    public String sananTunneMerkkijonona(String sana) {

        if (this.sananTunne(sana) < 1.9) {
            return "negatiivinen";
        }
        if (this.sananTunne(sana) < 2.1) {
            return "neutraali";
        }
        return "positiivinen";
    }

    public double lauseenTunne(String lause) {
        double lauseenKeskiarvo = 0.0;
        int kerrat = 0;
        String[] lauseenSanat = lause.split(" ");
        for (String s : lauseenSanat) {
            lauseenKeskiarvo += this.sananTunne(s);
            if (this.sananTunne(s) > 0.0) {
                kerrat++;
            }

        }
        if(lauseenKeskiarvo == 0.0 || kerrat == 0) {
            return 0.0;
        }
        
        
        
        lauseenKeskiarvo /= kerrat;

        return lauseenKeskiarvo;
    }

    public String lauseenTunneMerkkijonona(String lause) {
        if (this.lauseenTunne(lause) < 1.9) {
            return "negatiivinen";
        }
        if (this.lauseenTunne(lause) < 2.1) {
            return "neutraali";
        }
        return "positiivinen";

    }

    private class SanaTiedot {

        public int esiintymisKerrat;
        public List<Integer> arvioidenTunne = new ArrayList<>();
    }
}
