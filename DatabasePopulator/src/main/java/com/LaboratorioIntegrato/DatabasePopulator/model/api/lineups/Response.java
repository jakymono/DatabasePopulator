
package com.LaboratorioIntegrato.DatabasePopulator.model.api.lineups;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "team",
    "coach",
    "formation",
    "startXI",
    "substitutes"
})

/**
 * classe model per le api
 */
public class Response {

    @JsonProperty("team")
    public Team team;
    @JsonProperty("coach")
    public Coach coach;
    @JsonProperty("formation")
    public String formation;
    @JsonProperty("startXI")
    public List<StartXI> startXI;
    @JsonProperty("substitutes")
    public List<Substitute> substitutes;

    @JsonProperty("team")
    public Team getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(Team team) {
        this.team = team;
    }

    @JsonProperty("coach")
    public Coach getCoach() {
        return coach;
    }

    @JsonProperty("coach")
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @JsonProperty("formation")
    public String getFormation() {
        return formation;
    }

    @JsonProperty("formation")
    public void setFormation(String formation) {
        this.formation = formation;
    }

    @JsonProperty("startXI")
    public List<StartXI> getStartXI() {
        return startXI;
    }

    @JsonProperty("startXI")
    public void setStartXI(List<StartXI> startXI) {
        this.startXI = startXI;
    }

    @JsonProperty("substitutes")
    public List<Substitute> getSubstitutes() {
        return substitutes;
    }

    @JsonProperty("substitutes")
    public void setSubstitutes(List<Substitute> substitutes) {
        this.substitutes = substitutes;
    }

}
