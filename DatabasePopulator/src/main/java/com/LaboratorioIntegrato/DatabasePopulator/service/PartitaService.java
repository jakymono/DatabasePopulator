package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_partite;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.fixtures.Fixtures;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.fixtures.Response;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Partite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.sql.Timestamp;
import java.util.List;

/**
 * servizio che gestisce il popolamento della tabella partite vedi:{@link Partite}
 */
@Service
public class PartitaService {

    @Autowired
    WebClient webClient;

    interfaccia_partite interfacciaPartite;

    public PartitaService(interfaccia_partite interfacciaPartite) {
        this.interfacciaPartite = interfacciaPartite;
    }

    /**
     * metodo che prende le partite dalle api con il formato di {@link Fixtures}
     * @param league int del campionato
     * @param season int anno della stagione
     * @return lista delle partite nel formato delle api
     */
    public List<Response> getPartite(int league, int season)
    {
        String uri = "https://v3.football.api-sports.io/fixtures?league="+league+"&season="+season;
        Flux<Fixtures> PartiteFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Fixtures.class);
        List<Fixtures> tutto = PartiteFlux.collectList().block();
        List<Response> risposta = tutto.get(0).response;
        return risposta;
    }


    /**
     * metodo che prende le partite da {@link #getPartite(int, int)} e le trasforma nel model per il db vedi {@link Partite}
     * @param league int id del campionato
     * @param season int anno della stagione
     * @return ResponseEntity con body true se tutto è andato bene o il messaggio di errore in caso contratrio
     */
    public ResponseEntity<?> MettiPartite(int league, int season){

        try{

            List<Response> partite = getPartite(league, season);
            for(Response par:partite){


                    if(par.fixture.venue.id==20299){par.fixture.venue.id=20416;}
                    interfacciaPartite.save(new Partite(par.fixture.id,par.teams.home.id,par.teams.away.id,par.fixture.venue.id,league,par.fixture.referee,par.league.round,season,new Timestamp(par.fixture.timestamp* 1000L),par.fixture.status._short,par.goals.home,par.goals.away,par.score.extratime.home,par.score.extratime.away,par.score.penalty.home,par.score.penalty.away));

            }
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
