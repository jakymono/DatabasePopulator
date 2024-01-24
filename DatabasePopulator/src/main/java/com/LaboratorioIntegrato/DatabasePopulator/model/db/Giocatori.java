package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

/**
 * model per la tabella del db
 */
@Entity
public class Giocatori
{
    @Id
    public int id;
    public String nome;
    public String cognome;
    public Date data_nascita;
    public String nazionalita;
    public String altezza;
    public String peso;
    public boolean infortunato;
    public String foto;


    public Giocatori(int id, String nome, String cognome, Date data_nasacita, String nazionalita, String altezza, String peso, boolean infortunato, String foto) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nasacita;
        this.nazionalita = nazionalita;
        this.altezza = altezza;
        this.peso = peso;
        this.infortunato = infortunato;
        this.foto = foto;
    }

    public Giocatori() {
    }
}