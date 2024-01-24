package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Squadre;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * interfaccia per la tabella Squadre nel db
 */
public interface interfaccia_squadre extends JpaRepository<Squadre, Integer> {
}

