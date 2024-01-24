package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.model.api.round.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;


/**
 * Servizio per automatizzare i parametri dell'anno e della gioranata corrente
 */
@Service
public class AutomationService {


    @Autowired
    WebClient webClient;
    EventiService eventiService;
    FormazioniService formazioniService;
    GiocatoreService giocatoreService;
    PartitaService partitaService;
    SquadraCampionatoService squadraCampionatoService;
    SquadraService squadraService;
    SquadreGiocatoriService squadreGiocatoriService;
    StadioService stadioService;
    StatisticheSquadraService statisticheSquadraService;

    @Autowired
    public AutomationService(EventiService eventiService, FormazioniService formazioniService, GiocatoreService giocatoreService, PartitaService partitaService, SquadraCampionatoService squadraCampionatoService, SquadraService squadraService, SquadreGiocatoriService squadreGiocatoriService, StadioService stadioService, StatisticheSquadraService statisticheSquadraService) {
        this.eventiService = eventiService;
        this.formazioniService = formazioniService;
        this.giocatoreService = giocatoreService;
        this.partitaService = partitaService;
        this.squadraCampionatoService = squadraCampionatoService;
        this.squadraService = squadraService;
        this.squadreGiocatoriService = squadreGiocatoriService;
        this.stadioService = stadioService;
        this.statisticheSquadraService = statisticheSquadraService;
    }


    /**
     * metodo per ottenere la stagione calcicstia attuale
     * la stagione resta quella del 2023 anche se siamo a inizio 2024 ad esempio
     * @return in con la stagione corrente
     */
    public int AnnoStagione(){

        int annoCorrente = Year.now().getValue();
        int meseCorrente = LocalDate.now().getMonthValue();

        if (meseCorrente < 8)
        {
            return annoCorrente-1;
        }
        else{

            return annoCorrente;
        }

    }


    /**
     * metodo che utilizza le api per ottenere la giornata attuale
     * @return String con la giornata corrente nel formato "Regular Season - [numero giornata attuale]"
     */
    public String getRound()
    {
        String uri = "https://v3.football.api-sports.io/fixtures/rounds?current=true&league=135&season=2023";
        Flux<Round> PartiteFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Round.class);
        List<Round> risposta =  PartiteFlux.collectList().block();
        Round round = risposta.get(0);
        return round.response.get(0);
    }



}
