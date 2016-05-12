
public class Paivays {

    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    @Override
    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi
                && this.kuukausi < verrattava.kuukausi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi
                && this.kuukausi == verrattava.kuukausi
                && this.paiva < verrattava.paiva) {
            return true;
        }

        return false;
    }

    public int erotusVuosissa(Paivays verrattava) {

        if (this.aiemmin(verrattava)) {

            if ((verrattava.kuukausi < this.kuukausi) || (verrattava.kuukausi == this.kuukausi && verrattava.paiva < this.paiva)) {
                return verrattava.vuosi - this.vuosi - 1;
            } else {
                return verrattava.vuosi - this.vuosi;
            }

        } else {

            
            if ((this.kuukausi < verrattava.kuukausi) || (this.kuukausi == verrattava.kuukausi && this.paiva < verrattava.paiva)) {
                return this.vuosi - verrattava.vuosi - 1;
            } else {
                return this.vuosi - verrattava.vuosi;
            }
        }
    }

}
