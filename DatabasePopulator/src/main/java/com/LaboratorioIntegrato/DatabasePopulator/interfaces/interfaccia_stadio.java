package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Stadio;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * interfaccia per la tabella Stadio nel db
 */
public interface interfaccia_stadio extends JpaRepository<Stadio, Integer> {
}
