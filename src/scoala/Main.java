package scoala;

public class Main {
    public static void main(String[] args) {
        Scoala scoala = new Scoala();

        // clase
        Clasa c1 = new Clasa(30, NumarClasa.I, 'A');
        Clasa c2 = new Clasa(30, NumarClasa.II, 'B');
        scoala.adaugaClasa("1A", c1);
        scoala.adaugaClasa("2B", c2);

        // elevi
        scoala.adaugaElevInClasa("1A", new Elev("Ana", Gen.Feminin));
        scoala.adaugaElevInClasa("1A", new Elev("Mihai", Gen.Masculin));
        scoala.adaugaElevInClasa("1A", new Elev("Ioana", Gen.Feminin));
        scoala.adaugaElevInClasa("2B", new Elev("Andrei", Gen.Masculin));
        scoala.adaugaElevInClasa("2B", new Elev("Alex", Gen.Nespecificat));

        System.out.println("Clase: " + scoala.getNumarClase());
        System.out.println("Total elevi: " + scoala.getTotalElevi());

        // activitati
        Profesor p1 = new Profesor("Popescu", "Educatie fizica");
        Profesor p2 = new Profesor("Ionescu", "Muzica");
        Profesor p3 = new Profesor("Georgescu", "Informatica");

        scoala.adaugaActivitate(new Activitate("Fotbal", p1));
        scoala.adaugaActivitate(new Activitate("Cor", p2));
        scoala.adaugaActivitate(new Activitate("Programare", p3));

        // inscrieri
        scoala.inscrieElevLaActivitate("Ana", "Cor");
        scoala.inscrieElevLaActivitate("Ana", "Programare");
        scoala.inscrieElevLaActivitate("Mihai", "Fotbal");
        scoala.inscrieElevLaActivitate("Andrei", "Fotbal");
        scoala.inscrieElevLaActivitate("Alex", "Fotbal");
        scoala.inscrieElevLaActivitate("Andrei", "Programare");
        scoala.inscrieElevLaActivitate("Ana", "Cor"); // duplicat -> mesaj

        scoala.afiseazaTopActivitati();
        System.out.println("Elevi cu cel putin o activitate: "
                + scoala.getNumarEleviCuActivitate());

        scoala.eliminaElevDinActivitate("Mihai", "Fotbal");
        scoala.eliminaActivitate("Cor");
        scoala.eliminaElevDupaNume("Alex");
        scoala.eliminaClasa("2B");

        scoala.afiseazaTopActivitati();
        System.out.println("Total elevi: " + scoala.getTotalElevi());
        System.out.println("Elevi cu cel putin o activitate: "
                + scoala.getNumarEleviCuActivitate());
    }
}