
package com.LaboratorioIntegrato.DatabasePopulator.model.api.round;

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
public class Round {

    @JsonProperty("get")
    private String get;
    @JsonProperty("parameters")
    private Parameters parameters;
    @JsonProperty("errors")
    private List<Object> errors;
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("paging")
    private Paging paging;
    @JsonProperty("response")
    public List<String> response;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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

    @JsonProperty("parameters")
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
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

    @JsonProperty("paging")
    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    @JsonProperty("response")
    public List<String> getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(List<String> response) {
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
