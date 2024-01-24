package com.LaboratorioIntegrato.DatabasePopulator.model.db.classId;

import java.io.Serializable;
import java.util.Objects;

/**
 * model per la primary key di squadre_giocatori
 */
public class SquadreGiocatoriId implements Serializable {

    public int id_squadra;

    public int id_giocatore;
    public Boolean attuale;

    public int stagione;

    public SquadreGiocatoriId(int id_squadra, int id_giocatore, Boolean attuale, int stagione) {
        this.id_squadra = id_squadra;
        this.id_giocatore = id_giocatore;
        this.attuale = attuale;
        this.stagione = stagione;
    }

    public SquadreGiocatoriId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquadreGiocatoriId that = (SquadreGiocatoriId) o;
        return id_squadra == that.id_squadra && id_giocatore == that.id_giocatore && stagione == that.stagione && Objects.equals(attuale, that.attuale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_squadra, id_giocatore, attuale, stagione);
    }
}
