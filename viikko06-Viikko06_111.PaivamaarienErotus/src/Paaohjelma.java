public class Paaohjelma {
    public static void main(String[] args) {
        Paivays eka = new Paivays(24, 12, 2009);
        Paivays toka = new Paivays(1, 1, 2011);
        Paivays kolmas = new Paivays(25, 12, 2010);

        System.out.println(eka + " ja " + toka + " ero vuosissa: " + toka.erotusVuosissa(eka));
        System.out.println(toka + " ja " + eka + " ero vuosissa: " + eka.erotusVuosissa(toka));
        System.out.println(eka + " ja " + kolmas + " ero vuosissa: " + kolmas.erotusVuosissa(eka));
        System.out.println(kolmas + " ja " + eka + " ero vuosissa: " + eka.erotusVuosissa(kolmas));
        System.out.println(kolmas + " ja " + toka + " ero vuosissa: " + toka.erotusVuosissa(kolmas));
        System.out.println(toka + " ja " + kolmas + " ero vuosissa: " + kolmas.erotusVuosissa(toka));
    }
}