package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre;
import com.LaboratorioIntegrato.DatabasePopulator.service.AutomationService;
import com.LaboratorioIntegrato.DatabasePopulator.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller per {@link SquadraService}
 */
@CrossOrigin
@RestController
public class SquadreController
{

    SquadraService squadraService;
    AutomationService automationService;
    @Autowired
    public SquadreController(SquadraService squadraService,AutomationService automationService) {
        this.squadraService = squadraService;
        this.automationService = automationService;
    }

    /**
     *metodo che chiama SquadreStadioSplit di {@link SquadraService} e popola il db con squadre e stadi
     * @return ResponseEntity con true se tutto è andato bene e con il messaggio del errore se ci sono stati errori
     */
    @GetMapping("/popolaSquadreStadi")
    public ResponseEntity<?> popolaSquadreStadi(){return squadraService.SquadretadioSplit(135, automationService.AnnoStagione());}


}
