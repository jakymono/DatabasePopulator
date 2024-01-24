package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.*;
import java.sql.Timestamp;

/**
 * model per la tabella del db
 */
@Entity
public class Partite
{
    @Id
    public int id;
    public int id_casa; //fk
    public int id_ospite; //fk
    public int id_stadio; //fk
    public int id_campionato; //fk
    public String arbitro;
    public String round;
    public int stagione;
    public Timestamp timestamp_partita;
    public String status;
    public int gol_casa;
    public int gol_ospiti;
    public int gol_casa_suppl;
    public int gol_ospiti_suppl;
    public int rigori_finali_casa;
    public int rigori_finali_ospiti;


    public Partite(int id, int id_casa, int id_ospite, int id_stadio, int id_campionato, String arbitro, String round, int stagione, Timestamp timestamp_partita, String status, int gol_casa, int gol_ospiti, int gol_casa_suppl, int gol_ospiti_suppl, int rigori_finali_casa, int rigori_finali_ospiti) {
        this.id = id;
        this.id_casa = id_casa;
        this.id_ospite = id_ospite;
        this.id_stadio = id_stadio;
        this.id_campionato = id_campionato;
        this.arbitro = arbitro;
        this.round = round;
        this.stagione = stagione;
        this.timestamp_partita = timestamp_partita;
        this.status = status;
        this.gol_casa = gol_casa;
        this.gol_ospiti = gol_ospiti;
        this.gol_casa_suppl = gol_casa_suppl;
        this.gol_ospiti_suppl = gol_ospiti_suppl;
        this.rigori_finali_casa = rigori_finali_casa;
        this.rigori_finali_ospiti = rigori_finali_ospiti;
    }

    public Partite() {
    }


}