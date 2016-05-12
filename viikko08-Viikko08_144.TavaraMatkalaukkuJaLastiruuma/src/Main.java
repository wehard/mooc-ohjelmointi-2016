public class Main {
    public static void main(String[] args) {
        Lastiruuma lastiruuma = new Lastiruuma(1000);
        lisaaMatkalaukutTiiliskivilla(lastiruuma);
        System.out.println(lastiruuma);
    }

    public static void lisaaMatkalaukutTiiliskivilla(Lastiruuma lastiruuma) {
        // 100 matkalaukun lisääminen, jokaiseen tulee tiiliskivi
        for (int i = 0; i < 100; i++) {
            Matkalaukku uusiLaukku = new Matkalaukku(1000);
            Tavara uusiKivi = new Tavara("Tiiliskivi", i+1);
            uusiLaukku.lisaaTavara(uusiKivi);
            lastiruuma.lisaaMatkalaukku(uusiLaukku);
            
            
        }
    }
}