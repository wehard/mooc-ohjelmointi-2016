public class Kello {
    private YlhaaltaRajoitettuLaskuri tunnit;
    private YlhaaltaRajoitettuLaskuri minuutit;
    private YlhaaltaRajoitettuLaskuri sekunnit;
   
    public Kello(int tunnitAlussa, int minuutitAlussa, int sekunnitAlussa) {
        // luodaan kello joka asetetaan parametrina annettuun aikaan
        this.tunnit = new YlhaaltaRajoitettuLaskuri(23);
        this.tunnit.asetaArvo(tunnitAlussa);
        this.minuutit = new YlhaaltaRajoitettuLaskuri(59);
        this.minuutit.asetaArvo(minuutitAlussa);
        this.sekunnit = new YlhaaltaRajoitettuLaskuri(59);
        this.sekunnit.asetaArvo(sekunnitAlussa);
    }
    
    public void etene() {
        // kello etenee sekunnilla
        sekunnit.seuraava();
        if(sekunnit.arvo() == 0) {
            minuutit.seuraava();
            if(minuutit.arvo() == 0) {
                tunnit.seuraava();
            }
                
        }
    }
    
    public String toString() {
        // palauttaa kellon merkkijonoesityksen
        String aika = "";
        if(tunnit.arvo() < 10) {
            aika += "0" + tunnit.arvo();
        } else {
            aika += tunnit.arvo();
        }
        aika += ":";
        if(minuutit.arvo() < 10) {
            aika += "0" + minuutit.arvo();
        } else {
            aika += minuutit.arvo();
        }
        aika += ":";    
        if(sekunnit.arvo() < 10) {
            aika += "0" + sekunnit.arvo();
        } else {
            aika += sekunnit.arvo();
        }
        return aika;
    }
}
