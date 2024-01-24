
package com.LaboratorioIntegrato.DatabasePopulator.model.api.events;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "get",
    "parameters",
    "errors",
    "results",
    "paging",
    "response"
})

/**
 * classe model per le api
 */
public class Events {

    @JsonProperty("get")
    public String get;
    @JsonProperty("parameters")
    public Parameters parameters;
    @JsonProperty("errors")
    public List<Object> errors;
    @JsonProperty("results")
    public Integer results;
    @JsonProperty("paging")
    public Paging paging;
    @JsonProperty("response")
    public List<Response> response;
    @JsonIgnore
    public Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("get")
    public String getGet() {
        return get;
    }

    @JsonProperty("get")
    public void setGet(String get) {
        this.get = get;
    }

    @JsonProperty("parameters")
    public Parameters getParameters() {
        return parameters;
    }


    @JsonProperty("errors")
    public List<Object> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    @JsonProperty("results")
    public Integer getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(Integer results) {
        this.results = results;
    }

    @JsonProperty("paging")
    public Paging getPaging() {
        return paging;
    }


    @JsonProperty("response")
    public List<Response> getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(List<Response> response) {
        this.response = response;
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
