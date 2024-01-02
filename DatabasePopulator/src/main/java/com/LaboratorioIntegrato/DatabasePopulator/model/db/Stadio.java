package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stadio {
        @Id
        public int id;
        public String nome;
        public String indirizzo;
        public String citta;
        public int capacita;
        public String terreno;
        public String immagine;


        public Stadio(int id, String nome, String indirizzo, String citta, int capacita, String terreno, String immagine) {
                this.id = id;
                this.nome = nome;
                this.indirizzo = indirizzo;
                this.citta = citta;
                this.capacita = capacita;
                this.terreno = terreno;
                this.immagine = immagine;
        }

}
