
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Kayttoliittyma {

    private Scanner lukija = new Scanner(System.in);

    public Kayttoliittyma() {

    }

    public void tulostaLista(List<String> lista) {
        for (String s : lista) {
            System.out.println(s);
        }
    }

    public String kysy(String kysymys) {
        System.out.print(kysymys);
        return lukija.nextLine();
    }

}
