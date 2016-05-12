
import java.util.Scanner;

public class Karkausvuosi {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna vuosi: ");
        String vastaus = lukija.nextLine();
        Integer vuosi = Integer.parseInt(vastaus);
        /*
            try {
                vuosi = Integer.parseInt(vastaus);
            } catch (Exception e) {
                
                continue;
            }
         */
        boolean karkausvuosi = false;

        if (vuosi % 4 == 0) {
            karkausvuosi = true;
            if (vuosi % 100 == 0) {
                if (vuosi % 400 == 0) {
                    karkausvuosi = true;
                } else {
                    karkausvuosi = false;
                }
            }
        } else {
            karkausvuosi = false;
        }

        if (karkausvuosi) {
            System.out.println("Vuosi on karkausvuosi.");
        } else {
            System.out.println("Vuosi ei ole karkausvuosi.");
        }

    }
}
