
package com.LaboratorioIntegrato.DatabasePopulator.model.api.fixtures;

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
    "id",
    "referee",
    "timezone",
    "date",
    "timestamp",
    "periods",
    "venue",
    "status"
})

public class Fixture {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("referee")
    public String referee;
    @JsonProperty("timezone")
    public String timezone;
    @JsonProperty("date")
    public String date;
    @JsonProperty("timestamp")
    public int timestamp;
    @JsonProperty("periods")
    public Periods periods;
    @JsonProperty("venue")
    public Venue venue;
    @JsonProperty("status")
    public Status status;
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
