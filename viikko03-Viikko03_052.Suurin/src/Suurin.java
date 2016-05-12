
public class Suurin {

    public static int suurin(int luku1, int luku2, int luku3) {

        return luku1 > luku2 ? (luku1 > luku3 ? luku1 : luku3) : (luku2 > luku3 ? luku2 : luku3);
        
        
    }

    public static void main(String[] args) {
        int vastaus = suurin(1, 7, 9);
        System.out.println("Suurin: " + vastaus);
    }
}