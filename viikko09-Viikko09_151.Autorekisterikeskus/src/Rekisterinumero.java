
import java.util.Objects;


public class Rekisterinumero {
    // älä muuta luokan jo valmiina olevia osia

    // HUOM: oliomuuttujissa on määre final eli niiden arvoa ei voi muuttaa!
    private final String rekNro;
    private final String maa;

    public Rekisterinumero(String maa, String rekNro) {
        this.rekNro = rekNro;
        this.maa = maa;
    }

    @Override
    public String toString() {
        return maa + " " + rekNro;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Rekisterinumero verrattava = (Rekisterinumero) object;
        if (this.maa != verrattava.maa) {
            return false;
        }
        if (this.rekNro != verrattava.rekNro) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.rekNro);
        hash = 79 * hash + Objects.hashCode(this.maa);
        return hash;
    }
    
    

}
