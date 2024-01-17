package com.LaboratorioIntegrato.DatabasePopulator.controllers;



import com.LaboratorioIntegrato.DatabasePopulator.service.ArticoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticoliController {

    ArticoliService articoliService;

    @Autowired
    public ArticoliController(ArticoliService articoliService) {
        this.articoliService = articoliService;
    }

    @GetMapping("/news")
    public ResponseEntity<?> Campionati(){ return articoliService.Articoli() ;}

    @GetMapping("/newsid")
    public ResponseEntity<?> Campionato(@RequestParam int id){ return articoliService.Articolo(id);}
}
