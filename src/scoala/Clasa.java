package scoala;

import java.util.ArrayList;
import java.util.List;

public class Clasa {
    private int capacitate;
    private NumarClasa numar;
    private char litera;
    private List<Elev> elevi = new ArrayList<>();

    public Clasa(int capacitate, NumarClasa numar, char litera) {
        this.capacitate = capacitate;
        this.numar = numar;
        this.litera = litera;
    }

    public int getCapacitate() {
        return this.capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public NumarClasa getNumar() {
        return this.numar;
    }

    public void setNumar(NumarClasa numar) {
        this.numar = numar;
    }

    public char getLitera() {
        return this.litera;
    }

    public void setLitera(char litera) {
        this.litera = litera;
    }

    public List<Elev> getElevi() {
        return this.elevi;
    }

    public void adaugaElev(Elev elev) {
        if (this.elevi.size() >= this.capacitate) {
            System.out.println("Clasa este plina. Nu se poate adauga elevul " + elev.getNume());
            return;
        }
        this.elevi.add(elev);
    }

    public void eliminaElev(Elev elev) {
        elevi.remove(elev);
    }

    public int getTotalElevi() {
        return elevi.size();
    }
}