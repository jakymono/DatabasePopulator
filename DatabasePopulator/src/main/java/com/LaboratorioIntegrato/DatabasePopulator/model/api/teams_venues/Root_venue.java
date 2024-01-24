package com.LaboratorioIntegrato.DatabasePopulator.model.api.teams_venues;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * classe model per le api
 */
public class Root_venue {
    @JsonProperty("get")
    public String get;
    @JsonProperty("parameters")
    public Parameters_venue parameters;
    @JsonProperty("errors")
    public List<Object> errors;
    @JsonProperty("results")
    public Integer results;
    @JsonProperty("paging")
    public Paging_venue paging;
    @JsonProperty("response")
    public List<Response_venue> response;
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

    public List<Response_venue> getResponse() {
        return response;
    }
}
