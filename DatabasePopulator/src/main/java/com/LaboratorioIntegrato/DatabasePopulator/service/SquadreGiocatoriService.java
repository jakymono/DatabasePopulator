package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_squadre_campionato;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_squadre_giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players_team.Player;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players_team.PlayerTeams;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.players_team.Response;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Campionato_squadre;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre_giocatori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SquadreGiocatoriService {

    interfaccia_squadre_campionato interfacciaSquadreCampionato;
    interfaccia_squadre_giocatori interfacciaSquadreGiocatori;

    interfaccia_giocatori interfacciaGiocatori;

    @Autowired
    WebClient webClient;


    @Autowired
    public SquadreGiocatoriService(interfaccia_squadre_campionato interfacciaSquadreCampionato, interfaccia_squadre_giocatori interfacciaSquadreGiocatori, interfaccia_giocatori interfacciaGiocatori) {
        this.interfacciaSquadreCampionato = interfacciaSquadreCampionato;
        this.interfacciaSquadreGiocatori = interfacciaSquadreGiocatori;
        this.interfacciaGiocatori = interfacciaGiocatori;
    }




    public List<Player> getGiocatoriSquadra(int team)
    {
        String uri = "https://v3.football.api-sports.io/players/squads?team="+team;
        Flux<PlayerTeams> PlayersFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(PlayerTeams.class);
        List<PlayerTeams> tutto = PlayersFlux.collectList().block();
        List<Response> risposta = tutto.get(0).response;
        return risposta.get(0).players;
    }

    public ResponseEntity<?> CollegaSquadreGiocatori(int stagione)
    {

        try {
            List<Campionato_squadre> squadre = interfacciaSquadreCampionato.findAll();
            List<Campionato_squadre> squadreStagione = squadre.stream()
                    .filter(s -> s.stagione == stagione)
                    .toList();
            List<Giocatori> giocatoriTest = interfacciaGiocatori.findAll();

            for(Campionato_squadre sqa : squadreStagione)
            {
                List<Player> giocatori = getGiocatoriSquadra(sqa.id_squadra);
                System.out.println("inizio attesa 10 sec");
                TimeUnit.SECONDS.sleep(10);

                for(Player pla : giocatori){

                    List<Giocatori> giocatoriFIlter = giocatoriTest.stream()
                            .filter(g->g.id == pla.id)
                            .toList();
                    if(giocatoriFIlter.isEmpty()){continue;}

                    Squadre_giocatori gioSqua = new Squadre_giocatori(sqa.id_squadra, pla.id, stagione,true);
                    List<Squadre_giocatori> collegamenti = interfacciaSquadreGiocatori.findAll();

                    List<Squadre_giocatori> vecchi_collegamenti = collegamenti.stream()
                            .filter(c->c.attuale == true && c.id_giocatore == pla.id)
                            .toList();
                    for(Squadre_giocatori sqaGio : vecchi_collegamenti) {

                        if(sqaGio.id_squadra != sqa.id_squadra){

                            interfacciaSquadreGiocatori.delete(sqaGio);
                            interfacciaSquadreGiocatori.save(new Squadre_giocatori(sqaGio.id_squadra,sqaGio.id_giocatore,gioSqua.stagione,false));

                        }

                    }

                    interfacciaSquadreGiocatori.save(gioSqua);


                }
            }

            return new ResponseEntity<>(true,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
