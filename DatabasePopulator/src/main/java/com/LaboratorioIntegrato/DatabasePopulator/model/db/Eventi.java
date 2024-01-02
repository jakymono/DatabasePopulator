package com.LaboratorioIntegrato.DatabasePopulator.model.db;

public class Eventi
{
    public int id;
    public int minuto;
    public int id_squadra; //fk
    public int id_giocatore_evento; //fk
    public int id_giocatore_assist; //fk
    public String tipo_evento;
    public String dettagli;
    public String commento;

    public Eventi(int id, int minuto, int id_squadra, int id_giocatore_evento, int id_giocatore_assist, String tipo_evento, String dettagli, String commento) {
        this.id = id;
        this.minuto = minuto;
        this.id_squadra = id_squadra;
        this.id_giocatore_evento = id_giocatore_evento;
        this.id_giocatore_assist = id_giocatore_assist;
        this.tipo_evento = tipo_evento;
        this.dettagli = dettagli;
        this.commento = commento;
    }
}