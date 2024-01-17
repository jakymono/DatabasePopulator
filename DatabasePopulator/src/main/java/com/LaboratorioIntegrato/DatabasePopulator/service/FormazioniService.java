package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_formazioni;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_giocatori;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_squadre;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.lineups.*;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Formazioni;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Giocatori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@Service
public class FormazioniService {

    @Autowired
    WebClient webClient;
    interfaccia_formazioni interfacciaFormazioni;
    interfaccia_squadre interfacciaSquadre;
    interfaccia_giocatori interfacciaGiocatori;

    @Autowired
    public FormazioniService(interfaccia_formazioni interfacciaFormazioni, interfaccia_squadre interfacciaSquadre, interfaccia_giocatori interfacciaGiocatori) {
        this.interfacciaFormazioni = interfacciaFormazioni;
        this.interfacciaSquadre = interfacciaSquadre;
        this.interfacciaGiocatori = interfacciaGiocatori;
    }

    public List<Lineups> getFormazioni(int fixture)
    {
        String uri = "https://v3.football.api-sports.io/fixtures/lineups?fixture="+fixture;
        Flux<Lineups> PartiteFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Lineups.class);
        return PartiteFlux.collectList().block();
    }

    public ResponseEntity<?> mettiFormazioni(int fixture){

        try {
            List<Lineups> risposta = getFormazioni(fixture);
            Lineups risp = risposta.get(0);
            List<Response> formazioniPartita = risp.response;
            Response casa = formazioniPartita.get(0);
            Response ospiti = formazioniPartita.get(1);

            int id_partita = Integer.parseInt(risp.parameters.fixture);

            String formazione_casa= "";
            for (StartXI sta : casa.startXI)
            {
                Player__1 gio = sta.player;

                Optional<Giocatori> giocatore = interfacciaGiocatori.findById(gio.id);

                String foto = "";
                if(giocatore.isPresent()){foto = giocatore.get().foto;}
                else{foto = "foto non presente";}

                formazione_casa += gio.id+"-"+gio.name+"-"+gio.number+"-"+gio.pos+"-"+foto+",";
            }

            String formazione_ospiti = "";
            for (StartXI sta : ospiti.startXI)
            {
                Player__1 gio = sta.player;

                Optional<Giocatori> giocatore = interfacciaGiocatori.findById(gio.id);

                String foto = "";
                if(giocatore.isPresent()){foto = giocatore.get().foto;}
                else{foto = "foto non presente";}

                formazione_ospiti += gio.id+"-"+gio.name+"-"+gio.number+"-"+gio.pos+"-"+foto+",";
            }

            String sostituti_casa = "";
            for (Substitute sta : casa.substitutes)
            {
                Player__1 gio = sta.player;

                Optional<Giocatori> giocatore = interfacciaGiocatori.findById(gio.id);

                String foto = "";
                if(giocatore.isPresent()){foto = giocatore.get().foto;}
                else{foto = "foto non presente";}

                sostituti_casa += gio.id+"-"+gio.name+"-"+gio.number+"-"+gio.pos+"-"+foto+",";
            }

            String sostituti_ospiti = "";
            for (Substitute sta : casa.substitutes)
            {
                Player__1 gio = sta.player;

                Optional<Giocatori> giocatore = interfacciaGiocatori.findById(gio.id);

                String foto = "";
                if(giocatore.isPresent()){foto = giocatore.get().foto;}
                else{foto = "foto non presente";}

                sostituti_ospiti += gio.id+"-"+gio.name+"-"+gio.number+"-"+gio.pos+"-"+foto+",";
            }
            String allenatore_casa = casa.coach.name+"-"+casa.coach.photo;
            String allenatore_ospite = ospiti.coach.name+"-"+ospiti.coach.photo;

            interfacciaFormazioni.save(new Formazioni(id_partita,casa.team.id,ospiti.team.id,formazione_casa,formazione_ospiti,sostituti_casa,sostituti_ospiti,allenatore_casa,allenatore_ospite,casa.formation,ospiti.formation));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(true,HttpStatus.OK);

    }


}
