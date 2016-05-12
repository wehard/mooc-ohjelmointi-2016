
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class YleisimmatSanat1 implements ToistonTunnistin {

    YleisimmatSanat1() {
    }

    public List<String> yleisetSanat(List<String> sanat) {

        ArrayList<Sana> sanaLista = new ArrayList<>();
        
        HashMap<String, Integer> sanaHashMap = new HashMap<>();
        
        for(String sana : sanat) {
            if(!sanaHashMap.containsKey(sana)) {
                sanaHashMap.put(sana, 1);
            } else {
                sanaHashMap.put(sana, sanaHashMap.get(sana) + 1);
            }
        }
        
        //HashMap<String, Integer> sanaHashMapKopio = new HashMap<>(sanaHashMap);

        Sana[] kolmeTavallisintaSanaa = new Sana[3];
        
        for (int i = 0; i < 3; i++) {
            HashMap.Entry<String, Integer> entry = this.getYleisin(sanaHashMap);
            sanaLista.add(new Sana(entry.getKey(), entry.getValue()));
            sanaHashMap.remove(entry.getKey());
            kolmeTavallisintaSanaa[i] = sanaLista.get(i);
        }
        
        ArrayList<String> lopullinen = new ArrayList<>();
        
        Arrays.sort(kolmeTavallisintaSanaa);
        
        for (int i = 0; i < 3; i++) {
            lopullinen.add(kolmeTavallisintaSanaa[i].merkkijono);
        }
        
        

        return lopullinen;
    }
    
    
     

    private HashMap.Entry<String, Integer> getYleisin(Map<String, Integer> hashMap) {
        HashMap.Entry<String, Integer> yleisinEntry = null;
        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (yleisinEntry == null || entry.getValue().compareTo(yleisinEntry.getValue()) > 0) {
                yleisinEntry = entry;
            }
        }
        return yleisinEntry;
    }

    private class Sana implements Comparable<Sana> {

        private String merkkijono = "";
        private int esiintymisKerrat = 0;

        public Sana(String s, int i) {
            this.merkkijono = s;
            this.esiintymisKerrat = i;
        }

        public void setSana(String s) {
            this.merkkijono = s;
        }

        public void kasvataEsiintymiskertoja() {
            this.esiintymisKerrat++;
        }

        public String getSana() {
            return this.merkkijono;
        }

        public int getEsiintymisKerrat() {
            return this.esiintymisKerrat;
        }

        public boolean onko(String s) {
            return this.merkkijono.equals(s);
        }

        @Override
        public String toString() {
            return this.merkkijono;
        }

        
        @Override
        public int compareTo(Sana o) {
            
            
            if(this.esiintymisKerrat == o.esiintymisKerrat) {
                return (int) this.merkkijono.length() - o.merkkijono.length();
            } else {
                return (int) o.esiintymisKerrat - this.esiintymisKerrat;
            }
            
        }
    }

}
