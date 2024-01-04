
package com.LaboratorioIntegrato.DatabasePopulator.model.api.players;

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
    "name",
    "firstname",
    "lastname",
    "age",
    "birth",
    "nationality",
    "height",
    "weight",
    "injured",
    "photo"
})

public class Player {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("firstname")
    public String firstname;
    @JsonProperty("lastname")
    public String lastname;
    @JsonProperty("age")
    public Integer age;
    @JsonProperty("birth")
    public Birth birth;
    @JsonProperty("nationality")
    public String nationality;
    @JsonProperty("height")
    public String height;
    @JsonProperty("weight")
    public String weight;
    @JsonProperty("injured")
    public Boolean injured;
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
