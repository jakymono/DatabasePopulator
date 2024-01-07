package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.GiocatoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class GiocatoriController {

    GiocatoreService giocatoreService;

    @Autowired
    public GiocatoriController(GiocatoreService giocatoreService) {
        this.giocatoreService = giocatoreService;
    }

    @GetMapping("/popolaGiocatorieStatistiche")
    public ResponseEntity<?> popolaGiocatorieStatistiche(){
        return giocatoreService.MettiGiocatori(135,2023);
    }

}
