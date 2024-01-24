package com.LaboratorioIntegrato.DatabasePopulator.model.db.classId;

import java.io.Serializable;
import java.util.Objects;

/**
 * model per la primary key di partita_evento
 */
public class PartitaEventoId implements Serializable {

    private int id_partita;

    private int id_evento;

    public PartitaEventoId(int id_partita, int id_evento) {
        this.id_partita = id_partita;
        this.id_evento = id_evento;
    }

    public PartitaEventoId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartitaEventoId that = (PartitaEventoId) o;
        return id_partita == that.id_partita && id_evento == that.id_evento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_partita, id_evento);
    }
}
