package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.AutomationService;
import com.LaboratorioIntegrato.DatabasePopulator.service.EventiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * COntroller per {@link EventiService}
 */
@RestController
@CrossOrigin
public class EventiController {

    EventiService eventiService;
    AutomationService automationService;


    @Autowired
    public EventiController(EventiService eventiService,AutomationService automationService) {
        this.eventiService = eventiService;
        this.automationService = automationService;
    }

    /**
     * Metodo che chiama MettiEventi di {@link EventiService}
     * @param fixture id della partita da popolare
     * @return ResponseEntity con true se tutto è andato bene e con il messaggio del errore se ci sono stati errori
     */
    @GetMapping("events")
    public ResponseEntity<?> mettiEventi(@RequestParam int fixture)
    {
        return eventiService.MettiEventi(fixture);
    }

    /**
     * Metodo che chiama popolaEventiFormazioni() di {@link EventiService}
     * @return ResponseEntity con true se tutto è andato bene e con il messaggio del errore se ci sono stati errori
     */
    @GetMapping("eventsLineups")
    public ResponseEntity<?> mettiEventiFormazioni() {return eventiService.popolaEventiFormazioniGiornata(automationService.getRound());}

}
