package com.LaboratorioIntegrato.DatabasePopulator.interfaces;


import com.LaboratorioIntegrato.DatabasePopulator.model.db.Statistiche_Squadre;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * interfaccia per la tabella statistiche_squadre nel db
**/
public interface interfaccia_statistiche_squadra extends JpaRepository<Statistiche_Squadre, Integer> {

}
