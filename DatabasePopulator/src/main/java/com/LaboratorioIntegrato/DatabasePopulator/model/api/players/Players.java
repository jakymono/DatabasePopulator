
package com.LaboratorioIntegrato.DatabasePopulator.model.api.players;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "get",
    "parameters",
    "errors",
    "results",
    "paging",
    "response"
})

public class Players {

    @JsonProperty("get")
    public String get;
    @JsonProperty("parameters")
    public Parameters parameters;
    @JsonIgnore
    @JsonProperty("errors")
    public List<Object> errors;
    @JsonProperty("results")
    public Integer results;
    @JsonProperty("paging")
    public Paging paging;

    @JsonProperty("response")
    public List<Response> response;
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
