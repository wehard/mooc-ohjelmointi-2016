
import java.util.ArrayList;
import java.util.List;

class MittausRaportoija1 implements SeismisenToiminnanMittaaja {

    MittausRaportoija1() {
    }

    public List<SuurinTaajuusRaportti> paivittaisetMaksimit(List<Double> mittausData,
            int kuukausi) {

        ArrayList<Integer> paivamaaraIndeksit = new ArrayList<>();
        ArrayList<SuurinTaajuusRaportti> raportti = new ArrayList<>();

        for (int i = 0; i < mittausData.size() - 1; i++) {
            if ((int) mittausData.get(i).toString().length() >= 8) { // On päivämäärä!
                paivamaaraIndeksit.add(i);
            }
        }
        paivamaaraIndeksit.add(mittausData.size());
        int currentStartIndex = 0;

        for (int i = 0; i < paivamaaraIndeksit.size() - 1; i++) {
            Double paivansuurin = Double.MIN_VALUE;
            for (int j = paivamaaraIndeksit.get(i) + 1; j < paivamaaraIndeksit.get(i + 1); j++) {
                if (mittausData.get(j) > paivansuurin) {
                    paivansuurin = mittausData.get(j);
                }
            }
            if (kuukausiMittausDatasta((int) Math.round(mittausData.get(paivamaaraIndeksit.get(i)))) == kuukausi) {
                raportti.add(new SuurinTaajuusRaportti(paivaMittausDatasta((int) Math.round(mittausData.get(paivamaaraIndeksit.get(i)))), paivansuurin));
            }

            currentStartIndex++;
        }

        return raportti;
    }

    private int kuukausiMittausDatasta(int paivamaara) {
        String s = Integer.toString(paivamaara);
        return Integer.parseInt(s.substring(4, 6));
    }

    private int paivaMittausDatasta(int paivamaara) {
        String s = Integer.toString(paivamaara);
        return Integer.parseInt(s.substring(6, 8));
    }

}
