
public class PalindrominTunnistus {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        System.out.println(onPalindromi("a man, a plan, a canal: Panama")); // true
        System.out.println(onPalindromi("not a bird, not a plane, superman!")); // false
        System.out.println(onPalindromi("saippuakauppias")); // true
        System.out.println(onPalindromi("porkkanakauppias")); // false
        System.out.println(onPalindromi("alli pamautti vittua mapilla")); // true
    }

    public static boolean onPalindromi(String merkkijono) {
        // toteuta metodi tänne
        String uusi = merkkijono.replaceAll("\\W", "").toLowerCase();
        String alku = uusi.substring(0, uusi.length()/2);
        String loppu = uusi.substring(uusi.length()/2+1);
        String loppuKaannetty = new StringBuilder(loppu).reverse().toString();
        return alku.equals(loppuKaannetty);  
    }
}
