package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.AutomationService;
import com.LaboratorioIntegrato.DatabasePopulator.service.PartitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller per {@link PartitaService}
 */
@CrossOrigin
@RestController
public class PartiteController
{

    PartitaService partitaService;
    AutomationService automationService;

    @Autowired
    public PartiteController(PartitaService partitaService,AutomationService automationService) {
        this.partitaService = partitaService;
        this.automationService = automationService;
    }

    /**
     * metodo per chiamare MettiPartite() di {@link PartitaService} e popolare la tabella partite
     * @return @return ResponseEntity con true se tutto è andato bene e con il messaggio del errore se ci sono stati errori
     */
    @GetMapping("/popolaPartite")
    public ResponseEntity<?> popolaSquadreStadi(){return partitaService.MettiPartite(135, automationService.AnnoStagione());}

}
