
package com.LaboratorioIntegrato.DatabasePopulator.model.api.lineups;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "player"
})

public class Substitute {

    @JsonProperty("player")
    public Player__1 player;

    @JsonProperty("player")
    public Player__1 getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(Player__1 player) {
        this.player = player;
    }

}
