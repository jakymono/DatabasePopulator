package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.StatisticheSquadraService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class StatisticheSquadraController {

    StatisticheSquadraService squadraService;

    public StatisticheSquadraController(StatisticheSquadraService squadraService) {
        this.squadraService = squadraService;
    }

    @GetMapping("/popolaStatSquadre")
    public ResponseEntity<?> PopolaStatSquadre(){
        return squadraService.MettiStatistiche(135,2023);

    }


}
