package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.SquadraCampionatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SquadreCampionatoController {

    SquadraCampionatoService squadraCampionatoService;

    @Autowired
    public SquadreCampionatoController(SquadraCampionatoService squadraCampionatoService) {
        this.squadraCampionatoService = squadraCampionatoService;
    }

    @GetMapping("/popolaSquadreCampionati")
    public ResponseEntity<?> popolaSquadreCampionati() {

        return squadraCampionatoService.CollegamentoSquadreCampionato();

    }

}
