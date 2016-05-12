
import java.util.Objects;


public class Lintu {

    private String nimi;
    private String latinankielinenNimi;
    private int rengastusvuosi;

    public Lintu(String nimi, String latinankielinenNimi, int rengastusvuosi) {
        this.nimi = nimi;
        this.latinankielinenNimi = latinankielinenNimi;
        this.rengastusvuosi = rengastusvuosi;
    }


    @Override
    public String toString() {
        return this.latinankielinenNimi + " (" + this.rengastusvuosi + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.latinankielinenNimi);
        hash = 29 * hash + this.rengastusvuosi;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lintu other = (Lintu) obj;
        if (this.rengastusvuosi != other.rengastusvuosi) {
            return false;
        }
        if (!Objects.equals(this.latinankielinenNimi, other.latinankielinenNimi)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
