
package com.LaboratorioIntegrato.DatabasePopulator.model.api.players;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "team",
    "league",
    "games",
    "substitutes",
    "shots",
    "goals",
    "passes",
    "tackles",
    "duels",
    "dribbles",
    "fouls",
    "cards",
    "penalty"
})

public class Statistic {

    @JsonProperty("team")
    public Team team;
    @JsonProperty("league")
    public League league;
    @JsonProperty("games")
    public Games games;
    @JsonProperty("substitutes")
    public Substitutes substitutes;
    @JsonProperty("shots")
    public Shots shots;
    @JsonProperty("goals")
    public Goals goals;
    @JsonProperty("passes")
    public Passes passes;
    @JsonProperty("tackles")
    public Tackles tackles;
    @JsonProperty("duels")
    public Duels duels;
    @JsonProperty("dribbles")
    public Dribbles dribbles;
    @JsonProperty("fouls")
    public Fouls fouls;
    @JsonProperty("cards")
    public Cards cards;
    @JsonProperty("penalty")
    public Penalty penalty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
