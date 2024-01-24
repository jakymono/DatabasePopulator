
package com.LaboratorioIntegrato.DatabasePopulator.model.api.lineups;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "player",
    "goalkeeper"
})

/**
 * classe model per le api
 */
public class Colors {

    @JsonProperty("player")
    public Player player;
    @JsonProperty("goalkeeper")
    public Goalkeeper goalkeeper;

    @JsonProperty("player")
    public Player getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(Player player) {
        this.player = player;
    }

    @JsonProperty("goalkeeper")
    public Goalkeeper getGoalkeeper() {
        return goalkeeper;
    }

    @JsonProperty("goalkeeper")
    public void setGoalkeeper(Goalkeeper goalkeeper) {
        this.goalkeeper = goalkeeper;
    }

}
