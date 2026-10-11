package scoala;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Scoala {
    private Map<String, Clasa> clase = new HashMap<>();
    private Map<String, Activitate> activitati = new HashMap<>();

    public void adaugaClasa(String id, Clasa clasa) {
        clase.put(id, clasa);
    }

    public void eliminaClasa(String id) {
        Clasa clasa = clase.remove(id);
        if (clasa == null) return;
        for (Elev elev : clasa.getElevi()) {
            scoateElevDinToateActivitatile(elev);
        }
    }

    public void adaugaElevInClasa(String idClasa, Elev elev) {
        Clasa clasa = clase.get(idClasa);
        if (clasa == null) {
            System.out.println("Clasa " + idClasa + " nu exista.");
            return;
        }
        clasa.adaugaElev(elev);
    }

    public void eliminaElevDupaNume(String nume) {
        for (Clasa clasa : clase.values()) {
            Elev gasit = null;
            for (Elev e : clasa.getElevi()) {
                if (e.getNume().equalsIgnoreCase(nume)) {
                    gasit = e;
                    break;
                }
            }
            if (gasit != null) {
                clasa.eliminaElev(gasit);
                scoateElevDinToateActivitatile(gasit);
                return;
            }
        }
        System.out.println("Elevul " + nume + " nu a fost gasit.");
    }

    public int getNumarClase() {
        return clase.size();
    }

    public int getTotalElevi() {
        int total = 0;
        for (Clasa c : clase.values()) {
            total += c.getTotalElevi();
        }
        return total;
    }

    public void adaugaActivitate(Activitate activitate) {
        activitati.put(activitate.getNume(), activitate);
    }

    public void eliminaActivitate(String numeActivitate) {
        Activitate a = activitati.remove(numeActivitate);
        if (a == null) {
            System.out.println("Activitatea " + numeActivitate + " nu exista.");
            return;
        }
        for (Elev e : a.getParticipanti()) {
            e.removeActivitate(numeActivitate);
        }
    }

    public Elev gasesteElev(String nume) {
        for (Clasa clasa : clase.values()) {
            for (Elev e : clasa.getElevi()) {
                if (e.getNume().equalsIgnoreCase(nume)) {
                    return e;
                }
            }
        }
        return null;
    }

    public void inscrieElevLaActivitate(String numeElev, String numeActivitate) {
        Elev elev = gasesteElev(numeElev);
        Activitate activitate = activitati.get(numeActivitate);

        if (elev == null) {
            System.out.println("Elevul " + numeElev + " nu exista.");
            return;
        }
        if (activitate == null) {
            System.out.println("Activitatea " + numeActivitate + " nu exista.");
            return;
        }
        if (activitate.adaugaElev(elev)) {
            elev.addActivitate(numeActivitate);
        } else {
            System.out.println(numeElev + " este deja inscris la " + numeActivitate);
        }
    }

    public void eliminaElevDinActivitate(String numeElev, String numeActivitate) {
        Elev elev = gasesteElev(numeElev);
        Activitate activitate = activitati.get(numeActivitate);

        if (elev == null || activitate == null) {
            System.out.println("Elevul sau activitatea nu exista.");
            return;
        }
        if (activitate.eliminaElev(elev)) {
            elev.removeActivitate(numeActivitate);
        } else {
            System.out.println(numeElev + " nu era inscris la " + numeActivitate);
        }
    }

    private void scoateElevDinToateActivitatile(Elev elev) {
        for (Activitate a : activitati.values()) {
            a.eliminaElev(elev);
        }
        elev.getActivitati().clear();
    }

    public void afiseazaTopActivitati() {
        List<Activitate> lista = new ArrayList<>(activitati.values());
        lista.sort(
                Comparator.comparingInt(Activitate::getNumarParticipanti).reversed()
                        .thenComparing(Activitate::getNume)
        );

        System.out.println("=== Top activitati ===");
        int loc = 1;
        for (Activitate a : lista) {
            System.out.println(loc++ + ". " + a.getNume() + " - "
                    + a.getNumarParticipanti() + " elevi");
        }
    }

    public int getNumarEleviCuActivitate() {
        Set<Elev> unici = new HashSet<>();
        for (Activitate a : activitati.values()) {
            unici.addAll(a.getParticipanti());
        }
        return unici.size();
    }
}