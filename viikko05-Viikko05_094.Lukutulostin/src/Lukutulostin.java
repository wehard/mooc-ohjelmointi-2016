/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Lukutulostin {

    public void lukuporras(int luku) {

        for (int y = 1; y <= luku; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(x + " ");
            }
            System.out.println("");
        }

    }

    public void jatkuvaLukuporras(int luku) {

        int val = 1;

        for (int y = 1; y <= luku; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(val + " ");
                val++;
            }
            System.out.println("");
        }
    }

    public void kertokolmio(int luku) {

        for (int y = 1; y <= luku; y++) {

            for (int x = 1; x <= y; x++) {

                if (x > 1) {
                    System.out.print(y * x + " ");

                } else {
                    System.out.print(y + " ");

                }

            }
            System.out.println("");
        }

    }
}
