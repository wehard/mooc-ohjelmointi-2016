public class Paaohjelma {

    // tee ohjelmaasi VAIN YKSI Scanner-olio
    // jos joudut käyttämään Scanneria muualta kuin luontipaikasta, välitä se parametrina

    public static void main(String[] args) {
        
        LintuTietokanta ltk = new LintuTietokanta();
        Kayttoliittyma kl = new Kayttoliittyma(ltk);
        kl.kaynnista();
        
    }

}
