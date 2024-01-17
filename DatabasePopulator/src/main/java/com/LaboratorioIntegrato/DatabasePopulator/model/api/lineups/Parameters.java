
package com.LaboratorioIntegrato.DatabasePopulator.model.api.lineups;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fixture"
})

public class Parameters {

    @JsonProperty("fixture")
    public String fixture;

    @JsonProperty("fixture")
    public String getFixture() {
        return fixture;
    }

    @JsonProperty("fixture")
    public void setFixture(String fixture) {
        this.fixture = fixture;
    }

}
