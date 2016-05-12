import java.util.Scanner;

public class Loppuosa {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna sana: ");
        String sana = lukija.nextLine();
        
        System.out.print("Loppuosan pituus: ");
        int pituus = Integer.parseInt(lukija.nextLine());
        
 
        System.out.println("Tulos: " + sana.substring(sana.length()-pituus));
       
        
        
        
    }
}
