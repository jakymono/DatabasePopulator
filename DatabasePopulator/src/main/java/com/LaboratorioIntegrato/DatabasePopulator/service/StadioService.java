package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_stadio;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teams_venues.Response_venue;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teams_venues.Venue;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Stadio;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * servizio per popolare la tabella stadio del db vedi:{@link Stadio}
 */
@Service
public class StadioService {

    interfaccia_stadio interfacciaStadio;

    public StadioService(interfaccia_stadio interfacciaStadio) {
        this.interfacciaStadio = interfacciaStadio;
    }

    /**
     * inserisce gli stadi nella tabella stadi del db vedi:{@link Stadio}
     * @param risposta lista con stadi e squadre
     */
    public void MettiStadi(@NotNull List<Response_venue> risposta) {

        for (Response_venue risp : risposta) {
            Venue venue = risp.venue;
            interfacciaStadio.save(new Stadio(venue.id, venue.name, venue.address, venue.city, venue.capacity, venue.surface, venue.image));
            }
    }
}