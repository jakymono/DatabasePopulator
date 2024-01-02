package com.LaboratorioIntegrato.DatabasePopulator.model.db;

public class StatisticheGiocatore
{
    public int idGiocatore;
    public int stagione; //FK,PK
    public int idSquadra; //FK
    public int presenze;
    public int partitaTitolare;
    public int minutiGiocati;
    public String posizione;
    public float mediaVoto;
    public int cambiDentro;
    public int cambiFuori;
    public int tiriTotali;
    public int tiriPorta;
    public int goal;
    public int assist;
    public int passaggiTotali;
    public int passaggiChiave;
    public int contrasti;
    public int blocchi;
    public int intercetti;
    public int duelliTotali;
    public int duelliVinti;
    public int dribblingTotali;
    public int dribblingRiusciti;
    public int falliFatti;
    public int falliSubiti;
    public int cartelliniGialli;
    public int doppiGialli;
    public int cartelliniRossi;
    public int rigoriSegnati;
    public int rigoriSbagliati;
    public int rigoriParati;

    public StatisticheGiocatore(int idGiocatore, int stagione, int idSquadra, int presenze, int partitaTitolare, int minutiGiocati, String posizione, float mediaVoto, int cambiDentro, int cambiFuori, int tiriTotali, int tiriPorta, int goal, int assist, int passaggiTotali, int passaggiChiave, int contrasti, int blocchi, int intercetti, int duelliTotali, int duelliVinti, int dribblingTotali, int dribblingRiusciti, int falliFatti, int falliSubiti, int cartelliniGialli, int doppiGialli, int cartelliniRossi, int rigoriSegnati, int rigoriSbagliati, int rigoriParati) {
        this.idGiocatore = idGiocatore;
        this.stagione = stagione;
        this.idSquadra = idSquadra;
        this.presenze = presenze;
        this.partitaTitolare = partitaTitolare;
        this.minutiGiocati = minutiGiocati;
        this.posizione = posizione;
        this.mediaVoto = mediaVoto;
        this.cambiDentro = cambiDentro;
        this.cambiFuori = cambiFuori;
        this.tiriTotali = tiriTotali;
        this.tiriPorta = tiriPorta;
        this.goal = goal;
        this.assist = assist;
        this.passaggiTotali = passaggiTotali;
        this.passaggiChiave = passaggiChiave;
        this.contrasti = contrasti;
        this.blocchi = blocchi;
        this.intercetti = intercetti;
        this.duelliTotali = duelliTotali;
        this.duelliVinti = duelliVinti;
        this.dribblingTotali = dribblingTotali;
        this.dribblingRiusciti = dribblingRiusciti;
        this.falliFatti = falliFatti;
        this.falliSubiti = falliSubiti;
        this.cartelliniGialli = cartelliniGialli;
        this.doppiGialli = doppiGialli;
        this.cartelliniRossi = cartelliniRossi;
        this.rigoriSegnati = rigoriSegnati;
        this.rigoriSbagliati = rigoriSbagliati;
        this.rigoriParati = rigoriParati;
    }
}