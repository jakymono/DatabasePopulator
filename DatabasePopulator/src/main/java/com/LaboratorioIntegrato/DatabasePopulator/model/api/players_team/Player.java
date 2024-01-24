
package com.LaboratorioIntegrato.DatabasePopulator.model.api.players_team;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "age",
    "number",
    "position",
    "photo"
})

/**
 * classe model per le api
 */
public class Player {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("age")
    public Integer age;
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("position")
    public String position;
    @JsonProperty("photo")
    public String photo;
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
