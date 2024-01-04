package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre;
import com.LaboratorioIntegrato.DatabasePopulator.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class provaController
{

    SquadraService squadraService;
    @Autowired
    public provaController(SquadraService squadraService) {
        this.squadraService = squadraService;
    }

    @GetMapping("/squadre")
    public List<Squadre> getSquadre()
    {
        return squadraService.RitornaSquadre();
    }

    @GetMapping("/popolaSquadreStadi")
    public ResponseEntity<?> popolaSquadreStadi(){return squadraService.SquadretadioSplit(135,2023);}

}
