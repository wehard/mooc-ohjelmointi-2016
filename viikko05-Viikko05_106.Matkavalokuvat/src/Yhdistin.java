
import java.util.ArrayList;
import java.util.Collections;
import kuva.Fotari;
import kuva.Kuva;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Yhdistin {

    private String yhdistamisTapa;

    public Yhdistin(String yhdistamisTapa) {
        this.yhdistamisTapa = yhdistamisTapa;
    }

    public ArrayList<Kuva> lataaKuvat(ArrayList<String> lista) {
        ArrayList<Kuva> kuvat = new ArrayList<>();

        for (String kuva : lista) {
            kuvat.add(Fotari.lataa(kuva));
        }
        return kuvat;
    }

    public Kuva yhdistaKuvat(ArrayList<Kuva> lista) {
        Kuva uusi = new Kuva(lista.get(0).getLeveys(), lista.get(0).getKorkeus());

        // if "vaalein"
        if (yhdistamisTapa.equals("vaalein")) {
            for (int x = 0; x < uusi.getLeveys(); x++) {
                for (int y = 0; y < uusi.getKorkeus(); y++) {

                    int suurinPun = Integer.MIN_VALUE;
                    int suurinVih = Integer.MIN_VALUE;
                    int suurinSin = Integer.MIN_VALUE;

                    for (Kuva kuva : lista) {
                        if (kuva.punainen(x, y) > suurinPun) {
                            suurinPun = kuva.punainen(x, y);
                        }
                        if (kuva.vihrea(x, y) > suurinVih) {
                            suurinVih = kuva.vihrea(x, y);
                        }
                        if (kuva.sininen(x, y) > suurinSin) {
                            suurinSin = kuva.sininen(x, y);
                        }
                    }

                    uusi.asetaVari(x, y, suurinPun, suurinVih, suurinSin);

                }

            }
        }

        if (yhdistamisTapa.equals("tummin")) {
            for (int x = 0; x < uusi.getLeveys(); x++) {
                for (int y = 0; y < uusi.getKorkeus(); y++) {

                    int suurinPun = Integer.MAX_VALUE;
                    int suurinVih = Integer.MAX_VALUE;
                    int suurinSin = Integer.MAX_VALUE;

                    for (Kuva kuva : lista) {
                        if (kuva.punainen(x, y) < suurinPun) {
                            suurinPun = kuva.punainen(x, y);
                        }
                        if (kuva.vihrea(x, y) < suurinVih) {
                            suurinVih = kuva.vihrea(x, y);
                        }
                        if (kuva.sininen(x, y) < suurinSin) {
                            suurinSin = kuva.sininen(x, y);
                        }
                    }

                    uusi.asetaVari(x, y, suurinPun, suurinVih, suurinSin);

                }

            }
        }

        // mediaani
        if (yhdistamisTapa.equals("mediaani")) {
            for (int x = 0; x < uusi.getLeveys(); x++) {
                for (int y = 0; y < uusi.getKorkeus(); y++) {

                    ArrayList<Integer> mediaaniPun = new ArrayList<>();
                    ArrayList<Integer> mediaaniVih = new ArrayList<>();
                    ArrayList<Integer> mediaaniSin = new ArrayList<>();

                    for (Kuva kuva : lista) {
                        mediaaniPun.add(kuva.punainen(x, y));
                        mediaaniVih.add(kuva.vihrea(x, y));
                        mediaaniSin.add(kuva.sininen(x, y));
                    }
                    Collections.sort(mediaaniPun);
                    Collections.sort(mediaaniVih);
                    Collections.sort(mediaaniSin);

                    uusi.asetaVari(x, y, mediaaniPun.get(mediaaniPun.size()/2),
                            mediaaniVih.get(mediaaniVih.size()/2),
                            mediaaniSin.get(mediaaniSin.size()/2));

                }

            }
        }

        return uusi;

    }
}
