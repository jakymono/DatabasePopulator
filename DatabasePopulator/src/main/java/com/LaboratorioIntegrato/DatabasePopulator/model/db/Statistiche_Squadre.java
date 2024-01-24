package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * model per la tabella del db
 */
@Entity
public class Statistiche_Squadre
{
    @Id
    public int id_squadra;
    public int stagione; //FK
    public int classifica;
    public int punti;
    public int differenza_reti;
    public String forma;
    public String descrizione;
    public int partite_giocate;
    public int vinte;
    public int pareggiate;
    public int perse;
    public int gol_fatti;
    public int gol_subiti;

    public int getPunti() {
        return punti;
    }

    public int getId_squadra() {
        return id_squadra;
    }

    public int getStagione() {
        return stagione;
    }

    public Statistiche_Squadre(int id_squadra, int stagione, int classifica , int punti, int differenza_reti, String forma, String descrizione, int partite_giocate, int vinte, int pareggiate, int perse, int gol_fatti, int gol_subiti) {
        this.id_squadra = id_squadra;
        this.stagione = stagione;
        this.classifica = classifica;
        this.punti = punti;
        this.differenza_reti = differenza_reti;
        this.forma = forma;
        this.descrizione = descrizione;
        this.partite_giocate = partite_giocate;
        this.vinte = vinte;
        this.pareggiate = pareggiate;
        this.perse = perse;
        this.gol_fatti = gol_fatti;
        this.gol_subiti = gol_subiti;
    }

    public Statistiche_Squadre() {
    }
}