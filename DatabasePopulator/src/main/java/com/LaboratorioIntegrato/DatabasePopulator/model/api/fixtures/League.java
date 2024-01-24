
package com.LaboratorioIntegrato.DatabasePopulator.model.api.fixtures;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "country",
    "logo",
    "flag",
    "season",
    "round"
})

/**
 * classe model per le api
 */
public class League {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("country")
    public String country;
    @JsonProperty("logo")
    public String logo;
    @JsonProperty("flag")
    public String flag;
    @JsonProperty("season")
    public Integer season;
    @JsonProperty("round")
    public String round;
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
