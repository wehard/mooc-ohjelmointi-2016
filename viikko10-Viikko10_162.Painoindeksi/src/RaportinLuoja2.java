
import java.util.ArrayList;
import java.util.List;

public class RaportinLuoja2 implements Raportoiva {

    RaportinLuoja2() {
    }

    @Override
    public PainoindeksiRaportti painoindeksiRaportti(List<Henkilo> henkilotiedot) {
        ArrayList<String> alipainoiset = new ArrayList<>();
        ArrayList<String> normaalipainoiset = new ArrayList<>();
        ArrayList<String> ylipainoiset = new ArrayList<>();
        ArrayList<String> merkittavastiYlipainoiset = new ArrayList<>();

        PainoindeksiRaportti raportti = new PainoindeksiRaportti(alipainoiset, normaalipainoiset, ylipainoiset, merkittavastiYlipainoiset);

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
        raportti.setAlipainoiset(alipainoiset);
        raportti.setNormaalipainoiset(normaalipainoiset);
        raportti.setYlipainoiset(ylipainoiset);
        raportti.setMerkittavastiYlipainoiset(merkittavastiYlipainoiset);

        return raportti;
    }
}
