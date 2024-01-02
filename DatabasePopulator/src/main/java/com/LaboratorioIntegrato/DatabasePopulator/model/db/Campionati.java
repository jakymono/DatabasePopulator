package com.LaboratorioIntegrato.DatabasePopulator.model.db;

public class Campionati
{
    public int id;
    public String nome;
    public String paese;
    public String logo;
    public String bandiera_nazionale;

    public Campionati(int id, String nome, String paese, String logo, String bandiera_nazionale) {
        this.id = id;
        this.nome = nome;
        this.paese = paese;
        this.logo = logo;
        this.bandiera_nazionale = bandiera_nazionale;
    }
}
