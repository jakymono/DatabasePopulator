
package com.LaboratorioIntegrato.DatabasePopulator.model.api.teamstats;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

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
public class All {

    @JsonProperty("played")
    public Integer played;
    @JsonProperty("win")
    public Integer win;
    @JsonProperty("draw")
    public Integer draw;
    @JsonProperty("lose")
    public Integer lose;
    @JsonProperty("goals")
    public Goals goals;
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
