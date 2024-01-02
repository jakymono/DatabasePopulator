package com.LaboratorioIntegrato.DatabasePopulator.controllers;

import com.LaboratorioIntegrato.DatabasePopulator.model.Standing;
import com.LaboratorioIntegrato.DatabasePopulator.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class provaController
{

    CountryService countryService;
    @Autowired
    public provaController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/prova")
    public List<List<Standing>> getCountry1() {

        return countryService.getClassifica();

    }
}
