package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_stadio;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teams_venues.Response_venue;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teams_venues.Venue;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StadioService {

    interfaccia_stadio interfacciaStadio;

    public StadioService(interfaccia_stadio interfacciaStadio) {
        this.interfacciaStadio = interfacciaStadio;
    }


    public void MettiStadi(@NotNull List<Response_venue> risposta) {

        for (Response_venue risp : risposta) {
            Venue venue = risp.venue;
            interfacciaStadio.InserisciStadio(venue.id, venue.name, venue.address, venue.city, venue.capacity, venue.surface, venue.image);
        }
    }
}