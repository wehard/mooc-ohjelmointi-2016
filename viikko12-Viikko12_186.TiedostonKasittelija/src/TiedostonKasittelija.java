
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TiedostonKasittelija {

    public ArrayList<String> lue(String tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(new File(tiedosto));
        ArrayList<String> lista = new ArrayList<>();
        while (lukija.hasNextLine()) {
            lista.add(lukija.nextLine());
        }
        return lista;
    }

    public void tallenna(String tiedosto, String teksti) throws IOException {
        try {
            FileWriter fw = new FileWriter(tiedosto);
            fw.write(teksti);
            fw.close();
        } catch (Exception e) {
            throw new FileNotFoundException("Tiedostoa '" + tiedosto + "' ei löydy!");
        }
    }

    public void tallenna(String tiedosto, ArrayList<String> tekstit) throws IOException {
        try {            
            FileWriter fw = new FileWriter(tiedosto);
            for(String s : tekstit) {
                fw.write(s + "\n");
            }
            fw.close();
        } catch (Exception e) {
            throw new FileNotFoundException("Tiedostoa '" + tiedosto + "' ei löydy!");
        }
    }
}
