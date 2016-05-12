
import java.util.Comparator;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Jarjestaja implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return (int)o1.length()-o2.length();
    }

   
}
