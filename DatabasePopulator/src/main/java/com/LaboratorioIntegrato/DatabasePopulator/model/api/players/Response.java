package com.LaboratorioIntegrato.DatabasePopulator.model.api.players;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "player",
        "statistics"
})
/**
 * classe model per le api
 */
/**
 * classe model per le api
 */
public class Response{
    @JsonProperty("player")
    public Player player;
    @JsonProperty("statistics")
    public List<Statistic> statistics;
}
