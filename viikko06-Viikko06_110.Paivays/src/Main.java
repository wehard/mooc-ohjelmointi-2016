
public class Main {

    public static void main(String[] args) {
        Paivays pvm = new Paivays(13, 2, 2015);
        System.out.println("Tarkistellun viikon perjantai on " + pvm);

        Paivays uusiPvm = pvm.paivienPaasta(7);
        for (int i = 1; i <= 7; ++i) {
            System.out.println("Perjantai " + i + " viikon kuluttua on " + uusiPvm);
            uusiPvm = uusiPvm.paivienPaasta(7);
        }

        System.out.println("Päivämäärä 790:n päivän päästä tarkistellusta perjantaista on ... kokeile itse!");
        System.out.println("Kokeile " + pvm.paivienPaasta(790));
    }
}
