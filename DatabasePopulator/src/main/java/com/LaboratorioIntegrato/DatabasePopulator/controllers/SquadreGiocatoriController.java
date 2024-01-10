package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.GiocatoreService;
import com.LaboratorioIntegrato.DatabasePopulator.service.SquadreGiocatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class SquadreGiocatoriController {

    SquadreGiocatoriService squadreGiocatoriService;

    @Autowired
    public SquadreGiocatoriController(SquadreGiocatoriService squadreGiocatoriService) {
        this.squadreGiocatoriService = squadreGiocatoriService;
    }




    @GetMapping("/popolaGiocatorieSquadre")
    public ResponseEntity<?> popolaGiocatorieStatistiche(){
        return squadreGiocatoriService.CollegaSquadreGiocatori(2023                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             );
    }

}
