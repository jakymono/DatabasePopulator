
package com.LaboratorioIntegrato.DatabasePopulator.model.api.events;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fixture"
})

/**
 * classe model per le api
 */
public class Parameters {

    @JsonProperty("fixture")
    public String fixture;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("fixture")
    public String getFixture() {
        return fixture;
    }

    @JsonProperty("fixture")
    public void setFixture(String fixture) {
        this.fixture = fixture;
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
