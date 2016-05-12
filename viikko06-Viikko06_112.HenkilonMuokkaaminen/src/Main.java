
public class Main {

    public static void main(String[] args) {
        Henkilo pekka = new Henkilo("Pekka", new Paivays(15, 2, 1983));
        Henkilo iina = new Henkilo("Iina");

        System.out.println(pekka);
        System.out.println(iina);
    }
}
