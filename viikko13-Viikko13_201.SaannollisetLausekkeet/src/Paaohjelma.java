
public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia josta kutsut ohjelmoitavia metodeja
        System.out.println(kellonaika("44:56:34"));
    }

    public static boolean onViikonpaiva(String merkkijono) {
        return merkkijono.matches("ma|ti|ke|to|pe|la|su");
    }

    public static boolean kaikkiVokaaleja(String merkkijono) {
        return merkkijono.matches("[aeiouyäö]+");

    }

    public static boolean kellonaika(String merkkijono) {
        return merkkijono.matches("([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
    }
}
