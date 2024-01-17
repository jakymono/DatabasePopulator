
package com.LaboratorioIntegrato.DatabasePopulator.model.api.events;

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
    "elapsed",
    "extra"
})

public class Time {

    @JsonProperty("elapsed")
    public Integer elapsed;
    @JsonProperty("extra")
    public Integer extra;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("elapsed")
    public Integer getElapsed() {
        return elapsed;
    }

    @JsonProperty("elapsed")
    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    @JsonProperty("extra")
    public Integer getExtra() {
        return extra;
    }

    @JsonProperty("extra")
    public void setExtra(Integer extra) {
        this.extra = extra;
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
