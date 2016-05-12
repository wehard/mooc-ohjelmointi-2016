/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

/**
 *
 * @author willehard
 */
public class Hahmo {

    private int x, y;
    protected char kirjain;
    private Pelialue pelialue;

    public Hahmo(int x, int y, Pelialue pelialue) {
        this.x = x;
        this.y = y;
        this.pelialue = pelialue;
    }

    public boolean siirra(String suunta) {
        switch (suunta) {
            case "w":
                if (this.voikoSiirtya(suunta)) {
                    this.y--;
                    return true;
                }
                break;
            case "a":
                if (this.voikoSiirtya(suunta)) {
                    this.x--;
                    return true;
                }
                break;
            case "s":
                if (this.voikoSiirtya(suunta)) {
                    this.y++;
                    return true;
                }
                break;
            case "d":
                if (this.voikoSiirtya(suunta)) {
                    this.x++;
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean voikoSiirtya(String suunta) {
        if (suunta.equals("w") && this.getY() > 0) {
            return true;
        }
        if (suunta.equals("a") && this.getX() > 0) {
            return true;
        }
        if (suunta.equals("s") && this.getY() < this.pelialue.getKorkeus()-1) {
            return true;
        }
        if (suunta.equals("d") && this.getX() < this.pelialue.getLeveys()-1) {
            return true;
        }
        return false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    public void setPaikka(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return this.kirjain + " " + this.getX() + " " + this.getY();
    }
}
