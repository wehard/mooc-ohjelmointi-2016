/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Lintu {
    private String nimi;
    private String latinaNimi;
    
    public Lintu(String nimi, String latinaNimi) {
        this.nimi = nimi;
        this.latinaNimi = latinaNimi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public String getLatNimi() {
        return latinaNimi;
    }
    
}
