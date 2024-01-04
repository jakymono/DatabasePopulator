
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
    "won",
    "commited",
    "scored",
    "missed",
    "saved"
})

public class Penalty {

    @JsonProperty("won")
    public int won;
    @JsonProperty("commited")
    public int commited;
    @JsonProperty("scored")
    public int scored;
    @JsonProperty("missed")
    public int missed;
    @JsonProperty("saved")
    public int saved;
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
