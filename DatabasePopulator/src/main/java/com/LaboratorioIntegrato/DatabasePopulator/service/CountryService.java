package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.model.Example;
import com.LaboratorioIntegrato.DatabasePopulator.model.League;
import com.LaboratorioIntegrato.DatabasePopulator.model.Response;
import com.LaboratorioIntegrato.DatabasePopulator.model.Standing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    WebClient webClient;

    public Flux<Example> getStandings() {
        return webClient.get()
                .uri("https://v3.football.api-sports.io/standings?league=135&season=2023")
                .retrieve()
                .bodyToFlux(Example.class);
    }

    public List<List<Standing>> getClassifica()
    {
        Flux<Example> classificaFlux = webClient.get()
                .uri("https://v3.football.api-sports.io/standings?league=135&season=2023")
                .retrieve()
                .bodyToFlux(Example.class);
        List<Example> tutto = classificaFlux.collectList().block();
        Example esempio = tutto.get(0);
        List<Response> risposta = esempio.getResponse();
        League lega = risposta.get(0).getLeague();
        List<List<Standing>> classifica = lega.getStandings();
        return classifica;
    }

}