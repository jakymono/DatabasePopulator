
package com.LaboratorioIntegrato.DatabasePopulator.model.api.lineups;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "primary",
    "number",
    "border"
})

public class Goalkeeper {

    @JsonProperty("primary")
    public String primary;
    @JsonProperty("number")
    public String number;
    @JsonProperty("border")
    public String border;

    @JsonProperty("primary")
    public String getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(String primary) {
        this.primary = primary;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("border")
    public String getBorder() {
        return border;
    }

    @JsonProperty("border")
    public void setBorder(String border) {
        this.border = border;
    }

}
