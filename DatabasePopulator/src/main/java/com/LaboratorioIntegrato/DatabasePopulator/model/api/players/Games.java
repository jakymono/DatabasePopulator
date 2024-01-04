
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
    "appearences",
    "lineups",
    "minutes",
    "number",
    "position",
    "rating",
    "captain"
})

public class Games {

    @JsonProperty("appearences")
    public int appearences;
    @JsonProperty("lineups")
    public int lineups;
    @JsonProperty("minutes")
    public int minutes;
    @JsonProperty("number")
    public int number;
    @JsonProperty("position")
    public String position;
    @JsonProperty("rating")
    public float rating;
    @JsonProperty("captain")
    public Boolean captain;
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
