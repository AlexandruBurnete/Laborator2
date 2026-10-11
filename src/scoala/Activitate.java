package scoala;

import java.util.LinkedHashSet;
import java.util.Set;

public class Activitate {
    private String nume;
    private Profesor coordonator;
    private Set<Elev> participanti = new LinkedHashSet<>();

    public Activitate(String nume, Profesor specializare)
    {
        this.nume = nume;
        this.coordonator = coordonator;
    }
    public String getNume() {   return this.nume;  }
    public void setNume(String nume) { this.nume = nume; }
    public Profesor getCoordonator() { return this.coordonator; }
    public void setCoordonator(Profesor coordonator) { this.coordonator = coordonator; }
    public Set<Elev> getParticipanti() { return this.participanti; }
    public boolean adaugaElev(Elev elev) { return this.participanti.add(elev); }
    public boolean eliminaElev(Elev elev) { return this.participanti.remove(elev); }
    public int getNumarParticipanti() { return this.participanti.size(); }

    @Override
    public String toString() {
        return nume + " - coordonator: " + coordonator + ", participanti: " + participanti.size();
    }
}
