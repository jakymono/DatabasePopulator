package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Squadre_giocatori {
    @Id
    public int id_squadra;
    @Id
    public int id_giocatore;
    public Boolean attuale;

    public Squadre_giocatori(int id_squadra, int id_giocatore, Boolean attuale) {
        this.id_squadra = id_squadra;
        this.id_giocatore = id_giocatore;
        this.attuale = attuale;
    }

    public Squadre_giocatori() {
    }
}
