package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.*;

@Entity
public class Eventi
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int minuto;
    public int id_squadra; //fk
    public int id_giocatore_evento; //fk
    public String nome_giocatore_assist; //fk
    public String tipo_evento;
    public String dettagli;
    public String commento;

    public Eventi(int minuto, int id_squadra, int id_giocatore_evento, String nome_giocatore_assist, String tipo_evento, String dettagli, String commento) {
        this.minuto = minuto;
        this.id_squadra = id_squadra;
        this.id_giocatore_evento = id_giocatore_evento;
        this.nome_giocatore_assist = nome_giocatore_assist;
        this.tipo_evento = tipo_evento;
        this.dettagli = dettagli;
        this.commento = commento;
    }


}