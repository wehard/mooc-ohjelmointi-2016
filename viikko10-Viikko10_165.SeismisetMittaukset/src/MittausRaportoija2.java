
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MittausRaportoija2 implements SeismisenToiminnanMittaaja {

    private ArrayList<PaivamaaraMittauksella> data;

    MittausRaportoija2() {
    }

    public List<SuurinTaajuusRaportti> paivittaisetMaksimit(List<Double> mittausData,
            int kuukausi) {
        this.data = new ArrayList<>();

        PaivamaaraMittauksella p = null;
        for (int i = 0; i < mittausData.size(); i++) {

            if (this.onPaivamaara(mittausData.get(i))) {
                p = new PaivamaaraMittauksella(mittausData.get(i));
                data.add(p);
                continue;
            }
            if (p != null) {
                p.lisaaMittaus(mittausData.get(i));
            }
        }
        List<SuurinTaajuusRaportti> raportti = new ArrayList<>();
        for (PaivamaaraMittauksella pmm : data) {
            SuurinTaajuusRaportti s = new SuurinTaajuusRaportti(pmm.paiva, pmm.getSuurinMittaus());
            raportti.add(s);
        }
        return raportti;
    }

    private boolean onPaivamaara(Double d) {
        return d.toString().length() >= 8;
    }

    private class PaivamaaraMittauksella {

        public int vuosi, kuukausi, paiva;
        public ArrayList<Double> mittaukset = new ArrayList<>();

        public PaivamaaraMittauksella(Double paivamaara) {
            // Parse here
            int i = (int) Math.round(paivamaara);
            String s = "" + i;
            if (s.length() < 8) {
                return;
            }
            this.vuosi = Integer.parseInt(s.substring(0, 4));
            this.kuukausi = Integer.parseInt(s.substring(4, 6));
            this.paiva = Integer.parseInt(s.substring(6, 8));
        }

        public void lisaaMittaus(Double d) {
            this.mittaukset.add(d);
        }

        public Double getSuurinMittaus() {
            Double tmp = Double.MIN_VALUE;
            for (Double d : this.mittaukset) {
                if (d > tmp) {
                    tmp = d;
                }
            }
            return tmp;
        }
    }
}
