
package com.LaboratorioIntegrato.DatabasePopulator.model.api.teamstats;

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
    "played",
    "win",
    "draw",
    "lose",
    "goals"
})

/**
 * classe model per le api
 */
public class Away {

    @JsonProperty("played")
    public Integer played;
    @JsonProperty("win")
    public Integer win;
    @JsonProperty("draw")
    public Integer draw;
    @JsonProperty("lose")
    public Integer lose;
    @JsonProperty("goals")
    public Goals__1 goals;
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
