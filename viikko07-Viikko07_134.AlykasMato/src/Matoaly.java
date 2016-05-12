
import java.util.Random;
import matopeli.Matopeli;
import matopeli.Pala;

public class Matoaly {

    public String annaSiirto(Matopeli matopeli) {
        // vaihtoehtoja ovat: YLOS, ALAS, VASEN, OIKEA
        String[] suunta = new String[]{"YLOS", "ALAS", "VASEN", "OIKEA"};
        Random rnd = new Random();
        //String edellinenSuunta = "";
        int[][] pelialue = matopeli.annaAlusta();

        if (matopeli.omenaX() > matopeli.matoX()) {
            return this.voikoSiirtya("OIKEA", matopeli) ? "OIKEA" : "YLOS";
        } else if (matopeli.omenaX() < matopeli.matoX()) {
            return this.voikoSiirtya("VASEN", matopeli) ? "VASEN" : "ALAS";
        }

        if (matopeli.omenaY() > matopeli.matoY()) {
            return this.voikoSiirtya("YLOS", matopeli) ? "YLOS" : "VASEN";
        } else if (matopeli.omenaY() < matopeli.matoY()) {
            return this.voikoSiirtya("ALAS", matopeli) ? "ALAS" : "YLOS";
        }

        /*
        // voit käyttää allaolevaa tulostusta pelialueen tulostamiseen konsoliin
        for (int y = pelialue[0].length - 1; y >= 0; y--) {
            for (int x = 0; x < pelialue.length; x++) {
                if (pelialue[x][y] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(pelialue[x][y]);
            }

            System.out.println("");
        }
        System.out.println("");
         */
        return "YLOS";
    }

    public boolean voikoSiirtya(String suunta, Matopeli matopeli) {

        switch (suunta) {
            case "YLOS":
                if (!onkoMatopalaSuunnassa(suunta, matopeli) && matopeli.matoY() < matopeli.korkeus()) {
                    return true;
                } else {
                    return false;
                }
            case "ALAS":
                if (!onkoMatopalaSuunnassa(suunta, matopeli) && matopeli.matoY() > 0) {
                    return true;
                } else {
                    return false;
                }
            case "VASEN":
                if (!onkoMatopalaSuunnassa(suunta, matopeli) && matopeli.matoX() > 0) {
                    return true;
                } else {
                    return false;
                }
            case "OIKEA":
                if (!onkoMatopalaSuunnassa(suunta, matopeli) && matopeli.matoX() < matopeli.korkeus()) {
                    return true;
                } else {
                    return false;
                }
        }

        return false;
    }

    public boolean onkoMatopalaSuunnassa(String suunta, Matopeli matopeli) {

        for (Pala pala : matopeli.madonPalat()) {
            if (suunta.equals("YLOS") && matopeli.matoY() + 1 == pala.getY() && matopeli.matoX() == pala.getX()) {
                return true;
            }
            if (suunta.equals("ALAS") && matopeli.matoY() - 1 == pala.getY() && matopeli.matoX() == pala.getX()) {
                return true;
            }
            if (suunta.equals("VASEN") && matopeli.matoX() - 1 == pala.getX() && matopeli.matoY() == pala.getY()) {
                return true;
            }
            if (suunta.equals("OIKEA") && matopeli.matoX() + 1 == pala.getX() && matopeli.matoY() == pala.getY()) {
                return true;
            }
        }

        return false;
    }
}
