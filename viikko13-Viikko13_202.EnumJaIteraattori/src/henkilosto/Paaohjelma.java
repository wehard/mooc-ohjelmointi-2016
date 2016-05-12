package henkilosto;

public class Paaohjelma {

    public static void main(String[] args) {
        // tee testikoodia tänne
        Tyontekijat t = new Tyontekijat(); 
        
        Henkilo h = new Henkilo("Arto", Koulutus.FT); 
        t.lisaa(h); 
        t.tulosta(Koulutus.FT); 
    }
}
