package com.LaboratorioIntegrato.DatabasePopulator.model.db;

public class StatisticheSquadra
{
    public int idSquadra;
    public int stagione; //FK
    public int classifica;
    public int punti;
    public int differenzaReti;
    public String forma;
    public String descrizione;
    public int partiteGiocate;
    public int partiteVinte;
    public int pareggi;
    public int partitePerse;
    public int golFatti;
    public int golSubiti;

    public int getPunti() {
        return punti;
    }

    public StatisticheSquadra(int idSquadra, int stagione, int punti, int differenzaReti, String forma, String descrizione, int partiteGiocate, int partiteVinte, int pareggi, int partitePerse, int golFatti, int golSubiti) {
        this.idSquadra = idSquadra;
        this.stagione = stagione;
        this.punti = punti;
        this.differenzaReti = differenzaReti;
        this.forma = forma;
        this.descrizione = descrizione;
        this.partiteGiocate = partiteGiocate;
        this.partiteVinte = partiteVinte;
        this.pareggi = pareggi;
        this.partitePerse = partitePerse;
        this.golFatti = golFatti;
        this.golSubiti = golSubiti;
    }
}