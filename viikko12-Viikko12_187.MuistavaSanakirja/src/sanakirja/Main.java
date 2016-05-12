package sanakirja;

public class Main {

    public static void main(String[] args) {
        // Testaa sanakirjaa täällä
        MuistavaSanakirja sanakirja = new MuistavaSanakirja("src/sanat.txt");
        sanakirja.lataa();

        // käytä sanakirjaa
        
        sanakirja.lisaa("koira", "dog");
        sanakirja.lisaa("perse", "ass");
        sanakirja.lisaa("tomaatti", "tomato");
        sanakirja.lisaa("kakka", "poop");
        
        
        sanakirja.tallenna();
    }
}
