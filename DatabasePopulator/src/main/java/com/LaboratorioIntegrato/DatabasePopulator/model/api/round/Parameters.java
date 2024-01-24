
package com.LaboratorioIntegrato.DatabasePopulator.model.api.round;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "current",
    "league",
    "season"
})

/**
 * classe model per le api
 */
public class Parameters {

    @JsonProperty("current")
    private String current;
    @JsonProperty("league")
    private String league;
    @JsonProperty("season")
    private String season;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("current")
    public String getCurrent() {
        return current;
    }

    @JsonProperty("current")
    public void setCurrent(String current) {
        this.current = current;
    }

    @JsonProperty("league")
    public String getLeague() {
        return league;
    }

    @JsonProperty("league")
    public void setLeague(String league) {
        this.league = league;
    }

    @JsonProperty("season")
    public String getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(String season) {
        this.season = season;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
