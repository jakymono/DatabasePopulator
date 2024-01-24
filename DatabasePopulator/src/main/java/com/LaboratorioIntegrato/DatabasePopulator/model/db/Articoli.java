package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.*;

import java.util.Date;

/**
 * model per la tabella del db
 */
/**
 * model per la tabella del db
 */
@Entity
public class Articoli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public Date data;

    public String titolo;

    public String sottotitolo;

    public String hashtags;

    public String testo;

    public String immagine;
}
