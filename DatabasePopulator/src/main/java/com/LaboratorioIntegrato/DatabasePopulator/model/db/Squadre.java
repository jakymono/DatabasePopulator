package com.LaboratorioIntegrato.DatabasePopulator.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Squadre {
        @Id
        public int id;
        public String nome;
        public String abbreviazione;
        public int id_stadio;
        public String paese;
        public int fondazione;
        public boolean nazionale;
        public String logo;




        public Squadre(int id, String nome, String abbrevazione, int id_stadio, String paese, int fondazione, boolean nazionale, String logo) {
                this.id = id;
                this.nome = nome;
                this.abbreviazione = abbrevazione;
                this.id_stadio = id_stadio;
                this.paese = paese;
                this.fondazione = fondazione;
                this.nazionale = nazionale;
                this.logo = logo;
        }
        public Squadre() {
        }


}
