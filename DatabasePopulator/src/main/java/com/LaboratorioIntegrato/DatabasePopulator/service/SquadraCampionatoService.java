package com.LaboratorioIntegrato.DatabasePopulator.service;

import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_squadre;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_squadre_campionato;
import com.LaboratorioIntegrato.DatabasePopulator.interfaces.interfaccia_statistiche_squadra;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Statistiche_Squadre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Campionato_squadre;

import java.util.List;

@Service
public class SquadraCampionatoService {

    interfaccia_squadre_campionato interfacciaSquadreCampionato;
    interfaccia_squadre interfacciaSquadre;
    interfaccia_statistiche_squadra interfacciaStatisticheSquadra;

    @Autowired
    public SquadraCampionatoService(interfaccia_squadre_campionato interfacciaSquadreCampionato, interfaccia_squadre interfacciaSquadre , interfaccia_statistiche_squadra interfacciaStatisticheSquadra) {
        this.interfacciaSquadreCampionato = interfacciaSquadreCampionato;
        this.interfacciaSquadre = interfacciaSquadre;
        this.interfacciaStatisticheSquadra = interfacciaStatisticheSquadra;

    }




    public ResponseEntity<?> CollegamentoSquadreCampionato(int stagione,int campionato)
    {

        try {

            List<Squadre> squadre = interfacciaSquadre.findAll();
            List<Statistiche_Squadre> stats= interfacciaStatisticheSquadra.findAll();

            for(Squadre sqa: squadre){

                Statistiche_Squadre stat = stats.stream()
                        .filter(oggetto -> oggetto.getId_squadra() == sqa.id && oggetto.getStagione() == stagione)
                        .findFirst()
                        .orElse(null);

                if(stat != null){

                    interfacciaSquadreCampionato.save(new Campionato_squadre(campionato,sqa.id,stagione));

                }

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(true, HttpStatus.OK );
    }
}
