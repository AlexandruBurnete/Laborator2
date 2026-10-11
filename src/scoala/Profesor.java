package scoala;

public class Profesor {
    private String nume;
    private String specializare;

    public Profesor(String nume, String specializare) {
        this.nume = nume;
        this.specializare = specializare;
    }

    public String getNume()
    { return nume;  }

    public void setNume(String nume)
    { this.nume = nume; }

    public String getSpecializare()
    { return specializare; }

    public void setSpecializare(String specializare)
    { this.specializare = specializare; }

    @Override
    public String toString() {
        return nume + " (" + specializare + ")";
    }
}
