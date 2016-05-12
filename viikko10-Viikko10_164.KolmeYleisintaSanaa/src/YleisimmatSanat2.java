
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YleisimmatSanat2 implements ToistonTunnistin {

    YleisimmatSanat2() {
    }

    public List<String> yleisetSanat(List<String> sanat) {

        Map<String, Integer> sanaHashMap = new HashMap<>();

        for (String s : sanat) {
            if (sanaHashMap.containsKey(s)) {
                sanaHashMap.put(s, sanaHashMap.get(s) + 1);
            } else {
                sanaHashMap.put(s, 1 * (100/s.length()));
            }
        }
        
        
        for(String s: sanaHashMap.keySet()) {
            sanaHashMap.put(s, sanaHashMap.get(s));
        }


        HashMap<String, Integer> lopullinen = new HashMap<>();
        ArrayList<String> yleisimmatSanat = new ArrayList<>();

        while (yleisimmatSanat.size() < 3) {
            int korkeinMaara = 0;
            String sana = null;
            for(String s : sanaHashMap.keySet()) {
                if(sanaHashMap.get(s) > korkeinMaara) {
                    korkeinMaara = sanaHashMap.get(s);
                    sana = s;
                }
            }
            yleisimmatSanat.add(sana);
            sanaHashMap.remove(sana);
        }
        return yleisimmatSanat;
    }
}
