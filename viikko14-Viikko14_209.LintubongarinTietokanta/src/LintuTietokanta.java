
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class LintuTietokanta {

    private List<Lintu> linnut = new ArrayList<>();
    
    
    public LintuTietokanta() {
    }
    
    

    public void lisaaLintu(Lintu lintu) {
        if(!linnut.contains(lintu)) {
            linnut.add(lintu);
        }
    }

    public boolean lisaaHavainto(Lintu lintu) {
        for(Lintu l : linnut) {
            if(l.equals(lintu)) {
                l.havaittu();
                return true;
            }
        }
        return false;
    }
    
    public String naytaLintu(Lintu lintu) {
        for(Lintu l : linnut) {
            if(l.equals(lintu)) {
                return l.toString();
            }
        }
        return "Linnun tietoja ei löydy!";
    }

    @Override
    public String toString() {
        String ret = "";

        for (Lintu l : this.linnut) {
            ret += l.toString() + "\n";
        }

        return ret;
    }

}
