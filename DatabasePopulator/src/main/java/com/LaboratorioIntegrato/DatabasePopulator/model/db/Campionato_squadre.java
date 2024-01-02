package com.LaboratorioIntegrato.DatabasePopulator.model.db;


public class Campionato_squadre
{
    public int id_squadra;
    public int id_campionato; //fk
    public int stagione; //fk

    public Campionato_squadre(int id_squadra, int id_campionato, int stagione) {
        this.id_squadra = id_squadra;
        this.id_campionato = id_campionato;
        this.stagione = stagione;
    }
}