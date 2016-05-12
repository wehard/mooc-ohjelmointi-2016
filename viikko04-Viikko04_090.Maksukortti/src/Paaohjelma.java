
public class Paaohjelma {

    public static void main(String[] args) {
        // Scanner lukija = new Scanner(System.in);
        
        Maksukortti pekanKortti = new Maksukortti(20);
        Maksukortti matinKortti = new Maksukortti(30);

        // kirjoita koodia tähän
        
        pekanKortti.syoMaukkaasti();
        matinKortti.syoEdullisesti();
        System.out.println("Pekka: " + pekanKortti);
        System.out.println("Matti: " + matinKortti);
        pekanKortti.lataaRahaa(20.0);
        matinKortti.syoMaukkaasti();
        System.out.println("Pekka: " + pekanKortti);
        System.out.println("Matti: " + matinKortti);
        pekanKortti.syoEdullisesti();
        pekanKortti.syoEdullisesti();
        matinKortti.lataaRahaa(50.0);
        System.out.println("Pekka: " + pekanKortti);
        System.out.println("Matti: " + matinKortti);
        
    }
}
