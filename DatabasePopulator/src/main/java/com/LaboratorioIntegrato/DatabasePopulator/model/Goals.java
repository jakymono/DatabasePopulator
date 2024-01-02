package com.LaboratorioIntegrato.DatabasePopulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Goals {
    @JsonProperty("for")
    public int getMyfor() {
        return this.myfor;
    }

    public void setMyfor(int myfor) {
        this.myfor = myfor;
    }

    int myfor;

    @JsonProperty("against")
    public int getAgainst() {
        return this.against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }

    int against;
}
