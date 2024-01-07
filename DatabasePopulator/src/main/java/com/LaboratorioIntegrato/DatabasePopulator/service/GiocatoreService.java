package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_statistiche_giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Players;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Response;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players.Statistic;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Giocatori;
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

@Service
public class GiocatoreService {
    @Autowired
    WebClient webClient;

    interfaccia_giocatori interfacciaGiocatori;

    interfaccia_statistiche_giocatori interfacciaStatisticheGiocatori;

    @Autowired
    public GiocatoreService(interfaccia_giocatori interfacciaGiocatori,interfaccia_statistiche_giocatori interfacciaStatisticheGiocatori) {
        this.interfacciaGiocatori = interfacciaGiocatori;
        this.interfacciaStatisticheGiocatori = interfacciaStatisticheGiocatori;
    }

    public List<Players> getPartite(int league, int season, int page)
    {
        String uri = "https://v3.football.api-sports.io/players?league="+league+"&season="+season+"&page="+page;
        Flux<Players> PartiteFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Players.class);
        return PartiteFlux.collectList().block();
    }

    public ResponseEntity<?> MettiGiocatori(int league,int season){


        try {

            List<Players> risposta1 = getPartite(league, season, 1);

            TimeUnit.MINUTES.sleep(2);
            for (int i = 2; i <= risposta1.get(0).paging.total; i++) {


                List<Players> risposta = getPartite(league, season, i);
                List<Response> response = risposta.get(0).response;

                Date data = new Date(0000,00,00);

                for (Response pla : response) {
                    if (pla.player.birth.date!=null) {
                        data = Date.valueOf(pla.player.birth.date);
                    }

                    int PlayerId = pla.player.id;
                    interfacciaGiocatori.save(new Giocatori(pla.player.id, pla.player.firstname, pla.player.lastname, data, pla.player.nationality, pla.player.height, pla.player.weight, pla.player.injured, pla.player.photo));

                    for(Statistic stat : pla.statistics){

                        if(stat.games.rating == null)stat.games.rating="0";

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
