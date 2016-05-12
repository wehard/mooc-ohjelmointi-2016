
import java.util.ArrayList;
import java.util.List;

public class RaportinLuoja1 implements Raportoiva {

    public RaportinLuoja1() {
    }

    @Override
    public PainoindeksiRaportti painoindeksiRaportti(List<Henkilo> henkilotiedot) {

        ArrayList<String> alipainoiset = new ArrayList<>();
        ArrayList<String> normaalipainoiset = new ArrayList<>();
        ArrayList<String> ylipainoiset = new ArrayList<>();
        ArrayList<String> merkittavastiYlipainoiset = new ArrayList<>();

        for (Henkilo h : henkilotiedot) {
            double painoIndeksi = h.getPaino() / (h.getPituus() * h.getPituus());
            
            if (painoIndeksi < 18.5) {
                alipainoiset.add(h.getNimi());
                continue;
            }
            if (painoIndeksi >= 18.5 && painoIndeksi < 25) {
                normaalipainoiset.add(h.getNimi());
                continue;
            }
            if (painoIndeksi >= 25 && painoIndeksi < 30) {
                ylipainoiset.add(h.getNimi());
                continue;
            }
            if (painoIndeksi >= 30) {
                merkittavastiYlipainoiset.add(h.getNimi());
            }
        }

        PainoindeksiRaportti raportti = new PainoindeksiRaportti(alipainoiset, normaalipainoiset, ylipainoiset, merkittavastiYlipainoiset);
        return raportti;
    }
}
