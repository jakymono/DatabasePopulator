package com.LaboratorioIntegrato.DatabasePopulator.model.api.players;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Statistic{
    public Team team;
    public League league;
    public Games games;
    public Substitutes substitutes;
    public Shots shots;
    public Goals goals;
    public Passes passes;
    public Tackles tackles;
    public Duels duels;
    public Dribbles dribbles;
    public Fouls fouls;
    public Cards cards;
    public Penalty penalty;
}
