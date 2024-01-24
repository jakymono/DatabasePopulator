package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.classId.CampionatoSquadreId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

/**
 * model per la tabella del db
 */
@Entity
@IdClass(CampionatoSquadreId.class)
public class Campionato_squadre
{
    @Id
    public int id_squadra;
    @Id
    public int id_campionato; //fk
    @Id
    public int stagione; //fk

    public Campionato_squadre(int id_campionato, int id_squadra, int stagione) {
        this.id_squadra = id_squadra;
        this.id_campionato = id_campionato;
        this.stagione = stagione;
    }

    public Campionato_squadre() {
    }
}