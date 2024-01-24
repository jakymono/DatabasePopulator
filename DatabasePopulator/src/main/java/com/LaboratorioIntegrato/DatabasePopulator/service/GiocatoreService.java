package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_squadre;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_statistiche_giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Players;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Response;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Statistic;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Statistiche_Giocatori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Service che gestisce il popolamento di giocatori vedi : {@link Giocatori}
 */
@Service
public class GiocatoreService {
    @Autowired
    WebClient webClient;

    interfaccia_giocatori interfacciaGiocatori;

    interfaccia_statistiche_giocatori interfacciaStatisticheGiocatori;

    interfaccia_squadre interfacciaSquadre;

    @Autowired
    public GiocatoreService(interfaccia_giocatori interfacciaGiocatori, interfaccia_statistiche_giocatori interfacciaStatisticheGiocatori, interfaccia_squadre interfacciaSquadre) {
        this.interfacciaGiocatori = interfacciaGiocatori;
        this.interfacciaStatisticheGiocatori = interfacciaStatisticheGiocatori;
        this.interfacciaSquadre = interfacciaSquadre;
    }

    /**
     * metodo che prende i giocatori e le statistiche dei suddetti dalle api ne formato {@link Players}
     * @param league int del campionato
     * @param season int anno della stagione
     * @param page int pagina dei risultati
     * @return lista di giocatori nel formato delle api
     */
    public List<Players> getGiocatori(int league, int season, int page)
    {
        String uri = "https://v3.football.api-sports.io/players?league="+league+"&season="+season+"&page="+page;
        Flux<Players> PartiteFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Players.class);
        return PartiteFlux.collectList().block();
    }

    /**
     * metodo che per ogni pagina di risposta delle api trasforma i dati nel model per il db vedi : {@link Giocatori} e {@link Statistiche_Giocatori}
     * @param league int id del campionato
     * @param season int anno della stagione
     * @return ResponseEntity con body true se tutto è andato bene o il messaggio di errore in caso contratrio
     */
    public ResponseEntity<?> MettiGiocatori(int league,int season){


        try {
            List<Squadre> squadre =  interfacciaSquadre.findAll();

            List<Players> risposta1 = getGiocatori(league, season, 1);


            System.out.println("inizio attes 60 secondi");
            TimeUnit.SECONDS.sleep(60);
            for (int i = 2; i <= risposta1.get(0).paging.total; i++) {



                System.out.println("inizio attes 20 secondi");
                TimeUnit.SECONDS.sleep(20);
                List<Players> risposta = getGiocatori(league, season, i);
                List<Response> response = risposta.get(0).response;

                Date data = new Date(0000,00,00);

                for (Response pla : response) {
                    if (pla.player.birth.date!=null) {
                        data = Date.valueOf(pla.player.birth.date);
                    }

                    int PlayerId = pla.player.id;
                    System.out.println("id giocatore: "+pla.player.id);

                    ;
                    interfacciaGiocatori.save(new Giocatori(pla.player.id, pla.player.firstname, pla.player.lastname, data, pla.player.nationality, pla.player.height, pla.player.weight, pla.player.injured, pla.player.photo));

                    for(Statistic stat : pla.statistics){

                        List<Squadre> squadre2 = squadre.stream()
                                .filter(s->s.id==stat.team.id)
                                .toList();
                        if(squadre2.isEmpty()){continue;}
                        if(stat.games.rating == null)stat.games.rating="0";

                        System.out.println("id squadra: "+stat.team.id+" id giocatore: "+pla.player.id);
                        interfacciaStatisticheGiocatori.save(new Statistiche_Giocatori(
                                PlayerId,
                                stat.league.season,
                                stat.team.id,
                                stat.games.appearences,
                                stat.games.lineups,
                                stat.games.minutes,
                                stat.games.position,
                                Float.parseFloat(stat.games.rating),
                                stat.substitutes.in,
                                stat.substitutes.out,
                                stat.shots.total,
                                stat.shots.on,
                                stat.goals.total,
                                stat.goals.assists,
                                stat.passes.total,
                                stat.passes.key,
                                stat.tackles.total,
                                stat.tackles.blocks,
                                stat.tackles.interceptions,
                                stat.duels.total,
                                stat.duels.won,
                                stat.dribbles.attempts,
                                stat.dribbles.success,
                                stat.fouls.drawn,
                                stat.fouls.committed,
                                stat.cards.yellow,
                                stat.cards.yellowred,
                                stat.cards.red,
                                stat.penalty.scored,
                                stat.penalty.missed,
                                stat.penalty.saved));

                    }


                }

            }
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
       catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
