package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.classId.PartitaEventoId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(PartitaEventoId.class)
public class Partita_Evento {

    @Id
    public int id_partita;

    @Id
    public int id_evento;

    public Partita_Evento(int id_partita, int id_evento) {
        this.id_partita = id_partita;
        this.id_evento = id_evento;
    }

    public Partita_Evento() {
    }
}
