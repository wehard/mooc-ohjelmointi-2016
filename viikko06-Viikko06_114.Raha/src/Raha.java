
public class Raha {

    private final int euroa;
    private final int senttia;

    public Raha(int euroa, int senttia) {

        if (senttia > 99) {
            euroa += senttia / 100;
            senttia %= 100;
        }

        this.euroa = euroa;
        this.senttia = senttia;
    }

    public Raha plus(Raha lisattava) {
        Raha uusi = new Raha(this.eurot() + lisattava.eurot(), this.sentit() + lisattava.sentit()); // luodaan uusi Raha-olio jolla on oikea arvo

        // palautetaan uusi Raha-olio
        return uusi;
    }

    public boolean vahemman(Raha verrattava) {
        if (this.eurot() < verrattava.eurot() || this.eurot() == verrattava.eurot() && this.sentit() < verrattava.sentit()) {
            return true;
        }
        return false;
    }

    /// FIXME!
    public Raha miinus(Raha vahentaja) {

        if (!this.vahemman(vahentaja)) {
            int sentit = this.senttia - vahentaja.senttia;
            int eurot = this.euroa - vahentaja.euroa;
            if (sentit < 0) {
                eurot--;
                sentit += 100;
                
            }

            return new Raha(eurot, sentit);
        } else {
            return new Raha(0, 0);
        }
    }

    public int eurot() {
        return euroa;
    }

    public int sentit() {
        return senttia;
    }

    public String toString() {
        String nolla = "";
        if (senttia < 10) {
            nolla = "0";
        }

        return euroa + "." + nolla + senttia + "e";
    }

}
