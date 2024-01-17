package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Formazioni {

    @Id
    public int id_partita;
    public int id_casa;
    public int id_ospiti;
    public String formazione_casa;
    public String formazione_ospiti;
    public String sostituzioni_casa;
    public String sostituzioni_ospiti;
    public String allenatore_casa;
    public String allenatore_ospiti;
    public String schema_casa;
    public String schema_ospiti;

    public Formazioni(int id_partita, int id_casa, int id_ospiti, String formazione_casa, String formazione_ospiti, String sostituzioni_casa, String sostituzioni_ospiti, String allenatore_casa, String allenatore_ospiti, String schema_casa, String schema_ospiti) {
        this.id_partita = id_partita;
        this.id_casa = id_casa;
        this.id_ospiti = id_ospiti;
        this.formazione_casa = formazione_casa;
        this.formazione_ospiti = formazione_ospiti;
        this.sostituzioni_casa = sostituzioni_casa;
        this.sostituzioni_ospiti = sostituzioni_ospiti;
        this.allenatore_casa = allenatore_casa;
        this.allenatore_ospiti = allenatore_ospiti;
        this.schema_casa = schema_casa;
        this.schema_ospiti = schema_ospiti;
    }

    public Formazioni() {
    }
}