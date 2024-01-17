
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
    "time",
    "team",
    "player",
    "assist",
    "type",
    "detail",
    "comments"
})

public class Response {

    @JsonProperty("time")
    public Time time;
    @JsonProperty("team")
    public Team team;
    @JsonProperty("player")
    public Player player;
    @JsonProperty("assist")
    public Assist assist;
    @JsonProperty("type")
    public String type;
    @JsonProperty("detail")
    public String detail;
    @JsonProperty("comments")
    public String comments;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("time")
    public Time getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Time time) {
        this.time = time;
    }

    @JsonProperty("team")
    public Team getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(Team team) {
        this.team = team;
    }

    @JsonProperty("player")
    public Player getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(Player player) {
        this.player = player;
    }

    @JsonProperty("assist")
    public Assist getAssist() {
        return assist;
    }

    @JsonProperty("assist")
    public void setAssist(Assist assist) {
        this.assist = assist;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
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
