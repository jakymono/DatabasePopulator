package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_eventi;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_partita_evento;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_partite;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.events.Events;
import com.LaboratorioIntegrato.DatabasePopulator.model.api.events.Response;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Eventi;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Partita_Evento;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Partite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Service che gestisce il popolamento di Eventi e Formazioni
 * nel caso di un popolamento simultaneo con eventi vedi : {@link Eventi} e {@link com.LaboratorioIntegrato.DatabasePopulator.model.db.Formazioni}
 */
@Service
public class EventiService {

    @Autowired
    WebClient webClient;

    interfaccia_eventi interfacciaeventi;

    interfaccia_partite interfacciaPartite;

    interfaccia_partita_evento interfaccia_partita_evento;
    FormazioniService formazioniService;

    @Autowired
    public EventiService(interfaccia_eventi interfacciaeventi, interfaccia_partite interfacciaPartite, com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_partita_evento interfaccia_partita_evento, FormazioniService formazioniService) {
        this.interfacciaeventi = interfacciaeventi;
        this.interfacciaPartite = interfacciaPartite;
        this.interfaccia_partita_evento = interfaccia_partita_evento;
        this.formazioniService = formazioniService;
    }


    /**
     * recupera dalle api gli eventi di una data partita
     * @param fixture int partita
     * @return una lista di eventi nel formato delle api
     */
    public List<Events> getEventi(int fixture)
    {
        String uri = "https://v3.football.api-sports.io/fixtures/events?fixture="+fixture;
        Flux<Events> PartiteFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Events.class);
        return PartiteFlux.collectList().block();
    }

    /**
     * prende i dati da {@link #getEventi(int)} e li converte al modello del db vedi : {@link Eventi}
     * @param fixture int della partita
     * @return ResponseEntity con body true se tutto è andato bene o il messaggio di errore in caso contratrio
     */
    public ResponseEntity<?> MettiEventi(int fixture){

        try {
            List<Events> events = getEventi(fixture);
            Events risp = events.get(0);
            List<Response> eventi = risp.getResponse();

            for(Response eve : eventi){

                List<Partite> partite = interfacciaPartite.findAll();
                Partite part = partite.stream()
                        .filter(p->p.id == Integer.parseInt(risp.parameters.fixture))
                        .toList().get(0);

                int minuto;
                if(eve.time.extra != null)
                {
                    minuto = eve.time.elapsed + eve.time.extra;
                }
                else{
                    minuto = eve.time.elapsed;
                }

                Eventi e = new Eventi(minuto,eve.team.id,eve.player.id,eve.assist.name,eve.type,eve.detail,eve.comments);
                interfacciaeventi.save(e);


                interfaccia_partita_evento.save(new Partita_Evento(part.id,e.id));





            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);


    }


    /**
     * metodo che popola sia eventi che formazioni di una singola partita usando
     * {@link #MettiEventi(int)} per gli eventi
     * {@link FormazioniService#mettiFormazioni(int)} per le formazioni
     * @param Giornata string con la giornata corrente nel formato "Regular Season - [numero giornata attuale]"
     * @return ResponseEntity con body true se tutto è andato bene o il messaggio di errore in caso contratrio
     */
    public ResponseEntity<?> popolaEventiFormazioniGiornata(String Giornata){

        try {
            List<Partite> partiteList =  interfacciaPartite.findAll();
            List<Partite> partite = partiteList.stream()
                    .filter(s->s.round.equals(Giornata))
                    .toList();

            for(Partite par:partite){

                System.out.println("inizio attesa");
                TimeUnit.SECONDS.sleep(20);
                formazioniService.mettiFormazioni(par.id);
                MettiEventi(par.id);

            }
        } catch (InterruptedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);

    }


}
