package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Statistiche_Squadre;
import com.LaboratorioIntegrato.DatabasePopulator.service.AutomationService;
import com.LaboratorioIntegrato.DatabasePopulator.service.StatisticheSquadraService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * controller per {@link StatisticheSquadraService}
 */
@Controller
@CrossOrigin
public class StatisticheSquadraController {

    StatisticheSquadraService squadraService;
    AutomationService automationService;


    public StatisticheSquadraController(StatisticheSquadraService squadraService,    AutomationService automationService) {
        this.squadraService = squadraService;
        this.automationService = automationService;
    }

    /**
     * Metodo che chiama MettiStatistiche di  {@link StatisticheSquadraService}
     * @return ResponseEntity con true se tutto è andato bene e con il messaggio del errore se ci sono stati errori
     */
    @GetMapping("/popolaStatSquadre")
    public ResponseEntity<?> PopolaStatSquadre(){
        return squadraService.MettiStatistiche(135, automationService.AnnoStagione());

    }


}
