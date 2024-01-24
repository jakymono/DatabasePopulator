package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.LaboratorioIntegrato.DatabasePopulator.model.db.Campionato_squadre;

/**
 * interfaccia per la tabella campionato_squadre nel db
 */
public interface interfaccia_squadre_campionato extends JpaRepository<Campionato_squadre,Integer> {

}
