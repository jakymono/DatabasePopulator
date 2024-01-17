package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.FormazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FormazioniController {

    FormazioniService formazioniService;

    @Autowired
    public FormazioniController(FormazioniService formazioniService) {
        this.formazioniService = formazioniService;
    }

    @GetMapping("/lineups")
    public ResponseEntity<?> Formazioni(@RequestParam int fixture) {

        return formazioniService.mettiFormazioni(fixture);

    }

}
