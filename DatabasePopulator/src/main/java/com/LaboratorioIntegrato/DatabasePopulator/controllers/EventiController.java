package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.service.EventiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EventiController {

    EventiService eventiService;

    @Autowired
    public EventiController(EventiService eventiService) {
        this.eventiService = eventiService;
    }

    @GetMapping("events")
    public ResponseEntity<?> mettiEventi(@RequestParam int fixture)
    {
        return eventiService.MettiEventi(fixture);
    }

}
