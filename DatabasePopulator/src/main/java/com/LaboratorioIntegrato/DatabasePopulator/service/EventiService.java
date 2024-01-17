package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.EventiRepository;
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

@Service
public class EventiService {

    @Autowired
    WebClient webClient;

    EventiRepository eventiRepository;

    interfaccia_partite interfacciaPartite;

    interfaccia_partita_evento interfaccia_partita_evento;

    @Autowired
    public EventiService(EventiRepository eventiRepository, interfaccia_partite interfacciaPartite, com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_partita_evento interfaccia_partita_evento) {
        this.eventiRepository = eventiRepository;
        this.interfacciaPartite = interfacciaPartite;
        this.interfaccia_partita_evento = interfaccia_partita_evento;
    }








    public List<Events> getEventi(int fixture)
    {
        String uri = "https://v3.football.api-sports.io/fixtures/events?fixture="+fixture;
        Flux<Events> PartiteFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Events.class);
        return PartiteFlux.collectList().block();
    }

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
                eventiRepository.save(e);


                interfaccia_partita_evento.save(new Partita_Evento(part.id,e.id));





            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);


    }


}
