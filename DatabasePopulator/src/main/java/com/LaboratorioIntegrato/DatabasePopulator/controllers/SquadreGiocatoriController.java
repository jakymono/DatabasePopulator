package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.AutomationService;
import com.LaboratorioIntegrato.DatabasePopulator.service.GiocatoreService;
import com.LaboratorioIntegrato.DatabasePopulator.service.SquadreGiocatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * controller per {@link SquadreGiocatoriService}
 */
@CrossOrigin
@Controller
public class SquadreGiocatoriController {

    SquadreGiocatoriService squadreGiocatoriService;
    AutomationService automationService;

    @Autowired
    public SquadreGiocatoriController(SquadreGiocatoriService squadreGiocatoriService,AutomationService automationService) {
        this.squadreGiocatoriService = squadreGiocatoriService;
        this.automationService = automationService;
    }


    /**
     * metodo che chiama CollegaSquadreGiocatori di {@link SquadreGiocatoriService}
     * @return ResponseEntity con true se tutto è andato bene e con il messaggio del errore se ci sono stati errori
     */
    @GetMapping("/popolaGiocatorieSquadre")
    public ResponseEntity<?> popolaGiocatorieStatistiche(){
        return squadreGiocatoriService.CollegaSquadreGiocatori(automationService.AnnoStagione());
    }

}
