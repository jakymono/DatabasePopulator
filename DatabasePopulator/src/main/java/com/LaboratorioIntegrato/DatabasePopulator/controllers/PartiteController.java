package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.PartitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class PartiteController
{

    PartitaService partitaService;

    @Autowired
    public PartiteController(PartitaService partitaService) {
        this.partitaService = partitaService;
    }




    @GetMapping("/popolaPartite")
    public ResponseEntity<?> popolaSquadreStadi(){return partitaService.MettiPartite(135,2023);}

}
