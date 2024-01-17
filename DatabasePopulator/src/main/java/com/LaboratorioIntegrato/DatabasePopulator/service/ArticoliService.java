package com.LaboratorioIntegrato.DatabasePopulator.service;


import com.LaboratorioIntegrato.DatabasePopulator.interfaces.ArticoliRepository;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Articoli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticoliService {

    private final ArticoliRepository articoliRepository;
    @Autowired
    public ArticoliService(ArticoliRepository copiaRepository) {
        this.articoliRepository = copiaRepository;
    }

    public ResponseEntity<?> Articoli(){
        List<Articoli> lista=articoliRepository.findAll();
        if(lista.isEmpty()){
            return new ResponseEntity<>("Nessun articolo", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    public ResponseEntity<?> Articolo(int id){
        List<Articoli> lista = articoliRepository.findAll();
        if(lista.isEmpty()){
            return new ResponseEntity<>("Nessun Articolo", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
}
