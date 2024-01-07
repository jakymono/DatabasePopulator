package com.LaboratorioIntegrato.DatabasePopulator.model.db.classId;

import java.io.Serializable;
import java.util.Objects;

public class CampionatoSquadreId implements Serializable {
    private int id_squadra;

    private int id_campionato;

    private int stagione;


    public CampionatoSquadreId(int id_squadra, int id_campionato, int stagione) {
        this.id_squadra = id_squadra;
        this.id_campionato = id_campionato;
        this.stagione = stagione;
    }

    public CampionatoSquadreId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampionatoSquadreId that = (CampionatoSquadreId) o;
        return Objects.equals(id_squadra, that.id_squadra) && Objects.equals(id_campionato, that.id_campionato) && Objects.equals(stagione, that.stagione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_squadra, id_campionato, stagione);
    }

    public void setId_squadra(int id_squadra) {
        this.id_squadra = id_squadra;
    }

    public void setId_campionato(int id_campionato) {
        this.id_campionato = id_campionato;
    }

    public void setStagione(int stagione) {
        this.stagione = stagione;
    }
}