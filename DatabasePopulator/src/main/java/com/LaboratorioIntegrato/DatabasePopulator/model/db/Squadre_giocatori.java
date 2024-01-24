package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.classId.SquadreGiocatoriId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

/**
 * model per la tabella del db
 */
@Entity
@IdClass(SquadreGiocatoriId.class)
public class Squadre_giocatori {
    @Id
    public int id_squadra;
    @Id
    public int id_giocatore;
    @Id
    public int stagione;
    @Id
    public Boolean attuale;

    public Squadre_giocatori(int id_squadra, int id_giocatore, int stagione, Boolean attuale) {
        this.id_squadra = id_squadra;
        this.id_giocatore = id_giocatore;
        this.stagione = stagione;
        this.attuale = attuale;
    }

    public Squadre_giocatori() {
    }
}
