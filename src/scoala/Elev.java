package scoala;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
public class Elev {
    private String nume;
    private Gen gen;
    private Set<String> activitati = new LinkedHashSet<>();
    public Elev(String nume, Gen gen) {
        this.nume = nume;
        this.gen = gen;
    }
    public String getNume() {return this.nume;}
    public void setNume(String nume) {this.nume = nume;}

    public Gen getGen() {return this.gen;}
    public void setGen(Gen gen) {this.gen = gen;}

    public Set<String> getActivitati() {return this.activitati;}

    public boolean addActivitate(String activitate) {
        return this.activitati.add(activitate);
    }
    public boolean removeActivitate(String activitate) {
        return this.activitati.remove(activitate);
    }
 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elev elev = (Elev) o;
        return Objects.equals(nume, elev.nume) && gen == elev.gen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, gen);
    }
    @Override
    public String toString() {
        return "Elev{" +
                "nume='" + nume + '\'' +
                ", gen=" + gen +
                ", activitati=" + activitati +
                '}';
    }
}
