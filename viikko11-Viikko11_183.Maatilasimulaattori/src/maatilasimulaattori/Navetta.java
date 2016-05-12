package maatilasimulaattori;


import java.util.Collection;


public class Navetta {
    
    private Maitosailio sailio;
    private Lypsyrobotti robotti;
    
    public Navetta(Maitosailio maitosailio) {
        this.sailio = maitosailio;
    }
    
    public Maitosailio getMaitosailio() {
        return this.sailio;
    }
    
    public void asennaLypsyrobotti(Lypsyrobotti lypsyrobotti) {
        this.robotti = lypsyrobotti;
        this.robotti.setMaitosailio(this.sailio);
    }
    
    public void hoida(Lehma lehma) {
        this.tarkistaOnkoLypsyrobottiAsennettu();
        this.robotti.lypsa(lehma);
    }
    
    public void hoida(Collection<Lehma> lehmat) {
        for(Lehma lehma : lehmat) {
            this.hoida(lehma);
        }
    }
    
     private void tarkistaOnkoLypsyrobottiAsennettu() {
        if(this.robotti == null) throw new IllegalStateException();
    }
    
    @Override
    public String toString() {
        return this.getMaitosailio().toString();
    }
    
}
