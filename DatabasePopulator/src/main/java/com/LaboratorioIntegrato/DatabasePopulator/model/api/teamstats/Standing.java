
package com.LaboratorioIntegrato.DatabasePopulator.model.api.teamstats;

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
    "rank",
    "team",
    "points",
    "goalsDiff",
    "group",
    "form",
    "status",
    "description",
    "all",
    "home",
    "away",
    "update"
})

/**
 * classe model per le api
 */
public class Standing {

    @JsonProperty("rank")
    public Integer rank;
    @JsonProperty("team")
    public Team team;
    @JsonProperty("points")
    public Integer points;
    @JsonProperty("goalsDiff")
    public Integer goalsDiff;
    @JsonProperty("group")
    public String group;
    @JsonProperty("form")
    public String form;
    @JsonProperty("status")
    public String status;
    @JsonProperty("description")
    public String description;
    @JsonProperty("all")
    public All all;
    @JsonProperty("home")
    public Home home;
    @JsonProperty("away")
    public Away away;
    @JsonProperty("update")
    public String update;
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
