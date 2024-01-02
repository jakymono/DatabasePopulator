package com.LaboratorioIntegrato.DatabasePopulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class Root {
    @JsonProperty("rank")
    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    int rank;

    @JsonProperty("team")
    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    Team team;

    @JsonProperty("points")
    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    int points;

    @JsonProperty("goalsDiff")
    public int getGoalsDiff() {
        return this.goalsDiff;
    }

    public void setGoalsDiff(int goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    int goalsDiff;

    @JsonProperty("group")
    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    String group;

    @JsonProperty("form")
    public String getForm() {
        return this.form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    String form;

    @JsonProperty("status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;

    @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

    @JsonProperty("all")
    public All getAll() {
        return this.all;
    }

    public void setAll(All all) {
        this.all = all;
    }

    All all;

    @JsonProperty("home")
    public Home getHome() {
        return this.home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    Home home;

    @JsonProperty("away")
    public Away getAway() {
        return this.away;
    }

    public void setAway(Away away) {
        this.away = away;
    }

    Away away;

    @JsonProperty("update")
    public Date getUpdate() {
        return this.update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    Date update;
}
