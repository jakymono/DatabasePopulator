package com.LaboratorioIntegrato.DatabasePopulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class All{
    @JsonProperty("played")
    public int getPlayed() {
        return this.played; }
    public void setPlayed(int played) {
        this.played = played; }
    int played;
    @JsonProperty("win")
    public int getWin() {
        return this.win; }
    public void setWin(int win) {
        this.win = win; }
    int win;
    @JsonProperty("draw")
    public int getDraw() {
        return this.draw; }
    public void setDraw(int draw) {
        this.draw = draw; }
    int draw;
    @JsonProperty("lose")
    public int getLose() {
        return this.lose; }
    public void setLose(int lose) {
        this.lose = lose; }
    int lose;
    @JsonProperty("goals")
    public Goals getGoals() {
        return this.goals; }
    public void setGoals(Goals goals) {
        this.goals = goals; }
    Goals goals;
}

