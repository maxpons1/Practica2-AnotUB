package edu.ub.ds2627.anotub.model;

import java.util.ArrayList;
import java.util.List;

public class CatalegTasques {
    private final List<Tasca> tasques;

    public CatalegTasques() {
        this.tasques = new ArrayList<>();
    }

    public void afegirTasca(Tasca tasca) {
        this.tasques.add(tasca);
    }

    //aquest metode és el que farà la llogica de la US3
    public List<Tasca> obtenirTasquesPerExpertesa(String expertesa) {
        List<Tasca> resultat = new ArrayList<>();
        for (Tasca t : tasques) {
            if (t.requereixExpertesa(expertesa)) {
                resultat.add(t);
            }
        }
        return resultat;
    }
}
