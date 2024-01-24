package com.LaboratorioIntegrato.DatabasePopulator.interfaces;

import com.LaboratorioIntegrato.DatabasePopulator.model.db.Partite;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interfaccia per la tabella partite nel db
 */
public interface interfaccia_partite extends JpaRepository<Partite, Integer> {


}
