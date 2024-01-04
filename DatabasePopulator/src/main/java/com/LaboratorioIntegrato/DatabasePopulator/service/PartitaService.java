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
import java.util.ArrayList;
import java.util.List;

@Service
public class PartitaService {

    @Autowired
    WebClient webClient;

    interfaccia_partite interfacciaPartite;

    public PartitaService(interfaccia_partite interfacciaPartite) {
        this.interfacciaPartite = interfacciaPartite;
    }

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

    public ResponseEntity<?> MettiPartite(int league, int season){

        List<Integer> partit = new ArrayList<>();
        try{


            List<Response> partite = getPartite(league, season);
            for(Response par:partite){

                    partit.add(par.fixture.id);
                    if(par.fixture.venue.id==20299){par.fixture.venue.id=20416;}
                    interfacciaPartite.save(new Partite(par.fixture.id,par.teams.home.id,par.teams.away.id,par.fixture.venue.id,league,par.fixture.referee,new Timestamp(par.fixture.timestamp* 1000L),par.fixture.status._short,par.goals.home,par.goals.away,par.score.extratime.home,par.score.extratime.away,par.score.penalty.home,par.score.penalty.away));

            }
            return new ResponseEntity<>(partit.size(),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
