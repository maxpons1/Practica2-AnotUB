package edu.ub.ds2627.anotub.model;

import java.util.List;

public class Tasca {
    private final String id;
    private final String descripcio;
    private final List<String> expertesesRequerides; // Utilitzem String per simplificar

    public Tasca(String id, String descripcio, List<String> expertesesRequerides) {
        this.id = id;
        this.descripcio = descripcio;
        this.expertesesRequerides = expertesesRequerides;
    }

    public String getId() { return id; }
    public String getDescripcio() { return descripcio; }

    public boolean requereixExpertesa(String expertesa) {
        return this.expertesesRequerides.contains(expertesa);
    }
}
