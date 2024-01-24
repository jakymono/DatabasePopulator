package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_squadre;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teams_venues.Response_venue;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teams_venues.Root_venue;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teams_venues.Team;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
@Service
/**
 * Servizio per gestire il popolamendo della tabella squadre vedi : {@link Squadre}
 */
public class SquadraService {

    @Autowired
    WebClient webClient;
    interfaccia_squadre interfacciasquadre;
    StadioService stadioService;

    @Autowired
    public SquadraService(interfaccia_squadre interfacciasquadre, StadioService stadioService) {
        this.interfacciasquadre = interfacciasquadre;
        this.stadioService = stadioService;

    }

    /**
     * il metodo prende i dati di stadi e squadre dalle api vedi : {@link Root_venue}
     * @param league int id campionato
     * @param season int anno stagione corrente
     * @return Lista con i dati di stadi e squadre nel formato di {@link Response_venue}
     */
    public List<Response_venue> getSquadreStadi(int league,int season)
    {
        String uri = "https://v3.football.api-sports.io/teams?league="+league+"&season="+season;
        Flux<Root_venue> SquadreStadiFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Root_venue.class);
        List<Root_venue> tutto = SquadreStadiFlux.collectList().block();
        Root_venue root = tutto.get(0);
        List<Response_venue> risposta = root.response;
        return risposta;
    }

    /**
     * dato che le api restuiscono stadi e squadre insieme questo metodo manda i dati a {@link #MettiSquadre(List)} e  {@link StadioService#MettiStadi(List)}
     * @param league int id campionato
     * @param season int anno stagione corrente
     * @return ResponseEntity con body true se tutto è andato bene o il messaggio di errore in caso contratrio
     */
    public ResponseEntity<?> SquadretadioSplit(int league,int season)
    {
        try {

            List<Response_venue> risposta = getSquadreStadi(league,season);
            stadioService.MettiStadi(risposta);

            MettiSquadre(risposta);

            return new ResponseEntity<>(true,HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }


    /**
     * popola la tabella del db Squadre con le squadre in risposta
     * @param risposta Lista di stadi e Squadre
     */
    public void MettiSquadre(@NotNull List<Response_venue> risposta) {

            for (Response_venue risp : risposta) {
                Team team = risp.team;
                interfacciasquadre.save(new Squadre(team.id, team.name,team.code,risp.venue.id , team.country, team.founded,team.national,team.logo));
            }
    }



}
