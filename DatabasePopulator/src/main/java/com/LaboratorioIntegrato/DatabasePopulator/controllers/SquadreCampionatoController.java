package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.AutomationService;
import com.LaboratorioIntegrato.DatabasePopulator.service.SquadraCampionatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller per {@link SquadraCampionatoService}
 */
@CrossOrigin
@RestController
public class SquadreCampionatoController {

    SquadraCampionatoService squadraCampionatoService;
    AutomationService automationService;

    @Autowired
    public SquadreCampionatoController(SquadraCampionatoService squadraCampionatoService,AutomationService automationService) {
        this.squadraCampionatoService = squadraCampionatoService;
        this.automationService = automationService;
    }

    /**
     * metodo che chiama CollegamentoSquadreCampionato di {@link SquadraCampionatoService}
     * @return ResponseEntity con true se tutto è andato bene e con il messaggio del errore se ci sono stati errori
     */
    @GetMapping("/popolaSquadreCampionati")
    public ResponseEntity<?> popolaSquadreCampionati() {

        return squadraCampionatoService.CollegamentoSquadreCampionato(automationService.AnnoStagione(),135);

    }

}
