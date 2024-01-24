package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_statistiche_squadra;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teamstats.League;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teamstats.Response;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teamstats.Standing;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.teamstats.TeamStats;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Statistiche_Squadre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Service per popolare statistiche_squadre vedi:{@link Statistiche_Squadre}
 */
@Service
public class StatisticheSquadraService {

    @Autowired
    WebClient webClient;
    interfaccia_statistiche_squadra statisticheSquadra;

    @Autowired
    public StatisticheSquadraService(interfaccia_statistiche_squadra statisticheSquadra) {
        this.statisticheSquadra = statisticheSquadra;
    }

    /**
     * prende i dati della classifica dalle api vedi:{@link TeamStats}
     * @param league int id campionato
     * @param season int anno stagione corrente
     * @return un oggetto {@link League}
     */
    public League getStatSquadre(int league,int season)
    {
        String uri = "https://v3.football.api-sports.io/standings?league="+league+"&season="+season;
        Flux<TeamStats> TeamStatsFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(TeamStats.class);
        List<TeamStats> tutto = TeamStatsFlux.collectList().block();
        TeamStats root = tutto.get(0);
        List<Response> risposta = root.response;
        League lega = risposta.get(0).league;

        return lega;
    }

    /**
     * prende i dati da {@link #getStatSquadre(int, int)} e popola squadre_statistiche
     * @param league int id campionato
     * @param season int anno stagione corrente
     * @return ResponseEntity con body true se tutto è andato bene o il messaggio di errore in caso contratrio
     */
    public ResponseEntity<?> MettiStatistiche(int league,int season)
    {
        try{
            League lega = getStatSquadre(league,season);
            int stagione = lega.season;
            List<List<Standing>> classifiche = lega.standings;
            List<Standing> classifica = classifiche.get(0);
            for(Standing pos : classifica){

                statisticheSquadra.save(new Statistiche_Squadre(pos.team.id,stagione, pos.rank, pos.points,pos.goalsDiff,pos.form, pos.description, pos.all.played,pos.all.win,pos.all.draw,pos.all.lose,pos.all.goals._for,pos.all.goals.against));

            }
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }




}
