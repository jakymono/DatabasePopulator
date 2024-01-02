package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import java.sql.Date;

public class Giocatore
{
    public int id;
    public String nome;
    public String cognome;
    public Date dataNasacita;
    public String nazionalita;
    public String altezza;
    public String peso;
    public boolean infortunato;
    public String foto;


    public Giocatore(int id, String nome, String cognome, Date dataNasacita, String nazionalita, String altezza, String peso, boolean infortunato, String foto) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNasacita = dataNasacita;
        this.nazionalita = nazionalita;
        this.altezza = altezza;
        this.peso = peso;
        this.infortunato = infortunato;
        this.foto = foto;
    }
}