
public class Asunto {

    private int huoneita;
    private int nelioita;
    private int neliohinta;

    public Asunto(int huoneita, int nelioita, int neliohinta) {
        this.huoneita = huoneita;
        this.nelioita = nelioita;
        this.neliohinta = neliohinta;
    }

    public boolean suurempi(Asunto verrattava) {
        return this.nelioita > verrattava.nelioita ? true : false;
    }

    public int hintaero(Asunto verrattava) {
        int eka = this.neliohinta * this.nelioita;
        int toka = verrattava.neliohinta * verrattava.nelioita;
        if (eka > toka) {
            return eka - toka;
        } else {
            return toka - eka;

        }
    }
    
    public boolean kalliimpi(Asunto verrattava) {
        int ekahinta = this.neliohinta * this.nelioita;
        int tokahinta = verrattava.neliohinta * verrattava.nelioita;
        return ekahinta > tokahinta;
    }

}
