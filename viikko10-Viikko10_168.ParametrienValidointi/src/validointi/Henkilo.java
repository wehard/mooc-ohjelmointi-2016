package validointi;

public class Henkilo {

    private String nimi;
    private int ika;

    public Henkilo(String nimi, int ika) {

        if (nimi == null || nimi.equals("") || nimi.length() > 40) {
            throw new IllegalArgumentException("Nimi oli null tai tyhjä tai liian pitkä");
        }
        if(ika < 0 || ika > 120) {
            throw new IllegalArgumentException("Iän pitää olla 0-120");
        }

        this.nimi = nimi;
        this.ika = ika;
    }

    public String getNimi() {
        return nimi;
    }

    public int getIka() {
        return ika;
    }
}
