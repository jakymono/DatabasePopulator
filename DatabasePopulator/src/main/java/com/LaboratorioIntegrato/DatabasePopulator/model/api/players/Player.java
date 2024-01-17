package com.LaboratorioIntegrato.DatabasePopulator.model.api.players;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Player{
    public int id;
    public String name;
    public String firstname;
    public String lastname;
    public int age;
    public Birth birth;
    public String nationality;
    public String height;
    public String weight;
    public boolean injured;
    public String photo;
}
